package de.morgon.echocrafti.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import static de.morgon.echocrafti.lifesteal.useHeartItem.onHeartUse;
import static de.morgon.echocrafti.lifesteal.useKnife.onKnifeUse;
import static de.morgon.echocrafti.rings.ForgeRing.onForgeRing;
import static de.morgon.echocrafti.rings.MoltenGoldListener.onMeldGold;
import static de.morgon.echocrafti.upgrades.SilexUse.onSilexClick;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public static void onPlayerInteract(PlayerInteractEvent e){
        onHeartUse(e);
        onKnifeUse(e);
        onForgeRing(e);
        onMeldGold(e);
        onSilexClick(e);
    }

}
