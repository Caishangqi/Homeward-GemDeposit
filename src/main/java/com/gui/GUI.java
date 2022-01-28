package com.gui;

import com.util.PlayerMenuUtility;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public abstract class GUI implements InventoryHolder {

    protected String value;

    protected String menuName;

    protected List<Integer> doWorkSlot;

    protected Inventory inventory;

    protected PlayerMenuUtility playerMenuUtility;

    public GUI(PlayerMenuUtility playerMenuUtility) {
        this.playerMenuUtility = playerMenuUtility;
    }

    public abstract String getMenuName();

    public abstract void setMenuName(String menuName);
    public abstract int getSlot();

    public abstract void handelMenu(InventoryClickEvent e);
    public abstract void dragItem(InventoryDragEvent e);
    public abstract void moveItem(InventoryMoveItemEvent e);

    public abstract void setMenuItems();

    public void open() {

        inventory = Bukkit.createInventory(this, getSlot(), getMenuName());
        this.setMenuItems();

        playerMenuUtility.getOwner().openInventory(inventory);

    }

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }
}
