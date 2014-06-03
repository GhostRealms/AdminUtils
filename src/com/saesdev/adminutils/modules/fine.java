package com.saesdev.adminutils.modules;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.saesdev.adminutils.helper.Helper;

public class fine implements CommandExecutor {
	
	private Economy econ = null;
	
	public fine(Economy econ) {
		this.econ = econ;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.hasPermission("adminutils.fine.fine")) {
			if(econ.getBalance(args[0]) >= Integer.parseInt(args[1])) {
				econ.withdrawPlayer(args[0], Integer.parseInt(args[1]));
				Helper.getLogger().info(sender.getName() + " withdrew " + args[1] + " from " + args[0]);
			} else {
				sender.sendMessage(ChatColor.GREEN + "[Fine] " + ChatColor.RED + "Insufficient funds");
			}
		} else {
			sender.sendMessage(Helper.noPerms());
			return false;
		}
		return false;
	}

}
