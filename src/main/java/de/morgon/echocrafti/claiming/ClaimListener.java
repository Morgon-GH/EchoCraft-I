package de.morgon.echocrafti.claiming;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class ClaimListener implements Listener {

    @EventHandler
    public static void onPLaceBanner(BlockPlaceEvent e){

        if (e.getBlock().equals(Material.WHITE_BANNER)){



        }
    }

}
