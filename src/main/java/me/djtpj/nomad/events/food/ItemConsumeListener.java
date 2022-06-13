package me.djtpj.nomad.events.food;

import me.djtpj.nomad.events.Manager;
import me.djtpj.nomad.events.NomadListener;
import me.djtpj.nomad.items.NomadItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public abstract class ItemConsumeListener extends NomadListener<PlayerItemConsumeEvent> {
    final NomadItem item;

    public ItemConsumeListener(NomadItem item) {
        this.item = item;

        Manager.getInstance().registerEvent(this);
    }

    @EventHandler
    public void onItemConsume(PlayerItemConsumeEvent event) {
        if (validate(event, item)) {
            onEvent(event);
        }
    }

    @Override
    public boolean validate(PlayerItemConsumeEvent event, NomadItem item) {
        return item.equals(event.getItem());
    }
}
