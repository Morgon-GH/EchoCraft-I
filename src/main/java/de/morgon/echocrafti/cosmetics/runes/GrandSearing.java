package de.morgon.echocrafti.cosmetics.runes;

import de.morgon.echocrafti.main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class GrandSearing {
    public static void searingRune() {

        new BukkitRunnable() {
            final double[] y = {0};
            double radius = 0.7;
            @Override
            public void run() {

                for (Player p: Bukkit.getOnlinePlayers()
                     ) {
                    try{
                        if(p.getInventory().getChestplate().getItemMeta().getDisplayName().equals("Grand Searing Chestplate")) {

                            Location loc1 = p.getLocation();
                            Location loc2 = p.getLocation();

                            double x = radius * Math.sin(y[0]);
                            double z = radius * Math.cos(y[0]);

                            for (Player a: Bukkit.getOnlinePlayers()
                                 ) {

                                a.spawnParticle(Particle.SOUL_FIRE_FLAME, loc1.add(x, 0, z), 0, 0, 0.2, 0);
                                a.spawnParticle(Particle.SOUL_FIRE_FLAME, loc2.add(-x, 0, -z), 0, 0, 0.2, 0);

                                loc1.add(-x, 0, -z);
                                loc2.add(x, 0, z);

                            }

                            if (y[0] <= 2 * Math.PI) {
                                y[0] = y[0] + 0.1;
                            } else y[0] = 0;

                        }
                    }catch (Exception exeption){
                        return;
                    }
                }
            }
        }.runTaskTimer(main.getPlugin(), 1, 1);
    }
}
