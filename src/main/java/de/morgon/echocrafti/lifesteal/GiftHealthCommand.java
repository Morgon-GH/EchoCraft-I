package de.morgon.echocrafti.lifesteal;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Optional;

public class GiftHealthCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){

            Player p = (Player) commandSender;

            if (strings.length == 2){
                try {
                    int hearts = Integer.parseInt(strings[1]);
                    int health = hearts * 2;

                    Player q = Bukkit.getPlayer(strings[0]);

                    if (p.isOp()) {

                        p.setMaxHealth(p.getMaxHealth() - health);
                        q.setMaxHealth(q.getMaxHealth() + health);

                        for (Player player : Bukkit.getOnlinePlayers()) {
                            player.sendMessage(p.getName() + " gifted " + hearts + " hearts to " + q.getName());
                        }

                    } else commandSender.sendMessage("You need to be op");

                }catch (Exception exception){
                    commandSender.sendMessage("Please use '/gifthealth <Player> <Amount of Hearts>'");
                }

            }else commandSender.sendMessage("Please use '/gifthealth <Player> <Amount of Hearts>'");
        }else commandSender.sendMessage("Command must be executed by a player");

        return false;
    }
}
