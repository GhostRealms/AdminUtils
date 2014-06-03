package com.saesdev.adminutils.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.bukkit.ChatColor;

import com.saesdev.adminutils.AdminUtils;

public class Helper {
	
	private static AdminUtils plugin;
	
	private static Logger log = plugin.getLogger();
	private static AdminUtils au = plugin;
	private static List<UUID> loggedInUsers = new ArrayList<UUID>();
	
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
	
	public static AdminUtils getPlugin() {
		return au;
	}
	
	public static String getPluginVersion() {
		return au.getDescription().getVersion();
	}
	
	public static boolean isServerSecured() {
		return au.getConfig().getBoolean("modules.security");
	}
	
	public static void login(UUID user) {
		loggedInUsers.add(user);
	}
	
	public static void logout(UUID user) {
		loggedInUsers.remove(user);
	}
	
	public static boolean isEnabled(String modname) {
		boolean status = au.getConfig().getBoolean("modules." + modname);
		return status;
	}
}
