package com.saesdev.adminutils.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class IPHelper {
	
	public boolean hasAlt(UUID uuid) {
		
		return false;
	}
	
	public String[] listAlts(UUID uuid) {
		//In Development - Need Database
		return null;
	}
	
	public String[] listAccounts(String ipAddress) {
		//In Development - Need Database
		return null;
	}
	
	public String getIP(UUID uuid) throws SQLException {
		String ipAddr = null;
		ResultSet rs = SQLHelper.getData("SELECT * from `address` WHERE UUID = '" + uuid.toString() + "';");
		rs.first();
		ipAddr = rs.getString("address");
		return ipAddr;
	}
	
	public void addIP(UUID user, String addr) {
		
	}

}
