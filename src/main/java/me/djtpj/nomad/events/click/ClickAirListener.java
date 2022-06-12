package me.djtpj.nomad.events.click;

import me.djtpj.nomad.items.NomadItem;
import org.bukkit.event.block.Action;

public abstract class ClickAirListener extends ClickListener {
    public ClickAirListener(NomadItem item) {
        super(item, Action.RIGHT_CLICK_AIR, Action.LEFT_CLICK_AIR);
    }
}
