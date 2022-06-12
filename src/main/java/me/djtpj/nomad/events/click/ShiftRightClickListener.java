package me.djtpj.nomad.events.click;

import me.djtpj.nomad.items.NomadItem;
import org.bukkit.event.block.Action;

public abstract class ShiftRightClickListener extends ShiftClickListener {
    public ShiftRightClickListener(NomadItem item) {
        super(item, Action.RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK);
    }
}
