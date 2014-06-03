package com.saesdev.adminutils;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import com.saesdev.adminutils.helper.Helper;
import com.saesdev.adminutils.helper.SQLHelper;

public class UserLoginHandler implements Listener {
	
	private String ip;
	private String uuid;
	
	@EventHandler
	public void onLogin(PlayerLoginEvent e) {
		ip = e.getAddress().toString();
		uuid = e.getPlayer().getUniqueId().toString();
		
		SQLHelper.execute("INSERT INTO users WHERE (`user`, `UUID`, `address`) VALUES (`" + e.getPlayer().getName() + "`, `" + uuid + "`, `" + ip + "`);");
		Helper.getLogger().info("IP & UUID Stored for " + e.getPlayer().getName());
		
		
	}

}
