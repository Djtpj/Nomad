package me.djtpj.nomad.events.click;

import me.djtpj.nomad.items.NomadItem;
import org.bukkit.event.block.Action;

/**
 * Listener for when a player shift left clicks while holding the specified item
 */
public abstract class ShiftLeftClickListener extends ShiftClickListener {
    public ShiftLeftClickListener(NomadItem item) {
        super(item, Action.LEFT_CLICK_AIR, Action.LEFT_CLICK_BLOCK);
    }
}
