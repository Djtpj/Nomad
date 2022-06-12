package me.djtpj.nomad.events.click;

import me.djtpj.nomad.items.NomadItem;
import org.bukkit.event.block.Action;

public abstract class ShiftClickBlockListener extends ShiftClickListener {
    public ShiftClickBlockListener(NomadItem item) {
        super(item, Action.RIGHT_CLICK_BLOCK, Action.LEFT_CLICK_BLOCK);
    }
}
