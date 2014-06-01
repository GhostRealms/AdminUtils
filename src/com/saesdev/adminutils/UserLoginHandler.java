package com.saesdev.adminutils;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import com.saesdev.adminutils.helper.SQLHelper;

public class UserLoginHandler implements Listener {
	
	private String ip;
	
	@EventHandler
	public void onLogin(PlayerLoginEvent e) {
		ip = e.getAddress().toString();
		
		
	}

}
