package me.amazonpriime.straighttoinv;

import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.plugin.Plugin;

public final class DropItemListener implements Listener {

    private final Plugin plugin;

    public DropItemListener(final Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockDrop(BlockDropItemEvent event) {
        if (plugin.getConfig().getBoolean("enabled")) {
            Player player = event.getPlayer();
            event.setCancelled(true);
            for (Item item : event.getItems()) {
                String message = plugin.getConfig().getString("message");
                message = message.replace("{block}", item.getItemStack().getType().toString());
                message = message.replace("{quantity}", Integer.toString(item.getItemStack().getAmount()));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));;
                player.getInventory().addItem(item.getItemStack());
            }
        }
    }
}
