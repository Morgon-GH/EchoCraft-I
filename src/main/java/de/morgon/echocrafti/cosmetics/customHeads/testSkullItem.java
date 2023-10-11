package de.morgon.echocrafti.cosmetics.customHeads;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.net.MalformedURLException;

public class testSkullItem implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);

        if(sender instanceof Player) {

            Player p = (Player) sender;

            try {

                SkullMeta meta = customHeadBuilder.createSkullTexture("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDk1ODJmYTIxYzQ1YzQwYTgwYTlhNzkxODQyZjcxMDc4ZjQ3YzMzNWQ2MjdiYjU2MGViODZkYWQ2NDFhOGM0In19fQ==", skull);

                skull.setItemMeta(meta);

                p.getInventory().addItem(skull);

            } catch (MalformedURLException e) {
                return true;
            }
        }
        return false;
    }
}
