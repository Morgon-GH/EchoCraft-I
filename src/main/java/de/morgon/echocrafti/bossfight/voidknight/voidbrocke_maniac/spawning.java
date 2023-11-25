package de.morgon.echocrafti.bossfight.voidknight.voidbrocke_maniac;

import org.bukkit.Material;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class spawning implements Listener {

    @EventHandler
    public static void OnEnderKlick(PlayerInteractEntityEvent e) {

        Player p = e.getPlayer();
        if(e.getRightClicked() instanceof Enderman && p.getItemInHand().equals(Material.DIAMOND)) {

            Entity t = e.getRightClicked();

            Enderman m = t.getLocation().getBlock().getWorld().spawn(t.getLocation().getBlock().getLocation().add(0.5, 0.5, 0.5), Enderman.class);
            m.setCustomName("§4Voidbrocke Maniac");
            m.setMaxHealth(50);
            m.setHealth(m.getMaxHealth());
            m.attack(p);

            t.remove();


        }

    }

}
