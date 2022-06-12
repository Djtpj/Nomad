package me.djtpj.nomad.events.click;

import me.djtpj.nomad.events.Manager;
import me.djtpj.nomad.events.NomadListener;
import me.djtpj.nomad.items.NomadItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class ClickListener implements NomadListener<PlayerInteractEvent>, Listener {

    static ArrayList<ClickListener> listeners = new ArrayList<>();

    final NomadItem item;

    final Action[] actions;

    public ClickListener(NomadItem item, Action... actions) {
        this.item = item;
        this.actions = actions;

        listeners.add(this);

        Manager.getInstance().registerEvent(this);
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        for (ClickListener listener : listeners) {
            if (listener.validate(event, item)) {
                listener.onEvent(event);
            }
        }
    }

    @Override
    public boolean validate(PlayerInteractEvent event, NomadItem item) {
        if (!Arrays.asList(actions).contains(event.getAction())) return false;

        if (!item.equals(event.getItem())) return false;

        if (event.getPlayer().isSneaking()) return false;

        return true;
    }
}
