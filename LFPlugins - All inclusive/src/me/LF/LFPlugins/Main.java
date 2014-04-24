package me.LF.LFPlugins;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin{
	public static Main plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	public FileConfiguration config = getConfig();
	public ChatColor AQUA = ChatColor.AQUA;
	public ChatColor RED = ChatColor.RED;
	public ChatColor WHITE = ChatColor.WHITE;
	

	public void onEnable() {
		getCommand("lft").setExecutor(new LFT());
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info("[" + pdfFile.getName() + "]" + pdfFile.getVersion() +" har aktiverats!");
		
	}
	
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info("[" + pdfFile.getName() + "]" + " Har avaktiverats!");
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;
		
		if(commandLabel.equalsIgnoreCase("lf")){
			if(player.hasPermission("UsePlugin"))
			if(args.length == 0){
				sender.sendMessage("Använd /lf help");
			}
			
			// /lf - 0 args /lf help - 1 args 
			else if (args.length > 0) {
				if(args[0].equalsIgnoreCase("help")){
					sender.sendMessage(AQUA + "=== LFPlugin ===");
					sender.sendMessage(WHITE + "/lft - Teleporterar dig till en annan spelare");
					sender.sendMessage(WHITE + "/lf help");
					sender.sendMessage(WHITE + "/dm - Dagens Meddelande");
					sender.sendMessage(WHITE + "/mdm - Morgondagens Meddelande");
					sender.sendMessage(WHITE + "/modeon - Sätter mode till On");
					sender.sendMessage(WHITE + "/modeoff - Sätter mode till Off");
					sender.sendMessage(WHITE + "/mode - Visar vilket mode somn är på");
					sender.sendMessage(WHITE + "/lf perms - Visar alla permissions");
				}else if(args[0].equalsIgnoreCase("perms")){
					if(player.hasPermission("ViewPerms")){
						sender.sendMessage(WHITE + "lf.viewperms , lf.dm , lf.mdm , lf.use, lf.tp , lf.tp.otherplayers");
					}
					 
					
				}
			}
		}
		return false;
	}
			
}
