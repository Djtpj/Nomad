package me.djtpj.nomad.events.click;

import me.djtpj.nomad.items.NomadItem;
import org.bukkit.event.block.Action;

public abstract class ClickBlockListener extends ClickListener {
    public ClickBlockListener(NomadItem item) {
        super(item, Action.RIGHT_CLICK_BLOCK, Action.LEFT_CLICK_BLOCK);
    }
}
