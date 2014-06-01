package com.saesdev.adminutils;

/*
 * AdminUtils is an Administration Utility Plugin for Bukkit. It is licenced under GNU GPLv3.
 * Authors: Rmarmorstein, Pluto1099, [Add Your Name Here If you Contribute :)]
 */

import java.sql.Connection;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.saesdev.adminutils.helper.SQLHelper;
import com.saesdev.adminutils.modules.Kill;

public class AdminUtils extends JavaPlugin {
	
	private Logger log = this.getLogger();
	private FileConfiguration config = this.getConfig();
	SQLHelper sqlhelper;
	
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		sqlhelper = new SQLHelper(this);
		sqlhelper.initalize();
		
		try {
			Metrics metrics = new Metrics(this);
			metrics.start();
		} catch(Exception e) {
			
		}

		
		if(config.getBoolean("moules.kill")) {
			getCommand("kill").setExecutor(new Kill());
			getCommand("killall").setExecutor(new Kill());
		}
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public Plugin plugin() {
		return Bukkit.getPluginManager().getPlugin("AdminUtils");
	}
	
	public SQLHelper getSQL() {
		return sqlhelper;
	}

}
