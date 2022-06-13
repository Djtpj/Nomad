package me.djtpj.nomad.events.click.right;

import me.djtpj.nomad.events.click.ClickListener;
import me.djtpj.nomad.items.NomadItem;
import org.bukkit.event.block.Action;

public abstract class RightClickBlockListener extends ClickListener {
    public RightClickBlockListener(NomadItem item) {
        super(item, Action.RIGHT_CLICK_BLOCK);
    }
}
