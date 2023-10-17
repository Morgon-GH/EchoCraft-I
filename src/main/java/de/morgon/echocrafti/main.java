package de.morgon.echocrafti;

import de.morgon.echocrafti.claiming.*;
import de.morgon.echocrafti.cosmetics.customHeads.testSkullItem;
import de.morgon.echocrafti.lifesteal.*;
import de.morgon.echocrafti.lifesteal.heart_recipes.*;
import de.morgon.echocrafti.files.*;
import de.morgon.echocrafti.listener.BlockBreakListener;
import de.morgon.echocrafti.listener.BlockPlaceListener;
import de.morgon.echocrafti.listener.PlayerDeathListener;
import de.morgon.echocrafti.listener.PlayerInteractListener;
import de.morgon.echocrafti.rings.MoltenGoldListener;
import de.morgon.echocrafti.rings.UniverseIngotRecipe;
import de.morgon.echocrafti.upgrades.SilexRecipe;
import de.morgon.echocrafti.upgrades.SilexUse;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

import static de.morgon.echocrafti.cosmetics.runes.GrandSearing.searingRune;

public final class main extends JavaPlugin {

    private static main plugin;

    @Override
    public void onEnable() {

        plugin = this;

        Logger logger = Bukkit.getLogger();

        logger.info("Starting plugin");

        logger.info("Loading Listeners");

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new BlockBreakListener(),this);
        pluginManager.registerEvents(new BlockPlaceListener(),this);
        pluginManager.registerEvents(new PlayerDeathListener(),this);
        pluginManager.registerEvents(new PlayerInteractListener(),this);


        logger.info("Loading commands");

        getCommand("gifthealth").setExecutor(new GiftHealthCommand());
        getCommand("checkclaim").setExecutor(new CheckClaimCommand());
        getCommand("testskull").setExecutor(new testSkullItem());

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

        NamespacedKey keySilex = new NamespacedKey(this, "Silex");
        SilexRecipe.register(keySilex);

        NamespacedKey keyUniverseingot = new NamespacedKey(this, "UniverseIngot");
        UniverseIngotRecipe.register(keyUniverseingot);


        logger.info("loading custom files");

        ClaimSaves.setup();
        ClaimSaves.save();
        ClaimSaves.get().options().copyDefaults(true);

        searingRune();

    }

    public static main getPlugin() {
        return plugin;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
