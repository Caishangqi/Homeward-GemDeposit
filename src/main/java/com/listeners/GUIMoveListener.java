package com.listeners;

import com.gui.GUI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.InventoryHolder;

public class GUIMoveListener implements Listener {
    @EventHandler
    public void onGUIDrag(InventoryMoveItemEvent e) {

        InventoryHolder holder = e.getSource().getHolder();

        if (holder instanceof GUI) {

            e.setCancelled(true);


            if (e.getItem() == null) {
                return;
            }

            GUI ui = (GUI) holder;
            ui.moveItem(e);
        }
    }
}
