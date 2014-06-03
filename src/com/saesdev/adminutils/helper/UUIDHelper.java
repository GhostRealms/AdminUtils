package com.saesdev.adminutils.helper;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class UUIDHelper {
	
	public static UUID getPlayerUUID(String username) {
		return UUID.fromString(username);
	}
	
	public static String getUserfromID(UUID uuid) {
		Player p = Bukkit.getPlayer(uuid);
		return p.getName();
	}
	
	public boolean hasAlt(UUID uuid) {
		//In Development - Need Database Connections
		return false;
	}
	
	public String[] listAlts(UUID uuid) {
		//In Development - Need Database Connectons
		return null;
	}

}
