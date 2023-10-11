package de.morgon.echocrafti.claiming;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RenameListener implements Listener {

    @EventHandler
    public static void onClickBannerAir(PlayerInteractEvent e){

        Player p = e.getPlayer();
        String name = e.getItem().getItemMeta().getDisplayName();

        if (e.getAction().equals(Action.RIGHT_CLICK_AIR) && e.getItem().getType().equals(Material.WHITE_BANNER)){

            if(e.getItem().hasItemMeta()) {

                ItemStack b = e.getItem();

                String t = Bukkit.getScoreboardManager().getMainScoreboard().getTeams().stream().findAny().get().getDisplayName();

                for (Bukkit.getScoreboardManager().getMainScoreboard().getEntries();;
                     ) {
                    if(b.getItemMeta().getDisplayName().equals(t)) {

                        String teamName = p.getScoreboard().getPlayerTeam(p).getDisplayName();
                        ChatColor teamColor = p.getScoreboard().getPlayerTeam(p).getColor();

                        ItemMeta m = b.getItemMeta();
                        m.setDisplayName(teamColor + teamName);
                        b.setItemMeta(m);

                    }
                }

            }
        }
    }
}
