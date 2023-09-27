package de.morgon.echocrafti.rings;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.awt.*;
import java.util.Objects;

import static de.morgon.echocrafti.rings.blockstructures.BlastFurnace.structure;

public class MoltenGoldListener implements Listener {

    @EventHandler
    public static void onClickBlastFurnaceXZ(PlayerInteractEvent e){

        Player p = e.getPlayer();

        ItemStack gold = new ItemStack(Material.GOLD_INGOT, 1);

        try {

            if (e.getClickedBlock().getType().equals(Material.BLAST_FURNACE) && p.getItemInHand().getType().equals(Material.GOLD_INGOT)) {

                for (int x = 0; x < 5; x++) {
                    for (int y = 0; y < 5; y++) {
                        for (int z = 0; z < 4; z++) {

                            if (!e.getClickedBlock().getRelative(x - 2, y - 1, z - 1).getType().equals(structure[x][y][z])) {
                                return;
                            }

                        }
                    }
                }


                e.getPlayer().sendMessage("hi");
                e.setCancelled(true);
            }

        }catch (Exception exception){
            return;
        }

    }


    @EventHandler
    public static void onClickBlastFurnaceZX(PlayerInteractEvent e){

        Player p = e.getPlayer();

        ItemStack gold = new ItemStack(Material.GOLD_INGOT, 1);

        try {

            if (e.getClickedBlock().getType().equals(Material.BLAST_FURNACE) && p.getItemInHand().getType().equals(Material.GOLD_INGOT)) {

                for (int x = 0; x < 5; x++) {
                    for (int y = 0; y < 5; y++) {
                        for (int z = 0; z < 4; z++) {

                            if (!e.getClickedBlock().getRelative(z - 2, y - 1, x + 1).getType().equals(structure[x][y][z])) {
                                return;
                            }

                        }
                    }
                }


                e.getPlayer().sendMessage("hi");
                e.setCancelled(true);
            }

        }catch (Exception exception){
            return;
        }

    }


    @EventHandler
    public static void onClickBlastFurnace3(PlayerInteractEvent e){

        Player p = e.getPlayer();

        ItemStack gold = new ItemStack(Material.GOLD_INGOT, 1);

        try {

            if (e.getClickedBlock().getType().equals(Material.BLAST_FURNACE) && p.getItemInHand().getType().equals(Material.GOLD_INGOT)) {

                for (int x = 0; x < 5; x++) {
                    for (int y = 0; y < 5; y++) {
                        for (int z = 0; z < 4; z++) {

                            if (!e.getClickedBlock().getRelative(x - 2, y - 1, z - 1).getType().equals(structure[x][y][z])) {
                                return;
                            }

                        }
                    }
                }


                e.getPlayer().sendMessage("hi");
                e.setCancelled(true);
            }

        }catch (Exception exception){
            return;
        }

    }



    @EventHandler
    public static void onClickBlastFurnace4(PlayerInteractEvent e){

        Player p = e.getPlayer();

        ItemStack gold = new ItemStack(Material.GOLD_INGOT, 1);

        try {

            if (e.getClickedBlock().getType().equals(Material.BLAST_FURNACE) && p.getItemInHand().getType().equals(Material.GOLD_INGOT)) {

                for (int x = 0; x < 5; x++) {
                    for (int y = 0; y < 5; y++) {
                        for (int z = 0; z < 4; z++) {

                            if (!e.getClickedBlock().getRelative(x - 2, y - 1, z - 1).getType().equals(structure[x][y][z])) {
                                return;
                            }

                        }
                    }
                }


                e.getPlayer().sendMessage("hi");
                e.setCancelled(true);
            }

        }catch (Exception exception){
            return;
        }

    }

}
