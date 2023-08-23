package de.morgon.echocrafti;

import de.morgon.echocrafti.lifesteal.GiftHealthCommand;
import de.morgon.echocrafti.lifesteal.KillListener;
import de.morgon.echocrafti.lifesteal.heart_recipes.*;
import de.morgon.echocrafti.lifesteal.useHeartItem;
import de.morgon.echocrafti.lifesteal.useKnife;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {

        Logger logger = Bukkit.getLogger();

        logger.info("Starting plugin");

        logger.info("Loading Listeners");

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new KillListener(),this);
        pluginManager.registerEvents(new useHeartItem(),this);
        pluginManager.registerEvents(new useKnife(),this);

        logger.info("Loading commands");

        getCommand("gifthealth").setExecutor(new GiftHealthCommand());

        logger.info("Loading Recipes");

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

        NamespacedKey keyKnife = new NamespacedKey(this, "Knife");
        KnifeRecipe.register(keyKnife);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
