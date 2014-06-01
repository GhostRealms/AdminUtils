package com.saesdev.adminutils.modules;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kill implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] string) {
		if(cmd.getLabel().equalsIgnoreCase("kill")) {
			if(sender.hasPermission("adminutils.commands.kill")) {
				Player player = (Player)sender;
				player.setHealth(0);
				return true;
			} else {
				sender.sendMessage(ChatColor.RED + "Invalid permissions!");
				return true;
			}
		}
		if(cmd.getLabel().equalsIgnoreCase("killall")) {
			if(sender.hasPermission("adminutils.commands.kill.all")) {
				for(Player player : Bukkit.getOnlinePlayers()) {
					player.setHealth(0);
				}
				sender.sendMessage(ChatColor.GREEN + "Killed all players");
				return true;
			} else {
				sender.sendMessage(ChatColor.RED + "Invalid permissions!");
				return true;
			}
		}
		return false;
	}

}
