package de.morgon.echocrafti.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import static de.morgon.echocrafti.lifesteal.LifestealKill.onStealLife;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public static void onPlayerDeath(PlayerDeathEvent e){
        onStealLife(e);
    }

}
