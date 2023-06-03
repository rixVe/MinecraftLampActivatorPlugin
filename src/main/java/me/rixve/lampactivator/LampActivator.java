package me.rixve.lampactivator;

import me.rixve.lampactivator.listeners.BlockUpdateListener;
import me.rixve.lampactivator.listeners.PlayerRightClickBlockListener;
import org.bukkit.block.Block;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class LampActivator extends JavaPlugin {

    public static boolean eventSth = true;

    public static ArrayList<Block> lamps = new ArrayList<>();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerRightClickBlockListener(), this);
        getServer().getPluginManager().registerEvents(new BlockUpdateListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
