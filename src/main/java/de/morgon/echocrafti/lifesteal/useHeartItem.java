package de.morgon.echocrafti.lifesteal;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class useHeartItem implements Listener {

    public static void onHeartUse(PlayerInteractEvent e) {

        Player p = e.getPlayer();

        if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && p.getInventory().getItemInMainHand().equals("§dHeart")) {
            p.setMaxHealth(p.getMaxHealth() + 1);

            ItemStack h = p.getItemInHand();
            h.setAmount(h.getAmount() - 1);

            p.getInventory().setItemInMainHand(h);
        }

    }
}