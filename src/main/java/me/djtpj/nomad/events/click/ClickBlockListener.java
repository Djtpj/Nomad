package me.djtpj.nomad.events.click;

import me.djtpj.nomad.items.NomadItem;
import org.bukkit.event.block.Action;

/**
 * Listener that fires when the player is holding the specified item, and clicks on a block
 */
public abstract class ClickBlockListener extends ClickListener {
    public ClickBlockListener(NomadItem item) {
        super(item, Action.RIGHT_CLICK_BLOCK, Action.LEFT_CLICK_BLOCK);
    }
}
