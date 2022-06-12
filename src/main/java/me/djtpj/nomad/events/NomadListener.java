package me.djtpj.nomad.events;

import me.djtpj.nomad.items.NomadItem;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;

public interface NomadListener <T extends Event> {

    void onEvent(T event);

    default boolean validate(T event, NomadItem item) {
        Bukkit.broadcastMessage("This is the default validate method running for the " + event.getEventName() + " in the class " + this.getClass().getName());
        return false;
    }

}
