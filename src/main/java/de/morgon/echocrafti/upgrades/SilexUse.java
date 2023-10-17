package de.morgon.echocrafti.upgrades;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SilexUse {

    public static void onSilexClick(PlayerInteractEvent e) {

        Player p = e.getPlayer();
        ItemStack b = e.getPlayer().getInventory().getItemInOffHand();
        ItemStack s = e.getPlayer().getInventory().getItemInMainHand();

        int l = b.getEnchantmentLevel(Enchantment.DIG_SPEED);
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            try {
                if (e.getItem().getItemMeta().getDisplayName().equals("§bSilex")) {
                    if (l == 5) {
                        ItemMeta m = b.getItemMeta();
                        m.addEnchant(Enchantment.DIG_SPEED, l + 1, true);
                        b.setItemMeta(m);
                        s.setAmount(s.getAmount() - 1);
                        p.sendMessage("§9Upgraded §a" + b.getItemMeta().getDisplayName().toString() + " §9 to §eEfficiency VI§9.");
                    } else if (l == 6) {
                        ItemMeta m = b.getItemMeta();
                        m.addEnchant(Enchantment.DIG_SPEED, l + 1, true);
                        b.setItemMeta(m);
                        s.setAmount(s.getAmount() - 1);
                        p.sendMessage("§9Upgraded §a" + b.getItemMeta().getDisplayName().toString() + " §9 to §eEfficiency VII§9.");
                    } else if (l == 7) {
                        ItemMeta m = b.getItemMeta();
                        m.addEnchant(Enchantment.DIG_SPEED, l + 1, true);
                        b.setItemMeta(m);
                        s.setAmount(s.getAmount() - 1);
                        p.sendMessage("§9Upgraded §a" + b.getItemMeta().getDisplayName().toString() + " §9 to §eEfficiency VIII§9.");
                    } else if (l == 8) {
                        ItemMeta m = b.getItemMeta();
                        m.addEnchant(Enchantment.DIG_SPEED, l + 1, true);
                        b.setItemMeta(m);
                        s.setAmount(s.getAmount() - 1);
                        p.sendMessage("§9Upgraded §a" + b.getItemMeta().getDisplayName().toString() + " §9 to §eEfficiency IX§9.");
                    } else if (l == 9) {
                        ItemMeta m = b.getItemMeta();
                        m.addEnchant(Enchantment.DIG_SPEED, l + 1, true);
                        b.setItemMeta(m);
                        s.setAmount(s.getAmount() - 1);
                        p.sendMessage("§9Upgraded §a" + b.getItemMeta().getDisplayName().toString() + " §9 to §eEfficiency X§9.");
                    }
                    e.setCancelled(true);
                }
            }catch (Exception exception){
                return;
            }
        }
    }

}
