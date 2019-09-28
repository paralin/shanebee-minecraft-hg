package tk.shanebee.hg.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import tk.shanebee.hg.HG;
import tk.shanebee.hg.util.Util;
import tk.shanebee.hg.util.NBTApi;

public class NBTCmd extends BaseCmd {

	NBTApi api;

	public NBTCmd() {
		forcePlayer = true;
		cmdName = "nbt";
		forceInGame = false;
		argLength = 1;
		usage = "";
		api = HG.getPlugin().getNbtApi();
	}


	@Override
	public boolean run() {
		Player player = (Player) sender;
		CommandSender console = Bukkit.getConsoleSender();
		if (player.getInventory().getItemInMainHand().getType() != Material.AIR) {
			ItemStack item = player.getInventory().getItemInMainHand();
			Material type = item.getType();
			Util.scm(player, "&3NBT:");
			String nbtString = api.getNBT(item);
			if (nbtString == null) {
				Util.scm(player, "&cNO NBT FOUND!");
			} else {
				Util.scm(player, type.toString() + " " + item.getAmount() + " data:" + nbtString.replace(" ", "~"));
				Util.scm(player, "&6NBT String also sent to console for easy copy/pasting");
				Util.scm(console, "&3NBT string from &b" + player.getName() + "&3:");
				Util.scm(console, type.toString() + " " + item.getAmount() + " data:" + nbtString.replace(" ", "~"));
			}

		}
		return true;
	}

}