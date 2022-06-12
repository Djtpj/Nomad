package me.djtpj.nomad.events.click;

import me.djtpj.nomad.items.NomadItem;
import org.bukkit.event.block.Action;

/**
 * Listener for when a player shift clicks the air while holding the specified item
 */
public abstract class ShiftClickAirListener extends ShiftClickListener {
    public ShiftClickAirListener(NomadItem item) {
        super(item, Action.RIGHT_CLICK_AIR, Action.LEFT_CLICK_AIR);
    }
}
