package de.morgon.echocrafti.lifesteal;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class LifestealKill {

    public static void onStealLife(PlayerDeathEvent e){

        Player victim = e.getEntity();
        Entity killer = e.getEntity().getKiller();

        if (killer instanceof Player) {
            victim.setMaxHealth(victim.getMaxHealth() - 2);
            ((Player)killer).setMaxHealth(((Player)killer).getMaxHealth() + 2);
        }

        for (Player p: Bukkit.getOnlinePlayers()) {
            p.sendMessage(killer.getName() + " has gained a heart by killing " + victim.getName());
        }

    }

}
