package de.morgon.echocrafti.claiming;

import de.morgon.echocrafti.files.ClaimSaves;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.Objects;

public class PlaceListener implements Listener {

    @EventHandler
    public static void onPlace(BlockPlaceEvent e){

        Player p = e.getPlayer();
        String chunk = e.getBlock().getLocation().getChunk().getX() + "," + p.getLocation().getChunk().getZ();

        try {

            String team = p.getScoreboard().getPlayerTeam(p).getDisplayName();

            String claimer = (String) ClaimSaves.get().get(chunk);

            if (team.equals(claimer)) {
                return;
            } else if (claimer == null) {
                return;
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
