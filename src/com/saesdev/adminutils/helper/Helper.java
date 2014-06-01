package com.saesdev.adminutils.helper;

import java.util.logging.Logger;

import org.bukkit.ChatColor;

import com.saesdev.adminutils.AdminUtils;

public class Helper {
	
	private static AdminUtils plugin;
	
	private static Logger log = plugin.getLogger();
	
	public Helper(AdminUtils plugin) {
		this.plugin = plugin;
	}
	
	public static Logger getLogger() {
		return log;
	}
	
	public static String invArgs() {
		return ChatColor.RED + "Invalid Arguments. Please Check command usage!";
	}
	
	public static String noPerms() {
		return ChatColor.RED + "You Don't have Permission to perform that Action!";
	}
}
