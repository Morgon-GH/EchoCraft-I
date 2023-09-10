package de.morgon.echocrafti.claiming;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CraftListener implements Listener {

    @EventHandler
    public static void onCraft(CraftItemEvent e){

        ItemStack ClaimBanner = new ItemStack(Material.WHITE_BANNER);
        ItemMeta ClaimBannerM = ClaimBanner.getItemMeta();
        ClaimBannerM.setDisplayName("§bClaimBanner");
        ClaimBanner.setItemMeta(ClaimBannerM);

        if (e.getRecipe().getResult().equals(ClaimBanner)){

            Player p = (Player) e.getWhoClicked();

            String teamName = p.getScoreboard().getTeams().stream().findFirst().get().getDisplayName();
            ChatColor teamColor = p.getScoreboard().getTeams().stream().findFirst().get().getColor();

            

        }

    }

}
