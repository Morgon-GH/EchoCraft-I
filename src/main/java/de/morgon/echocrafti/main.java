package de.morgon.echocrafti;

import de.morgon.echocrafti.lifesteal.GiftHealthCommand;
import de.morgon.echocrafti.lifesteal.KillListener;
import de.morgon.echocrafti.crafthearts.recipes.*;
import de.morgon.echocrafti.lifesteal.useHeartItem;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new KillListener(),this);
        pluginManager.registerEvents(new useHeartItem(),this);

        Objects.requireNonNull(getCommand("gifthealth")).setExecutor(new GiftHealthCommand());

        NamespacedKey keySeaEssence = new NamespacedKey(this, "SeaEssence");
        SeaEssenceRecipe.register(keySeaEssence);

        NamespacedKey keyMountainEssence = new NamespacedKey(this, "MountainEssence");
        MountainEssenceRecipe.register(keyMountainEssence);

        NamespacedKey keyNetherEssence = new NamespacedKey(this, "NetherEssence");
        NetherEssenceRecipe.register(keyNetherEssence);

        NamespacedKey keyEndEssence = new NamespacedKey(this, "EndEssence");
        EndEssenceRecipe.register(keyEndEssence);

        NamespacedKey keyHeartFragment = new NamespacedKey(this, "HeartFragment");
        HeartFragmentRecipe.register(keyHeartFragment);

        NamespacedKey keyHeart = new NamespacedKey(this, "Heart");
        HeartRecipe.register(keyHeart);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
