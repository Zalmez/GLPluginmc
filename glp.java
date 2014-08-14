package me.boredgamerz.GamerLanPlugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class GamerLanPlugin extends JavaPlugin {
	protected FileConfiguration config;
	public static GamerLanPlugin plugin;

	public void onEnable() {
		getLogger().info("Plugin På");
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

	public void onDisable() {
		getLogger().info("Plugin Av");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("gl")) {
				if (args.length == 0) {
					player.sendMessage(ChatColor.GREEN + "[Gamer-Lan]" + ChatColor.WHITE + " " + "------------ " + "Her er en liste over Kommandoer" + " ------------");
					player.sendMessage(ChatColor.GREEN + "[Gamer-Lan]" + ChatColor.WHITE + " " + "/Gl " + ChatColor.AQUA + ":" + "Viser denne listen over kommandoer");
					player.sendMessage(ChatColor.GREEN + "[Gamer-Lan]" + ChatColor.WHITE + " " + "/Gl regler" + ChatColor.AQUA + ":" + " Viser deg alle reglene i denne compoen");
					player.sendMessage(ChatColor.GREEN + "[Gamer-Lan]" + ChatColor.WHITE + " " + "/Gl hjelp 'in-game navn'" + ChatColor.AQUA + ":" + "Tilkaller hjelp fra en i crewet (hvis det er noen online)");

					// player.sendMessage(ChatColor.GREEN + "[Gamer-Lan]" +
					// ChatColor.WHITE + "kommando" + "funksjon");
				}
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("regler")) {
						player.sendMessage(ChatColor.GREEN + "[Gamer-Lan]" + " " + ChatColor.AQUA + getConfig().getString("Regler"));
						saveConfig();
					}
				}
			}
		}
		return false;

	}
}
