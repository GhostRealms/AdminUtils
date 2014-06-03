package com.saesdev.adminutils;

/*
 * AdminUtils is an Administration Utility Plugin for Bukkit. It is licensed under GNU GPLv3.
 * Authors: Rmarmorstein, Pluto1099, [Add Your Name Here If you Contribute :)]
 */

import java.util.logging.Logger;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.saesdev.adminutils.helper.Helper;
import com.saesdev.adminutils.helper.SQLHelper;
import com.saesdev.adminutils.helper.Updater;
import com.saesdev.adminutils.modules.Kill;

public class AdminUtils extends JavaPlugin {
	
	//Vault objects
	public static Chat chat = null;
	public static Economy econ = null;
	
	private Logger log = this.getLogger();
	private FileConfiguration config = this.getConfig();
	SQLHelper sqlhelper;
	Helper helper;
	
	public boolean updated = false;
	private boolean autoUpdate = false;
	public String latestFileName = null;
	
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		sqlhelper = new SQLHelper(this);
		sqlhelper.initalize();
		init();
		
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
	
	private void init() {
		//Grab some variables from the config
		autoUpdate = config.getBoolean("settings.updater");
		
		// Auto Update
		if(autoUpdate) {
			Updater update = new Updater(this, 1, this.getFile(), Updater.UpdateType.DEFAULT, true);
			update.getResult();
			if(update.getResult() == Updater.UpdateResult.SUCCESS) {
				updated = true;
			} else {
				updated = false;
			}
		} else {
			Updater update = new Updater(this, 1, this.getDataFolder(), Updater.UpdateType.NO_DOWNLOAD, false);
			latestFileName = update.getLatestName() + " " + update.getLatestGameVersion();
		}
	}

}
