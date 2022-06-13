package me.djtpj.nomad.events.click.shift;

import me.djtpj.nomad.events.click.ClickListener;
import me.djtpj.nomad.items.NomadItem;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Arrays;

/**
 * Super class to all listeners that handle shift clicking
 * @see ClickListener
 */
public abstract class ShiftClickListener extends ClickListener {
    public ShiftClickListener(NomadItem item, Action... actions) {
        super(item, actions);
    }

    @Override
    public boolean validate(PlayerInteractEvent event, NomadItem item) {
        if (!Arrays.asList(actions).contains(event.getAction())) return false;

        if (!item.equals(event.getItem())) return false;

        if (!event.getPlayer().isSneaking()) return false;

        return true;
    }
}
