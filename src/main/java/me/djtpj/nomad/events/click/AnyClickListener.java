package me.djtpj.nomad.events.click;

import me.djtpj.nomad.items.NomadItem;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public abstract class AnyClickListener extends ClickListener {
    public AnyClickListener(NomadItem item) {
        super(item, Action.RIGHT_CLICK_AIR, Action.LEFT_CLICK_BLOCK, Action.LEFT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK);
    }

    @Override
    public boolean validate(PlayerInteractEvent event, NomadItem item) {
        if (super.validate(event, item)) return true;

        else if (event.getPlayer().isSneaking()) {
            return true;
        }

        return false;
    }
}
