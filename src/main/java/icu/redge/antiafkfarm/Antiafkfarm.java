package icu.redge.antiafkfarm;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class Antiafkfarm extends JavaPlugin {
    public static JavaPlugin instance;

    @Override
    public void onLoad() {
        saveDefaultConfig();
    }

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new EventListener(), this);
        instance = this;
        reloadConfig();
    }

    @Override
    public void onDisable() {
        saveConfig();
    }
}
