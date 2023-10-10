package de.morgon.echocrafti.cosmetics.runes;

import de.morgon.echocrafti.main;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class test{
    public static void searingRune(Player p) {

        new BukkitRunnable() {
            final double[] y = {0};
            double radius = 0.7;
            @Override
            public void run() {

                Location loc = p.getLocation();
                Location loc2 = p.getLocation();

                double x = radius * Math.sin(y[0]);
                double z = radius * Math.cos(y[0]);

                p.spawnParticle(Particle.SOUL_FIRE_FLAME, loc.add(x, 0, z), 0, 0, 0.2, 0);
                p.spawnParticle(Particle.SOUL_FIRE_FLAME, loc2.add(-x, 0, -z), 0, 0, 0.2, 0);

                if (y[0] <= 2 * Math.PI){
                    y[0] = y[0] + 0.1;
                }else y[0] = 0;
            }
        }.runTaskTimer(main.getPlugin(), 1, 1);
    }
}
