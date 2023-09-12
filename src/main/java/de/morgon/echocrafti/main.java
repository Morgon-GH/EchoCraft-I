package de.morgon.echocrafti;

import de.morgon.echocrafti.claiming.*;
import de.morgon.echocrafti.lifesteal.*;
import de.morgon.echocrafti.lifesteal.heart_recipes.*;
import de.morgon.echocrafti.files.*;
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
        pluginManager.registerEvents(new CraftListener(),this);
        pluginManager.registerEvents(new ClaimListener(), this);
        pluginManager.registerEvents(new UnclaimListener(), this);
        pluginManager.registerEvents(new PlaceListener(), this);
        pluginManager.registerEvents(new BreakListener(), this);

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

        NamespacedKey keyClaimBanner = new NamespacedKey(this, "ClaimBanner");
        ClaimBannerRecipe.register(keyClaimBanner);

        NamespacedKey keyAltClaimBanner = new NamespacedKey(this, "AltClaimBanner");
        ClaimBannerAltRecipe.register(keyAltClaimBanner);


        logger.info("loading custom files");

        ClaimSaves.setup();
        ClaimSaves.save();
        ClaimSaves.get().options().copyDefaults(true);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
