package me.djtpj.nomad.items;

import lombok.Getter;
import lombok.Setter;
import me.djtpj.nomad.events.NomadListener;
import me.djtpj.nomad.items.meta.MetaAttributeOperator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;


public abstract class NomadItem extends ItemStack implements Listener {
    String name;

    @Getter
    @Setter
    NomadListener[] listeners = {};

    public NomadItem(Material type, String name) {
        super(type);

        setName(name);
    }

    public void addListener(NomadListener listener) {
        ArrayList<NomadListener> results = new ArrayList<>(Arrays.asList(listeners));

        results.add(listener);

        listeners = results.toArray(new NomadListener[0]);
    }

    public boolean changeMeta(MetaAttributeOperator operator) {

        boolean succeeded = setItemMeta(operator.run(getItemMeta()));

        return succeeded;

    }

    /** Adds an enchantment
     *  Ignores regular level restriction
     * @param ench  Enchantment to add
     * @param level Level of the enchantment
     */
    @Override
    public void addEnchantment(Enchantment ench, int level) {
        changeMeta(m -> m.addEnchant(ench, level, true));
    }

    public void setName(String name) {
        this.name = name;

        changeMeta(m -> m.setDisplayName(this.name));
    }

    protected void debugMessage(String msg) {
        Bukkit.broadcastMessage(msg);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;

        if (!(obj instanceof ItemStack)) return false;

        ItemStack item = (ItemStack) obj;

        if (item.getItemMeta() != null) {
            if (!item.getItemMeta().equals(this.getItemMeta())) return false;

            if (!item.getEnchantments().equals(this.getEnchantments())) return false;

            if (!item.getType().equals(this.getType())) return false;

            if (!item.getItemMeta().isUnbreakable() == this.getItemMeta().isUnbreakable()) return false;

            return true;
        }

        return false;

    }
}
