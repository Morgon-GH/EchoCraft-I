package de.morgon.echocrafti.claiming;

import de.morgon.echocrafti.files.ClaimSaves;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BreakListener implements Listener {

    @EventHandler
    public static void onBreak(BlockBreakEvent e){

        Player p = e.getPlayer();
        String chunk = e.getBlock().getWorld().getName() + "," + e.getBlock().getLocation().getChunk().getX() + "," + e.getBlock().getLocation().getChunk().getZ();

        try {

            String team = p.getScoreboard().getPlayerTeam(p).getDisplayName();

            String claimer = (String) ClaimSaves.get().get(chunk);

            if (team.equals(claimer)) {
                e.setCancelled(false);
            } else if (claimer == null) {
                e.setCancelled(false);
            } else {
                e.setCancelled(true);
                p.sendMessage("This is the territory of an other fraction");
            }
        }catch (Exception exception){

            String claimer = (String) ClaimSaves.get().get(chunk);

            e.setCancelled(claimer != null);

        }
    }

}
