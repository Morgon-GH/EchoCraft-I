package de.morgon.echocrafti.claiming;

import de.morgon.echocrafti.files.ClaimSaves;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class UnclaimListener implements Listener {

    @EventHandler
    public static void onBreakBanner(BlockBreakEvent e){

        Player p = e.getPlayer();

        if (e.getBlock().getType().equals(Material.WHITE_BANNER)) {

            String blockname = e.getBlock().getDrops().stream().findFirst().get().getItemMeta().getDisplayName();
            String teamname = p.getScoreboard().getPlayerTeam(p).getColor() + p.getScoreboard().getPlayerTeam(p).getDisplayName();

            if (blockname.equals(teamname)){

                int x = e.getBlock().getChunk().getX();
                int z = e.getBlock().getChunk().getZ();

                String loc = x + "," + z;

                ClaimSaves.get().set(loc, null);
                ClaimSaves.save();

                p.sendMessage("You unclaimed this chunk");

            }

        }
    }
}
