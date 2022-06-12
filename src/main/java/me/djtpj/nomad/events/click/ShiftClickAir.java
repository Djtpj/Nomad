package me.djtpj.nomad.events.click;

import me.djtpj.nomad.items.NomadItem;
import org.bukkit.event.block.Action;

public abstract class ShiftClickAir extends ShiftClickListener {
    public ShiftClickAir(NomadItem item) {
        super(item, Action.RIGHT_CLICK_AIR, Action.LEFT_CLICK_AIR);
    }
}
