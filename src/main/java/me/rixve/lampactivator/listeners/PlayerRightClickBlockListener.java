package me.rixve.lampactivator.listeners;

import me.rixve.lampactivator.LampActivator;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Lightable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerRightClickBlockListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerRightClickBlockEvent(PlayerInteractEvent event) {
        if(LampActivator.eventSth) {
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                Block block = event.getClickedBlock();
                if (block.getType() == Material.REDSTONE_LAMP) {
                    Lightable lightable = (Lightable) block.getBlockData();
                    lightable.setLit(!lightable.isLit());

                    block.setBlockData(lightable);
                    event.setCancelled(true);
                    LampActivator.eventSth = false;

                    if(!LampActivator.lamps.contains(block)) {
                        LampActivator.lamps.add(block);
                    }
                }
            }
        }
        else {
            LampActivator.eventSth = true;
        }

    }
}
