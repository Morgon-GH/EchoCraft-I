package de.morgon.echocrafti.cosmetics.runes;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import static de.morgon.echocrafti.cosmetics.runes.GrandSearing.searingRune;

public class OnArmorChangeEvent implements Listener {

    @EventHandler
    public static void OnArmorChange(InventoryClickEvent e) {
        try{
            if(e.getSlotType() == InventoryType.SlotType.ARMOR) {
                Player p = (Player) e.getWhoClicked();
                ItemStack i = e.getCursor();
                if(i.getItemMeta().getDisplayName().equals("Grand Searing Chestplate")) {
                }
            }
        }catch (Exception exception){
            return;
        }
    }

    @EventHandler
    public static void OnArmorChangeClick(PlayerInteractEvent e) {
        try{
            if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                Player p = e.getPlayer();
                ItemStack i = e.getItem();
                if(i.getItemMeta().getDisplayName().equals("Grand Searing Chestplate")) {
                }
            }
        }catch (Exception exception){
            return;
        }
    }
}
