package me.djtpj.nomad.events.block;

import me.djtpj.nomad.events.Manager;
import me.djtpj.nomad.events.NomadListener;
import me.djtpj.nomad.items.NomadItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;

public abstract class BlockBreakListener extends NomadListener<BlockBreakEvent> {

    final NomadItem item;

    public BlockBreakListener(NomadItem item) {
        this.item = item;

        Manager.getInstance().registerEvent(this);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (this.validate(event, item)) onEvent(event);
    }

    @Override
    public boolean validate(BlockBreakEvent event, NomadItem item) {
        return item.equals(event.getPlayer().getInventory().getItemInMainHand());
    }
}
