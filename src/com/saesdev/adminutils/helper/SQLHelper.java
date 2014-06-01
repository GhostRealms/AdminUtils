package com.saesdev.adminutils.helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.saesdev.adminutils.AdminUtils;

public class SQLHelper {
	
	private AdminUtils plugin;
	
	private Connection c = null;
	private Statement statement = null;
	private SQLite sqlite;
	
	public SQLHelper(AdminUtils plugin) {
		this.plugin = plugin;
	}
	
	public void initalize() {
		sqlite = new SQLite(plugin, plugin.getConfig().getString("settings.database-name"));
		c = sqlite.openConnection();
		if(sqlite.getConnection() == null) {
			Helper.getLogger().severe("Failed to get SQLite Connection. Disabling AdminUtils.");
			plugin.getServer().getPluginManager().disablePlugin(plugin);
		} else {
			Helper.getLogger().info("Sucessfully Initialized SQLite Connection");
		}
	}
	
	public void execute(String sql) {
		try {
			statement.execute(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet getData(String sql) throws SQLException {
		ResultSet res = statement.executeQuery(sql);
		return res;	
	}

}
