package de.morgon.echocrafti.lifesteal;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class useKnife implements Listener {

    @EventHandler

    public static void onKnifeUse(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

            try {

                if (e.getItem().getItemMeta().getDisplayName().equals("§bKnife") && p.getMaxHealth() > 2) {

                    ItemStack Heart = new ItemStack(Material.NETHER_STAR);
                    ItemMeta HeartM = Heart.getItemMeta();
                    HeartM.setDisplayName("§dHeart");
                    HeartM.setCustomModelData(1);
                    Heart.setItemMeta(HeartM);

                    p.getInventory().addItem(Heart);

                    p.setMaxHealth(p.getMaxHealth() - 2);

                }
            }catch (Exception exception){
                return;
            }
        }
    }
}
