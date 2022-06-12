package me.djtpj.nomad.events.damage;

import me.djtpj.nomad.events.Manager;
import me.djtpj.nomad.events.NomadListener;
import me.djtpj.nomad.items.NomadItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public abstract class HeldDamageListener implements NomadListener<EntityDamageEvent>, Listener {

     final NomadItem item;

    public HeldDamageListener(NomadItem item) {
        this.item = item;

        Manager.getInstance().registerEvent(this);
    }

    @EventHandler
    public void onDamageTaken(EntityDamageEvent event) {
        if (validate(event, item)) {
            onEvent(event);
        }
    }

    @Override
    public boolean validate(EntityDamageEvent event, NomadItem item) {
        if (!(event.getEntity() instanceof Player)) return false;

        Player player = (Player) event.getEntity();

        if (!(item.equals(player.getInventory().getItemInMainHand()))) return false;

        return true;
    }
}