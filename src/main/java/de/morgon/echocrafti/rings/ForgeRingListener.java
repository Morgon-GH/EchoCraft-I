package de.morgon.echocrafti.rings;

import de.morgon.echocrafti.main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class ForgeRingListener implements Listener {

    static Material[][][] structure = {
        {
            {Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN},
            {Material.AIR, Material.POLISHED_DEEPSLATE, Material.CHISELED_DEEPSLATE, Material.POLISHED_DEEPSLATE, Material.POLISHED_DEEPSLATE_SLAB, Material.POLISHED_DEEPSLATE, Material.CHISELED_DEEPSLATE, Material.POLISHED_DEEPSLATE, Material.AIR},
            {Material.AIR, Material.POLISHED_DEEPSLATE_STAIRS, Material.AIR, Material.POLISHED_DEEPSLATE_STAIRS, Material.AIR, Material.POLISHED_DEEPSLATE_STAIRS, Material.AIR, Material.POLISHED_DEEPSLATE_STAIRS, Material.AIR},
            {Material.AIR, Material.AIR, Material.BLAST_FURNACE, Material.AIR, Material.AIR, Material.AIR, Material.BLAST_FURNACE, Material.AIR, Material.AIR}
        },
        {
            {Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN},
            {Material.POLISHED_DEEPSLATE, Material.POLISHED_DEEPSLATE_SLAB, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.POLISHED_DEEPSLATE_SLAB, Material.POLISHED_DEEPSLATE},
            {Material.POLISHED_DEEPSLATE_STAIRS, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.POLISHED_DEEPSLATE_STAIRS},
            {Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR}
        },
        {
            {Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN},
            {Material.CHISELED_DEEPSLATE, Material.AIR, Material.POLISHED_DEEPSLATE_SLAB, Material.POLISHED_DEEPSLATE_SLAB, Material.AIR, Material.POLISHED_DEEPSLATE_SLAB, Material.POLISHED_DEEPSLATE_SLAB, Material.AIR, Material.CHISELED_DEEPSLATE},
            {Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR},
            {Material.BLAST_FURNACE, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.BLAST_FURNACE}
        },
        {
            {Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN},
            {Material.POLISHED_DEEPSLATE, Material.AIR, Material.POLISHED_DEEPSLATE_SLAB, Material.POLISHED_DEEPSLATE_SLAB, Material.DIAMOND_BLOCK, Material.POLISHED_DEEPSLATE_SLAB, Material.POLISHED_DEEPSLATE_SLAB, Material.AIR, Material.POLISHED_DEEPSLATE},
            {Material.POLISHED_DEEPSLATE_STAIRS, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.POLISHED_DEEPSLATE_STAIRS},
            {Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR}
        },
        {
            {Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN},
            {Material.POLISHED_DEEPSLATE_SLAB, Material.AIR, Material.AIR, Material.DIAMOND_BLOCK, Material.CHISELED_DEEPSLATE, Material.DIAMOND_BLOCK, Material.AIR, Material.AIR, Material.POLISHED_DEEPSLATE_SLAB},
            {Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.ANVIL, Material.AIR, Material.AIR, Material.AIR,Material.AIR},
            {Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR}
        },
        {
            {Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN},
            {Material.POLISHED_DEEPSLATE, Material.AIR, Material.POLISHED_DEEPSLATE_SLAB, Material.POLISHED_DEEPSLATE_SLAB, Material.DIAMOND_BLOCK, Material.POLISHED_DEEPSLATE_SLAB, Material.POLISHED_DEEPSLATE_SLAB, Material.AIR, Material.POLISHED_DEEPSLATE},
            {Material.POLISHED_DEEPSLATE_STAIRS, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.POLISHED_DEEPSLATE_STAIRS},
            {Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR}
        },
        {
            {Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN},
            {Material.CHISELED_DEEPSLATE, Material.AIR, Material.POLISHED_DEEPSLATE_SLAB, Material.POLISHED_DEEPSLATE_SLAB, Material.AIR, Material.POLISHED_DEEPSLATE_SLAB, Material.POLISHED_DEEPSLATE_SLAB, Material.AIR, Material.CHISELED_DEEPSLATE},
            {Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR},
            {Material.BLAST_FURNACE, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.BLAST_FURNACE}
        },
        {
            {Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN},
            {Material.POLISHED_DEEPSLATE, Material.POLISHED_DEEPSLATE_SLAB, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.POLISHED_DEEPSLATE_SLAB, Material.POLISHED_DEEPSLATE},
            {Material.POLISHED_DEEPSLATE_STAIRS, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.POLISHED_DEEPSLATE_STAIRS},
            {Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR, Material.AIR}
        },
        {
            {Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN},
            {Material.AIR, Material.POLISHED_DEEPSLATE, Material.CHISELED_DEEPSLATE, Material.POLISHED_DEEPSLATE, Material.POLISHED_DEEPSLATE_SLAB, Material.POLISHED_DEEPSLATE, Material.CHISELED_DEEPSLATE, Material.POLISHED_DEEPSLATE, Material.AIR},
            {Material.AIR, Material.POLISHED_DEEPSLATE_STAIRS, Material.AIR, Material.POLISHED_DEEPSLATE_STAIRS, Material.AIR, Material.POLISHED_DEEPSLATE_STAIRS, Material.AIR, Material.POLISHED_DEEPSLATE_STAIRS, Material.AIR},
            {Material.AIR, Material.AIR, Material.BLAST_FURNACE, Material.AIR, Material.AIR, Material.AIR, Material.BLAST_FURNACE, Material.AIR, Material.AIR}
        }
    };

    @EventHandler
    public static void onClickAnvil(PlayerInteractEvent e){
        try{

            Block b = e.getClickedBlock();

            if (b.getType() == Material.ANVIL) {

                for (int x = 0; x < 9; x++) {
                    for (int y = 0; y < 4; y++) {
                        for (int z = 0; z < 9; z++) {

                            if (!b.getRelative(x - 4, y - 2, z - 4).getType().equals(structure[x][y][z])) {
                                return;
                            }

                        }
                    }
                }

                ItemStack UniverseIngot = new ItemStack(Material.NETHERITE_INGOT);
                ItemMeta UniverseIngotM = UniverseIngot.getItemMeta();
                UniverseIngotM.setDisplayName("§bIngot of the Universe");
                UniverseIngotM.setCustomModelData(1);
                UniverseIngot.setItemMeta(UniverseIngotM);

                for (int x = -1; x < 2; x = x + 2) {
                    for (int z = -1; z < 2; z = z + 2) {

                        FurnaceInventory f1 = ((Furnace) b.getLocation().add(4 * x, 1, 2 * z).getBlock().getState()).getInventory();
                        FurnaceInventory f2 = ((Furnace) b.getLocation().add(2 * x, 1, 4 * z).getBlock().getState()).getInventory();

                        if (!f1.contains(UniverseIngot) || !f2.contains(UniverseIngot)) {
                            return;
                        }

                    }
                }

                for (int x = -1; x < 2; x = x + 2) {
                    for (int z = -1; z < 2; z = z + 2) {

                        FurnaceInventory f1 = ((Furnace) b.getLocation().add(4 * x, 1, 2 * z).getBlock().getState()).getInventory();
                        FurnaceInventory f2 = ((Furnace) b.getLocation().add(2 * x, 1, 4 * z).getBlock().getState()).getInventory();

                        f1.clear();
                        f2.clear();

                        b.getLocation().add(4 * x, 0, 2 * z).getBlock().setType(Material.LAVA);
                        b.getLocation().add(2 * x, 0, 4 * z).getBlock().setType(Material.LAVA);

                    }
                }

                new BukkitRunnable(){

                    @Override
                    public void run() {
                        b.getLocation().add(0, -1, 1).getBlock().setType(Material.MAGMA_BLOCK);
                        b.getLocation().add(0, -1, -1).getBlock().setType(Material.MAGMA_BLOCK);
                        b.getLocation().add(1, -1, 0).getBlock().setType(Material.MAGMA_BLOCK);
                        b.getLocation().add(-1, -1, 0).getBlock().setType(Material.MAGMA_BLOCK);

                        for (int x = -1; x < 2; x = x + 2) {
                            for (int z = -1; z < 2; z = z + 2) {

                                b.getLocation().add(4 * x, 0, 2 * z).getBlock().setType(Material.AIR);
                                b.getLocation().add(2 * x, 0, 4 * z).getBlock().setType(Material.AIR);

                            }
                        }
                    }

                }.runTaskLater(main.getPlugin(), 180);


            }



        }catch (Exception exception){
            return;
        }
    }

}
