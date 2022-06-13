package me.djtpj.nomad.events.click.shift.right;

import me.djtpj.nomad.events.click.shift.ShiftClickListener;
import me.djtpj.nomad.items.NomadItem;
import org.bukkit.event.block.Action;

public abstract class ShiftRightClickBlockListener extends ShiftClickListener {
    public ShiftRightClickBlockListener(NomadItem item) {
        super(item, Action.RIGHT_CLICK_BLOCK);
    }
}
