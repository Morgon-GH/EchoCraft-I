package de.morgon.echocrafti.claiming;

import de.morgon.echocrafti.files.ClaimSaves;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakListener implements Listener {

    @EventHandler
    public static void onBreak(BlockBreakEvent e){

        Player p = e.getPlayer();
        String teamName = p.getScoreboard().getTeams().stream().findFirst().get().getDisplayName();

        //if ()

    }

}
