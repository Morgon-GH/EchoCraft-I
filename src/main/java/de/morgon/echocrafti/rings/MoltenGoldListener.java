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

public class MoltenGoldListener implements Listener {

    @EventHandler
    public static void onClickBlastFurnace(PlayerInteractEvent e){

        Player p = e.getPlayer();

        ItemStack gold = new ItemStack(Material.GOLD_INGOT, 1);

        try {

            if (e.getClickedBlock().getType().equals(Material.BLAST_FURNACE) && p.getItemInHand().getType().equals(Material.GOLD_INGOT)) {

                Material[][][] structure = {
                    {
                        {Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN},
                        {Material.DEEPSLATE_TILE_WALL, Material.DEEPSLATE_TILE_WALL, Material.POLISHED_BLACKSTONE_BRICKS, Material.POLISHED_BLACKSTONE_BRICKS},
                        {Material.AIR, Material.AIR, Material.POLISHED_BLACKSTONE_BRICKS, Material.POLISHED_BLACKSTONE_BRICKS},
                        {Material.AIR, Material.AIR, Material.POLISHED_BLACKSTONE_BRICK_STAIRS, Material.POLISHED_BLACKSTONE_BRICKS},
                        {Material.AIR, Material.AIR, Material.AIR, Material.CHISELED_POLISHED_BLACKSTONE}
                    }, {
                        {Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN},
                        {Material.CHISELED_DEEPSLATE, Material.LAVA, Material.LAVA, Material.POLISHED_BLACKSTONE_BRICKS},
                        {Material.AIR, Material.AIR, Material.LAVA, Material.POLISHED_BLACKSTONE_BRICKS},
                        {Material.AIR, Material.AIR, Material.LAVA, Material.LAVA},
                        {Material.AIR, Material.AIR, Material.AIR, Material.POLISHED_BLACKSTONE_BRICKS}
                    }, {
                        {Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN},
                        {Material.AIR, Material.BLAST_FURNACE, Material.DEEPSLATE_BRICKS, Material.POLISHED_BLACKSTONE_BRICKS},
                        {Material.AIR, Material.AIR, Material.DEEPSLATE_BRICKS, Material.POLISHED_BLACKSTONE_BRICKS},
                        {Material.AIR, Material.AIR, Material.CHISELED_DEEPSLATE, Material.POLISHED_BLACKSTONE_BRICKS},
                        {Material.AIR, Material.AIR, Material.AIR, Material.POLISHED_BLACKSTONE_BRICKS}
                    }, {
                        {Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN},
                        {Material.CHISELED_DEEPSLATE, Material.LAVA, Material.LAVA, Material.POLISHED_BLACKSTONE_BRICKS},
                        {Material.AIR, Material.AIR, Material.LAVA, Material.POLISHED_BLACKSTONE_BRICKS},
                        {Material.AIR, Material.AIR, Material.LAVA, Material.LAVA},
                        {Material.AIR, Material.AIR, Material.AIR, Material.POLISHED_BLACKSTONE_BRICKS}
                    }, {
                        {Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN},
                        {Material.DEEPSLATE_TILE_WALL, Material.DEEPSLATE_TILE_WALL, Material.POLISHED_BLACKSTONE_BRICKS, Material.POLISHED_BLACKSTONE_BRICKS},
                        {Material.AIR, Material.AIR, Material.POLISHED_BLACKSTONE_BRICKS, Material.POLISHED_BLACKSTONE_BRICKS},
                        {Material.AIR, Material.AIR, Material.POLISHED_BLACKSTONE_BRICK_STAIRS, Material.POLISHED_BLACKSTONE_BRICKS},
                        {Material.AIR, Material.AIR, Material.AIR, Material.CHISELED_POLISHED_BLACKSTONE}
                    }
                };

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
            }

        }catch (Exception exception){
            return;
        }

    }

}
