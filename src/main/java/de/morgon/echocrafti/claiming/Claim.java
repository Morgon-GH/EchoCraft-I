package de.morgon.echocrafti.claiming;

import de.morgon.echocrafti.files.ClaimSaves;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.material.Directional;

public class Claim {

    public static void onPlaceBanner(BlockPlaceEvent e) {

        Player p = e.getPlayer();

        int x = e.getBlock().getChunk().getX();
        int z = e.getBlock().getChunk().getZ();
        String dim = e.getBlock().getWorld().getName();
        String chunk = dim + "," + x + "," + z;

        String claimer = (String) ClaimSaves.get().get(chunk);
        if (e.getBlock().getType().equals(Material.WHITE_BANNER) && e.getItemInHand().getItemMeta().getDisplayName().equals(p.getScoreboard().getPlayerTeam(p).getColor() + p.getScoreboard().getPlayerTeam(p).getDisplayName())) {

            if (claimer != null) {

                p.sendMessage("This chunk is already claimed");
                e.setCancelled(true);

            } else {


                String loc = dim + "," +  x + "," + z;

                ClaimSaves.get().set(loc, p.getScoreboard().getPlayerTeam(p).getDisplayName());
                ClaimSaves.save();

                p.sendMessage("You claimed this chunk for your team. It will remain claimed for this team even if you leave or join another team");


            }
        }
    }
}
