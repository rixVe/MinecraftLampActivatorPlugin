package me.rixve.lampactivator.listeners;

import me.rixve.lampactivator.LampActivator;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;

public class BlockUpdateListener implements Listener {

    @EventHandler
    public void onBlockUpdate(BlockPhysicsEvent event) {
        if(LampActivator.lamps.contains(event.getBlock())) {
            event.setCancelled(true);
        }
    }

}
