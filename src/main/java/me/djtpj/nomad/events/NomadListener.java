package me.djtpj.nomad.events;

import me.djtpj.nomad.items.NomadItem;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;

/** Interface for creating a listener that works directly with NomadItems
 *
 * @param <T> the type of event that this listener will handle. There can be multiple listeners that handle the same event.
 * @see NomadItem
 */
public abstract class NomadListener <T extends Event> implements Listener {

    /** Event Method
     * This is the method that is defined when the listener is instantiated, and is run when the event is fired,
     * and it validates correctly
     * @param event the event that is triggered
     */
    public abstract void onEvent(T event);

    /** Verifies if the correct criteria are met for each event
     * This method should be overwritten by each inheritor, but not by its instantiates
     * @param event the event that is triggered
     * @param item the item to compare against
     * @return if the event has met the validation criteria
     * @see #onEvent(Event)
     */
    public boolean validate(T event, NomadItem item) {
        Bukkit.broadcastMessage("This is the default validate method running for the " + event.getEventName() + " in the class " + this.getClass().getName());
        return false;
    }

}
