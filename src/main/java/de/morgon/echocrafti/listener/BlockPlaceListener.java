package de.morgon.echocrafti.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import static de.morgon.echocrafti.claiming.Claim.onPlaceBanner;
import static de.morgon.echocrafti.claiming.ClaimPlace.onPlaceInClaim;

public class BlockPlaceListener implements Listener {

    @EventHandler
    public static void onBlockPlace(BlockPlaceEvent e){
        onPlaceBanner(e);
        onPlaceInClaim(e);
    }

}
