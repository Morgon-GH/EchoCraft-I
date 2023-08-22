package de.morgon.echocrafti;

import de.morgon.echocrafti.lifesteal.GiftHealthCommand;
import de.morgon.echocrafti.lifesteal.KillListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new KillListener(),this);

        Objects.requireNonNull(getCommand("gifthealth")).setExecutor(new GiftHealthCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
