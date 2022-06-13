package me.djtpj.nomad.events.click;

import me.djtpj.nomad.events.Manager;
import me.djtpj.nomad.events.NomadListener;
import me.djtpj.nomad.items.NomadItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.Arrays;

/** Super class to all NomadListeners that handle Click events
 * @see NomadListener
 */
public abstract class ClickListener extends NomadListener<PlayerInteractEvent> {

    static ArrayList<ClickListener> listeners = new ArrayList<>();

    final NomadItem item;

    protected final Action[] actions;

    /**
     * @param item the item to compare against
     * @param actions the Actions that trigger this event. (Cannot be {@link Action#PHYSICAL}).
     *                This should be defined by the sub listener, not the instantiate.
     */
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
