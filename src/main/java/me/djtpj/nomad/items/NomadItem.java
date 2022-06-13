package me.djtpj.nomad.items;

import lombok.Getter;
import lombok.Setter;
import me.djtpj.nomad.events.NomadListener;
import me.djtpj.nomad.events.block.BlockBreakListener;
import me.djtpj.nomad.events.block.BlockPlaceListener;
import me.djtpj.nomad.events.food.ItemConsumeListener;
import me.djtpj.nomad.items.meta.MetaAttributeOperator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class NomadItem extends ItemStack implements Listener {
    protected String name;

    @Getter
    @Setter
    protected NomadListener[] listeners = {};

    @Getter
    @Setter
    private boolean placeable = true, edible = true, breakBlocks = true;

    /**
     * @param type Material that the item should be made of
     * @param name name of the item
     */
    public NomadItem(Material type, String name) {
        super(type);

        setName(name);

        addListener(new BlockPlaceListener(this) {
            @Override
            public void onEvent(BlockPlaceEvent event) {
                event.setCancelled(!placeable);
            }
        });

        addListener(new ItemConsumeListener(this) {
            @Override
            public void onEvent(PlayerItemConsumeEvent event) {
                event.setCancelled(!edible);
            }
        });

        addListener(new BlockBreakListener(this) {
            @Override
            public void onEvent(BlockBreakEvent event) {
                event.setCancelled(!breakBlocks);
            }
        });
    }

    /**
     * @param type Material that the item should be made of
     */
    public NomadItem(Material type) {
        super(type);
    }

    /**
     * @param listener the listener that should be associated with this item
     */
    public void addListener(NomadListener listener) {
        ArrayList<NomadListener> results = new ArrayList<>(Arrays.asList(listeners));

        results.add(listener);

        listeners = results.toArray(new NomadListener[0]);
    }

    /** Function for editing the MetaData of this item more easily
     * @param operator the metadata operation you want to run
     * @return the success of this operation
     * @see MetaAttributeOperator
     */
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

    /**
     * @param name the new name of this item
     */
    public void setName(String name) {
        this.name = name;

        changeMeta(m -> m.setDisplayName(this.name));
    }

    protected void debugMessage(String msg) {
        Bukkit.broadcastMessage(msg);
    }

    /** Allows for easy item comparison
     * @param obj the object to compare
     * @return whether this matches or not
     */
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
