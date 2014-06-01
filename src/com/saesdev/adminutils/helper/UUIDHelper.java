package com.saesdev.adminutils.helper;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class UUIDHelper {
	
	public UUID getPlayerUUID(String username) {
		Player p = Bukkit.getPlayer(username);
		
		UUID UUID = p.getUniqueId();
		
		return UUID;
	}
	
	public String getUserfromID(UUID uuid) {
		Player p = Bukkit.getPlayer(uuid);
		String username = p.getName();
		return username;
	}
	
	public boolean hasAlt(UUID uuid) {
		//In Development - Need Database Connections
		String sUUID = uuid.toString();
		return false;
	}
	
	public String[] listAlts(UUID uuid) {
		//In Development - Need Database Connectons
		return null;
	}

}
