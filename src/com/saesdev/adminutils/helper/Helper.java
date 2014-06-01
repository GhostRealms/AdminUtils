package com.saesdev.adminutils.helper;

import java.util.logging.Logger;

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
	
	
	
	

}
