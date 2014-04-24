package me.LF.LFPlugins;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LFT implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player spelare = (Player) sender;
		Player spelare1 = spelare.getServer().getPlayer(args[0]);
		Player spelare2 = spelare.getServer().getPlayer(args[1]);
		Location spelare1p = spelare1.getLocation();
		Location spelare2p = spelare2.getLocation();
		
		if(commandLabel.equalsIgnoreCase("lft")){
		spelare.sendMessage(ChatColor.AQUA + "[LF]" + ChatColor.GREEN + "För få argument!: Använd /lft [NAMN] eller /lft [NAMN] (NAMN)");
		    }
		else if(args.length == 1){
			spelare.teleport(spelare1p);
			spelare.sendMessage(ChatColor.AQUA + "[LF]" + ChatColor.GREEN + "Teleporterad till " + spelare1.getDisplayName() + ".");
			spelare1.sendMessage(ChatColor.AQUA + "[LF]" + ChatColor.GREEN + spelare.getDisplayName() + " har teleporterat till dig!");	
		}
		else if(args.length == 2){
			spelare1.teleport(spelare2p);
			spelare.sendMessage(ChatColor.AQUA + "[LF]" + ChatColor.GREEN + "Teleporterade " + spelare1.getDisplayName() + " till " + spelare2.getDisplayName() + ".");
			spelare1.sendMessage(ChatColor.AQUA + "[LF]" + ChatColor.GREEN + "Teleporterad till " + spelare2.getDisplayName() + ".");
			spelare.sendMessage(ChatColor.AQUA + "[LF]" + ChatColor.GREEN + "Teleporterad till " + spelare1.getDisplayName() + ".");			
			spelare2.sendMessage(ChatColor.AQUA + "[LF]" + ChatColor.GREEN + spelare1.getDisplayName() + " har teleporterat till dig!");
		}
		else{
			spelare.sendMessage(ChatColor.AQUA + "[LF]" + ChatColor.RED + "För många argument! Anväd: /lft [Namn] ellse /lft [Namn] [Namn]" );
		}

		return false;
	}

}