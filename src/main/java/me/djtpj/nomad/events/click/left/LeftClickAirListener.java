package me.djtpj.nomad.events.click.left;

import me.djtpj.nomad.events.click.ClickListener;
import me.djtpj.nomad.items.NomadItem;
import org.bukkit.event.block.Action;

public abstract class LeftClickAirListener extends ClickListener {
    public LeftClickAirListener(NomadItem item) {
        super(item, Action.LEFT_CLICK_AIR);
    }
}
