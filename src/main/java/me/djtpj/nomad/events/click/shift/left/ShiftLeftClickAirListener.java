package me.djtpj.nomad.events.click.shift.left;

import me.djtpj.nomad.events.click.shift.ShiftClickListener;
import me.djtpj.nomad.items.NomadItem;
import org.bukkit.event.block.Action;

public abstract class ShiftLeftClickAirListener extends ShiftClickListener {
    public ShiftLeftClickAirListener(NomadItem item) {
        super(item, Action.LEFT_CLICK_AIR);
    }
}
