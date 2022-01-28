package com.listeners;

import com.gui.GUI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.InventoryHolder;

public class GUIDragListener implements Listener {

    @EventHandler
    public void onGUIDrag(InventoryDragEvent e) {

        InventoryHolder holder = e.getInventory().getHolder();

        if (holder instanceof GUI) {

            e.setCancelled(true);

            if (e.getCursor() == null) {
                return;
            }

            GUI ui = (GUI) holder;
            ui.dragItem(e);
        }

    }

}
