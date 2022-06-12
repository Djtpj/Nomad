package me.djtpj.nomad.events;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class Manager {

    private static Manager instance;

    private ArrayList<String> registered;

    @Getter
    @Setter
    @NonNull
    private Plugin plugin;

    private Manager() {
        registered = new ArrayList<>();

        registerAllNomadListeners();
    }

    private void registerAllNomadListeners() {

    }

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
