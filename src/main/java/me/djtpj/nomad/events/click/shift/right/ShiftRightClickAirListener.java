package me.djtpj.nomad.events.click.shift.right;

import me.djtpj.nomad.events.click.shift.ShiftClickListener;
import me.djtpj.nomad.items.NomadItem;
import org.bukkit.event.block.Action;

public abstract class ShiftRightClickAirListener extends ShiftClickListener {
    public ShiftRightClickAirListener(NomadItem item) {
        super(item, Action.RIGHT_CLICK_AIR);
    }
}
