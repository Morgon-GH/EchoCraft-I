package de.morgon.echocrafti.rings;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MoltenGoldListener {

    public static void onMeldGold(PlayerInteractEvent e){
        onMeldGold1(e);
        onMeldGold2(e);
        onMeldGold3(e);
        onMeldGold4(e);
    }

    public static void giveMoltenGold(Player p, PlayerInteractEvent e){

        e.setCancelled(true);

        ItemStack moltenGold = new ItemStack(Material.GOLD_INGOT);
        ItemMeta moltenGoldM = moltenGold.getItemMeta();
        moltenGoldM.setDisplayName(ChatColor.AQUA + "Molten Gold");
        moltenGoldM.setCustomModelData(1);
        moltenGold.setItemMeta(moltenGoldM);


        ItemStack gold = e.getItem();
        gold.setAmount(gold.getAmount() - 1);
        p.setItemInHand(gold);

        Entity item = p.getWorld().dropItemNaturally(e.getClickedBlock().getRelative(0, +2, 0).getLocation(), moltenGold);
        item.setInvulnerable(true);

    }

    static Material[][][] structure = {
        {
            {Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN},
            {Material.DEEPSLATE_TILE_WALL, Material.POLISHED_BLACKSTONE_BRICKS, Material.POLISHED_BLACKSTONE_BRICKS, Material.POLISHED_BLACKSTONE_BRICKS},
            {Material.AIR, Material.POLISHED_BLACKSTONE_BRICK_STAIRS, Material.POLISHED_BLACKSTONE_BRICKS, Material.POLISHED_BLACKSTONE_BRICKS},
            {Material.AIR, Material.AIR, Material.POLISHED_BLACKSTONE_BRICK_STAIRS, Material.POLISHED_BLACKSTONE_BRICKS},
            {Material.AIR, Material.AIR, Material.AIR, Material.CHISELED_POLISHED_BLACKSTONE}
        }, {
            {Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN},
            {Material.CHISELED_DEEPSLATE, Material.COAL_BLOCK, Material.LAVA, Material.POLISHED_BLACKSTONE_BRICKS},
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
            {Material.CHISELED_DEEPSLATE, Material.COAL_BLOCK, Material.LAVA, Material.POLISHED_BLACKSTONE_BRICKS},
            {Material.AIR, Material.AIR, Material.LAVA, Material.POLISHED_BLACKSTONE_BRICKS},
            {Material.AIR, Material.AIR, Material.LAVA, Material.LAVA},
            {Material.AIR, Material.AIR, Material.AIR, Material.POLISHED_BLACKSTONE_BRICKS}
        }, {
            {Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN},
            {Material.DEEPSLATE_TILE_WALL, Material.POLISHED_BLACKSTONE_BRICKS, Material.POLISHED_BLACKSTONE_BRICKS, Material.POLISHED_BLACKSTONE_BRICKS},
            {Material.AIR, Material.POLISHED_BLACKSTONE_BRICK_STAIRS, Material.POLISHED_BLACKSTONE_BRICKS, Material.POLISHED_BLACKSTONE_BRICKS},
            {Material.AIR, Material.AIR, Material.POLISHED_BLACKSTONE_BRICK_STAIRS, Material.POLISHED_BLACKSTONE_BRICKS},
            {Material.AIR, Material.AIR, Material.AIR, Material.CHISELED_POLISHED_BLACKSTONE}
        }
    };


    public static void onMeldGold1(PlayerInteractEvent e){

        Player p = e.getPlayer();

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


                giveMoltenGold(p, e);
                e.getClickedBlock().getRelative(1, 0, 0).setType(Material.AIR);
                e.getClickedBlock().getRelative(-1, 0, 0).setType(Material.AIR);
            }

        }catch (Exception exception){
            return;
        }

    }


    public static void onMeldGold2(PlayerInteractEvent e){

        Player p = e.getPlayer();

        try {

            if (e.getClickedBlock().getType().equals(Material.BLAST_FURNACE) && p.getItemInHand().getType().equals(Material.GOLD_INGOT)) {

                for (int x = 0; x < 4; x++) {
                    for (int y = 0; y < 5; y++) {
                        for (int z = 0; z < 5; z++) {

                            if (!e.getClickedBlock().getRelative(x - 1, y - 1, z - 2 ).getType().equals(structure[z][y][x])) {
                                return;
                            }

                        }
                    }
                }


                giveMoltenGold(p, e);
                e.getClickedBlock().getRelative(0, 0, 1).setType(Material.AIR);
                e.getClickedBlock().getRelative(0, 0, -1).setType(Material.AIR);
            }

        }catch (Exception exception){
            return;
        }

    }


    public static void onMeldGold3(PlayerInteractEvent e){

        Player p = e.getPlayer();

        try {

            if (e.getClickedBlock().getType().equals(Material.BLAST_FURNACE) && p.getItemInHand().getType().equals(Material.GOLD_INGOT)) {

                for (int x = 0; x < 5; x++) {
                    for (int y = 0; y < 5; y++) {
                        for (int z = 0; z < 4; z++) {

                            if (!e.getClickedBlock().getRelative(x - 2, y - 1, -z + 1).getType().equals(structure[x][y][z])) {
                                return;
                            }

                        }
                    }
                }


                giveMoltenGold(p, e);
                e.getClickedBlock().getRelative(1, 0, 0).setType(Material.AIR);
                e.getClickedBlock().getRelative(-1, 0, 0).setType(Material.AIR);
            }

        }catch (Exception exception){
            return;
        }

    }



    public static void onMeldGold4(PlayerInteractEvent e){

        Player p = e.getPlayer();

        try {

            if (e.getClickedBlock().getType().equals(Material.BLAST_FURNACE) && p.getItemInHand().getType().equals(Material.GOLD_INGOT)) {

                for (int x = 0; x < 4; x++) {
                    for (int y = 0; y < 5; y++) {
                        for (int z = 0; z < 5; z++) {

                            if (!e.getClickedBlock().getRelative(-x + 1, y - 1, z - 2).getType().equals(structure[z][y][x])) {
                                return;
                            }

                        }
                    }
                }


                giveMoltenGold(p, e);
                e.getClickedBlock().getRelative(0, 0, 1).setType(Material.AIR);
                e.getClickedBlock().getRelative(0, 0, -1).setType(Material.AIR);
            }

        }catch (Exception exception){
            return;
        }

    }

}
