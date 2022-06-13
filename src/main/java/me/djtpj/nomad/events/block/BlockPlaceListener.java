package me.djtpj.nomad.events.block;

import me.djtpj.nomad.events.Manager;
import me.djtpj.nomad.events.NomadListener;
import me.djtpj.nomad.items.NomadItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public abstract class BlockPlaceListener extends NomadListener<BlockPlaceEvent> implements Listener {

    final NomadItem item;

    public BlockPlaceListener(NomadItem item) {
        this.item = item;

        Manager.getInstance().registerEvent(this);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (validate(event, item)) {
            onEvent(event);
        }
    }

    @Override
    public boolean validate(BlockPlaceEvent event, NomadItem item) {
        if (!(item.equals(event.getPlayer().getInventory().getItemInMainHand()))) return false;

        return true;
    }
}
