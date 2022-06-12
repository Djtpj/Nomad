package me.djtpj.nomad.events.click;

import me.djtpj.nomad.items.NomadItem;
import org.bukkit.event.block.Action;

/**
 * Listener for when a player right clicks while holding the item
 */
public abstract class RightClickListener extends ClickListener {

    public RightClickListener(NomadItem item) {
        super(item, Action.RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK);
    }
}
