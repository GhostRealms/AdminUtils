package com.saesdev.adminutils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.saesdev.adminutils.helper.Helper;

public class plugincommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.hasPermission("adminutils.info")) {
			if(args.length == 0) {
				sender.sendMessage(ChatColor.YELLOW + "[AdminUtils] " + ChatColor.GOLD + Helper.getPluginVersion());
				return true;
			} else {
				sender.sendMessage(Helper.invArgs());
				return false;
			}
		} else {
			sender.sendMessage(Helper.noPerms());
			return false;
		}
	}

}
