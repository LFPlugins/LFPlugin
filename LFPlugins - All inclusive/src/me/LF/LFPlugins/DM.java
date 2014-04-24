package me.LF.LFPlugins;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class DM implements CommandExecutor{
  
	public void onEnable() {		
		getConfig().options().copyDefaults(true);
		saveConfig();
	}


	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		PluginManager pm = getServer().getPluginManager();
		Player player = (Player) sender;
		if (commandLabel.equalsIgnoreCase("dm")) {
			if (args.length == 0) {
				player.sendMessage(ChatColor.AQUA + "[LF] " + ChatColor.GREEN
						+ getConfig().getString("DM"));
				player.sendMessage(ChatColor.AQUA + "[LF] " + ChatColor.GREEN
						+ getConfig().getString("MDM"));

			}

			else {
				player.sendMessage(ChatColor.AQUA + "[LF] " + ChatColor.RED
						+ "För många argument!: /dm ");

			}

		}

		

		return false;
	}

}
