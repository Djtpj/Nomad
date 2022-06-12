package me.djtpj.nomad.events.click;

import me.djtpj.nomad.items.NomadItem;
import org.bukkit.event.block.Action;

public abstract class LeftClickListener extends ClickListener {

    public LeftClickListener(NomadItem item) {
        super(item, Action.LEFT_CLICK_AIR, Action.LEFT_CLICK_BLOCK);
    }
}
