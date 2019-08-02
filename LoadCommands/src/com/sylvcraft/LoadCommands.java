package com.sylvcraft;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;

public class LoadCommands extends JavaPlugin {
  @Override
  public void onEnable() {
    processCommands();    
  }
  
  void processCommands() {
  	saveDefaultConfig();
  	for (String command : getConfig().getStringList("instant")) {
  		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
  	}
  	
  	long delay = getConfig().getLong("delay");
  	if (delay == 0) return;
  	Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
  		@Override
  		public void run() {
  	  	for (String command : getConfig().getStringList("delayed")) {
  	  		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
  	  	}
  		}
  	}, delay * 20);
  }
}