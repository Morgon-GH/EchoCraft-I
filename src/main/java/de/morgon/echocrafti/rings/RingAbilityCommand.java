package de.morgon.echocrafti.rings;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RingAbilityCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if(args.length > 0) {
         if(args[0].equals("add")) {
             Player p = (Player) commandSender;
             ChangeRingAbilities.addAbility(args[1], p.getItemInHand());
         }


        }
        return false;
    }
}
