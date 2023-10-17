package de.morgon.echocrafti.claiming;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class ClaimBreakBlockBeneathBanner {

    public static void onBreakBlockBeneathBanner(BlockBreakEvent e) {
        if (e.getBlock().getLocation().add(0, 1, 0).getBlock().getType().equals(Material.WHITE_BANNER)){
            e.setCancelled(true);
            e.getPlayer().sendMessage("Please destroy banner on top before mining this Block");
        }
    }

}
