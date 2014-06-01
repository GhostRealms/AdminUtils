package com.saesdev.adminutils;

/*
 * AdminUtils is an Administration Utility Plugin for Bukkit. It is licenced under GNU GPLv3.
 * Authors: Rmarmorstein, Pluto1099, [Add Your Name Here If you Contribute :)]
 */

import java.sql.Connection;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.saesdev.adminutils.helper.SQLite;

public class AdminUtils extends JavaPlugin {
	
	private Logger log = this.getLogger();
	private FileConfiguration config = this.getConfig();
	private SQLite sqlite;
	public Connection c = null;
	
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		sqlite = new SQLite(this, config.getString("database-name"));
		c = sqlite.openConnection();
		if(sqlite.getConnection() != null) {
			log.info("Connected To Database.");
		} else {
			log.severe("Error getting Database. Disabling AdminUtils! Please Report this Error.");
			getServer().getPluginManager().disablePlugin(this);
		} 
		
		
	}
	
	@Override
	public void onDisable() {
		
	}

}
