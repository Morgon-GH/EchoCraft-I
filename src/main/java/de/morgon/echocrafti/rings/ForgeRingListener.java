package de.morgon.echocrafti.rings;

import de.morgon.echocrafti.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Vector;

public class ForgeRingListener implements Listener {



    @EventHandler
    public static void onClickAnvil(PlayerInteractEvent e){
        try{

            Block b = e.getClickedBlock();
            Player p = e.getPlayer();

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

                int item;

                if(e.getItem().getType().equals(Material.GOLDEN_APPLE)){
                    item = 1;
                    removeItem(p);
                }else if (e.getItem().getType().equals(Material.GILDED_BLACKSTONE)){
                    item = 2;
                    removeItem(p);
                } else if (e.getItem().getType().equals(Material.ENDER_EYE)) {
                    item = 3;
                    removeItem(p);
                }else if (e.getItem().getType().equals(Material.CRYING_OBSIDIAN)){
                    item = 4;
                    removeItem(p);
                }else if (e.getItem().getType().equals(Material.SCULK)){
                    item = 5;
                    removeItem(p);
                }else return;

                Animation(e);

                new BukkitRunnable(){

                    @Override
                    public void run() {

                        if (item == 1){
                            HeavensRing(b);
                        }else if (item == 2){
                            DarknessRing(b);
                        }else if (item == 3){
                            AstralRing(b);
                        }else if (item == 4){
                            EarthRing(b);
                        }else if (item == 5){
                            NecromancyRing(b);
                        }

                    }
                }.runTaskLater(main.getPlugin(), 240);
            }
        }catch (Exception exception){
            return;
        }
    }

    public static void removeItem(Player p){

        ItemStack item = p.getItemInHand();
        item.setAmount(item.getAmount() - 1);

    }


    public static void Animation(PlayerInteractEvent e){

        e.setCancelled(true);
        Block b = e.getClickedBlock();

        LavaFurnace(e.getClickedBlock());

        new BukkitRunnable(){
            @Override
            public void run() {
                MagmaLava(e.getClickedBlock());
            }
        }.runTaskLater(main.getPlugin(), 180);

        new BukkitRunnable(){
            int i = 0;
            @Override
            public void run(){

                i++;
                if (i < 40){

                    Particles(e.getClickedBlock());

                }else cancel();
            }
        }.runTaskTimer(main.getPlugin(), 200, 1);

        new BukkitRunnable(){
            @Override
            public void run() {
                b.getRelative(1, -1, 0).setType(Material.AIR);
                b.getRelative(-1, -1, 0).setType(Material.AIR);
                b.getRelative(0, -1, 1).setType(Material.AIR);
                b.getRelative(0, -1, -1).setType(Material.AIR);
            }
        }.runTaskLater(main.getPlugin(), 240);

    }

    public static void LavaFurnace(Block b){
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
    }


    public static void MagmaLava(Block b){

        b.getLocation().add(0, -1, 1).getBlock().setType(Material.MAGMA_BLOCK);
        b.getLocation().add(0, -1, -1).getBlock().setType(Material.MAGMA_BLOCK);
        b.getLocation().add(1, -1, 0).getBlock().setType(Material.MAGMA_BLOCK);
        b.getLocation().add(-1, -1, 0).getBlock().setType(Material.MAGMA_BLOCK);

        for (Player p: Bukkit.getOnlinePlayers()) {
            p.spawnParticle(Particle.FLAME, b.getLocation().add(0, -1, 1), 10);
            p.spawnParticle(Particle.FLAME, b.getLocation().add(0, -1, -1), 10);
            p.spawnParticle(Particle.FLAME, b.getLocation().add(1, -1, 0), 10);
            p.spawnParticle(Particle.FLAME, b.getLocation().add(-1, -1, 0), 10);
        }

        for (int x = -1; x < 2; x = x + 2) {
            for (int z = -1; z < 2; z = z + 2) {

                b.getLocation().add(4 * x, 0, 2 * z).getBlock().setType(Material.AIR);
                b.getLocation().add(2 * x, 0, 4 * z).getBlock().setType(Material.AIR);

            }
        }
    }

    public static void Particles(Block b){


        for (Player p : Bukkit.getOnlinePlayers()) {

            p.spawnParticle(Particle.FLAME, b.getLocation().add(1.5, -0.5, 0.5), 0, 0, 0.2, 0);
            p.spawnParticle(Particle.FLAME, b.getLocation().add(-0.5, -0.5, 0.5), 0, 0, 0.2, 0);
            p.spawnParticle(Particle.FLAME, b.getLocation().add(0.5, -0.5, 1.5), 0, 0, 0.2, 0);
            p.spawnParticle(Particle.FLAME, b.getLocation().add(0.5, -0.5, -0.5), 0, 0, 0.2, 0);

        }
    }

    public static void HeavensRing(Block b){

        ItemStack ring = new ItemStack(Material.PAPER);
        ItemMeta ringM = ring.getItemMeta();
        ringM.setDisplayName(ChatColor.AQUA + "Heavens Ring");
        ringM.setCustomModelData(1);
        ring.setItemMeta(ringM);

        for (Player p: Bukkit.getOnlinePlayers()) {
            p.spawnParticle(Particle.EXPLOSION_LARGE, b.getLocation().add(0.5, 2, 0.5), 10);
        }

        Entity item = b.getWorld().dropItemNaturally(b.getLocation().add(0, 1.5, 0), ring);
        item.setGravity(false);
        item.setGlowing(true);
        item.setVelocity(new org.bukkit.util.Vector(0, 0, 0));

    }

    public static void DarknessRing(Block b){

        ItemStack ring = new ItemStack(Material.PAPER);
        ItemMeta ringM = ring.getItemMeta();
        ringM.setDisplayName(ChatColor.AQUA + "Darkness Ring");
        ringM.setCustomModelData(2);
        ring.setItemMeta(ringM);

        for (Player p: Bukkit.getOnlinePlayers()) {
            p.spawnParticle(Particle.EXPLOSION_LARGE, b.getLocation().add(0.5, 2, 0.5), 10);
        }

        Entity item = b.getWorld().dropItemNaturally(b.getLocation().add(0, 1.5, 0), ring);
        item.setGravity(false);
        item.setGlowing(true);
        item.setVelocity(new org.bukkit.util.Vector(0, 0, 0));

    }

    public static void AstralRing(Block b){

        ItemStack ring = new ItemStack(Material.PAPER);
        ItemMeta ringM = ring.getItemMeta();
        ringM.setDisplayName(ChatColor.AQUA + "Astral Ring");
        ringM.setCustomModelData(3);
        ring.setItemMeta(ringM);

        for (Player p: Bukkit.getOnlinePlayers()) {
            p.spawnParticle(Particle.EXPLOSION_LARGE, b.getLocation().add(0.5, 2, 0.5), 10);
        }

        Entity item = b.getWorld().dropItemNaturally(b.getLocation().add(0, 1.5, 0), ring);
        item.setGravity(false);
        item.setGlowing(true);
        item.setVelocity(new org.bukkit.util.Vector(0, 0, 0));

    }

    public static void EarthRing(Block b){

        ItemStack ring = new ItemStack(Material.PAPER);
        ItemMeta ringM = ring.getItemMeta();
        ringM.setDisplayName(ChatColor.AQUA + "Earth Ring");
        ringM.setCustomModelData(4);
        ring.setItemMeta(ringM);

        for (Player p: Bukkit.getOnlinePlayers()) {
            p.spawnParticle(Particle.EXPLOSION_LARGE, b.getLocation().add(0.5, 2, 0.5), 10);
        }

        Entity item = b.getWorld().dropItemNaturally(b.getLocation().add(0, 1.5, 0), ring);
        item.setGravity(false);
        item.setGlowing(true);
        item.setVelocity(new org.bukkit.util.Vector(0, 0, 0));

    }

    public static void NecromancyRing(Block b){

        ItemStack ring = new ItemStack(Material.PAPER);
        ItemMeta ringM = ring.getItemMeta();
        ringM.setDisplayName(ChatColor.AQUA + "Necromancy Ring");
        ringM.setCustomModelData(5);
        ring.setItemMeta(ringM);

        for (Player p: Bukkit.getOnlinePlayers()) {
            p.spawnParticle(Particle.EXPLOSION_LARGE, b.getLocation().add(0.5, 2, 0.5), 10);
        }

        Entity item = b.getWorld().dropItemNaturally(b.getLocation().add(0, 1.5, 0), ring);
        item.setGravity(false);
        item.setGlowing(true);
        item.setVelocity(new org.bukkit.util.Vector(0, 0, 0));

    }

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

}
