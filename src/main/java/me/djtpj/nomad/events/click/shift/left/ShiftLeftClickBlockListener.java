package me.djtpj.nomad.events.click.shift.left;

import me.djtpj.nomad.events.click.shift.ShiftClickListener;
import me.djtpj.nomad.items.NomadItem;
import org.bukkit.event.block.Action;

public abstract class ShiftLeftClickBlockListener extends ShiftClickListener {
    public ShiftLeftClickBlockListener(NomadItem item) {
        super(item, Action.LEFT_CLICK_BLOCK);
    }
}
