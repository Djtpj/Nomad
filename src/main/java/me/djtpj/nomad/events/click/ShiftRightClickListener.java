package me.djtpj.nomad.events.click;

import me.djtpj.nomad.items.NomadItem;
import org.bukkit.event.block.Action;

/**
 * Listener for when the player shift right clicks while holding the specified item
 */
public abstract class ShiftRightClickListener extends ShiftClickListener {
    public ShiftRightClickListener(NomadItem item) {
        super(item, Action.RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK);
    }
}
