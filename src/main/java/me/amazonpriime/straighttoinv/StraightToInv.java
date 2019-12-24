package me.amazonpriime.straighttoinv;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class StraightToInv extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();
        Bukkit.getServer().getPluginManager().registerEvents(new DropItemListener(this), this);
    }
}
