package me.djtpj.nomad.events.damage;

import me.djtpj.nomad.events.Manager;
import me.djtpj.nomad.events.NomadListener;
import me.djtpj.nomad.items.NomadItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 * Listener that fires when a player deals damage using this item
 */
public abstract class DamageDealtListener extends NomadListener<EntityDamageByEntityEvent> {

    final NomadItem item;

    public DamageDealtListener(NomadItem item) {
        this.item = item;

        Manager.getInstance().registerEvent(this);
    }

    @EventHandler
    public void onDamageDealt(EntityDamageByEntityEvent event) {
        if (validate(event, item)) {
            onEvent(event);
        }
    }

    @Override
    public boolean validate(EntityDamageByEntityEvent event, NomadItem item) {
        if (!(event.getDamager() instanceof Player)) return false;
        Player player = (Player) event.getDamager();

        if (!(item.equals(player.getInventory().getItemInMainHand()))) return false;

        return true;
    }
}
