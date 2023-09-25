package de.morgon.echocrafti.claiming;

import de.morgon.echocrafti.files.ClaimSaves;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CheckClaimCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){

            Player p = (Player) commandSender;
            String dim = p.getWorld().getName();
            String loc = dim + "," + p.getLocation().getChunk().getX() + "," + p.getLocation().getChunk().getZ();
            String team = ClaimSaves.get().getString(loc);

            if (team != null){
                p.sendMessage("This chunk has been claimed by " + team);
            }else{
                p.sendMessage("This chunk is not claimed");
            }

        }else commandSender.equals("Must be executed by player");

        return false;
    }
}
