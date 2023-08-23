package de.morgon.echocrafti.lifesteal;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class useHeartItem implements Listener {

    @EventHandler

    public static void onHeartUse(PlayerInteractEvent e) {

        Player p = e.getPlayer();

        if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

            if(e.getItem().getItemMeta().getDisplayName().equals("§dHeart")) {
                p.setMaxHealth(p.getMaxHealth() + 2);

                ItemStack h = e.getItem();
                h.setAmount(h.getAmount() - 1);

                p.getInventory().setItemInMainHand(h);
            }
        }
    }
}
