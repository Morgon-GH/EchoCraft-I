package de.morgon.echocrafti.cosmetics.runes;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import static de.morgon.echocrafti.cosmetics.runes.test.searingRune;

public class TestEvent implements Listener {

    @EventHandler
    public void onWalk(PlayerInteractEvent e) {

        Player p = e.getPlayer();
        searingRune(p);
    }
}
