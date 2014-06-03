package com.saesdev.adminutils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
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
		Player p = e.getPlayer();
		ip = e.getAddress().toString();
		uuid = e.getPlayer().getUniqueId().toString();
		
		SQLHelper.execute("INSERT INTO users WHERE (`user`, `UUID`, `address`) VALUES (`" + p.getName() + "`, `" + uuid + "`, `" + ip + "`);");
		Helper.getLogger().info("IP & UUID Stored for " + p.getName());
		
		if(Helper.isServerSecured()) {
			if(p.isOp()) {
				p.setOp(false);
				p.sendMessage(ChatColor.GRAY + "[Security] " + ChatColor.RED + "You have been Deopped for Security.");
				p.sendMessage(ChatColor.GRAY + "[Security] " + ChatColor.RED + "Please do /security login [your password]");
			}
		}
		
	}

}
