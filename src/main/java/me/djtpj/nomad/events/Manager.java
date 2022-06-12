package me.djtpj.nomad.events;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

/** Singleton class for event management
 * This class handles registering each NomadListener
 */
public class Manager {

    private static Manager instance;

    private ArrayList<String> registered;

    @Getter
    @Setter
    @NonNull
    private Plugin plugin;

    private Manager() {
        registered = new ArrayList<>();
    }

    /** Method that registers event listener
     * @param listener the listener to register
     */
    public void registerEvent(Listener listener) {
        if (!registered.contains(listener.getClass().getSimpleName())) {
            plugin.getServer().getPluginManager().registerEvents(listener, plugin);
            registered.add(listener.getClass().getSimpleName());
        }
    }

    public static Manager getInstance() {
        if (instance == null) {
            instance = new Manager();
        }
        return instance;
    }
}
