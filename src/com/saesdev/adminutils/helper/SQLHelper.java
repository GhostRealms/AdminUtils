package com.saesdev.adminutils.helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLHelper {
	
	private Connection c = null;
	private Statement statement = null;
	
	public SQLHelper(Connection c) {
		this.c = c;
		if(c != null) {
			try {
				statement = c.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			Helper.getLogger().severe("Failed to Initialize SQLite Connection.");
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
