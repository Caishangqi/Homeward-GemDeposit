package com.gui;

import com.homeward;
import com.util.PlayerMenuUtility;
import com.util.CharFormatter;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class GemDepositGUI extends GUI {

    private String menuName = "\uF808" + ChatColor.translateAlternateColorCodes('&', "&f섍");

    private Economy value = homeward.getEcon();

    private List<Integer> doWorkSlot = Arrays.asList(2, 3, 4, 5, 6, 11, 12, 13, 14, 15);

    public GemDepositGUI(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return menuName + "\uF80B\uF80A\uF809\uF808" + " " + CharFormatter.valueFormat((int) value.getBalance(playerMenuUtility.getOwner()));
    }

    @Override
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }


    @Override
    public int getSlot() {
        return 36;
    }

    @Override
    public void handelMenu(InventoryClickEvent e) {

        if (doWorkSlot.contains(e.getSlot())) {

            System.out.println("(!) view " + e.getView().getCursor().getType());
            System.out.println("(!) inve " + e.getCursor().getType());
            if (e.getCursor().getType() == Material.DIAMOND) {
                int amount = e.getCursor().getAmount();
                System.out.println("合法物品 " + amount);
                value.depositPlayer(playerMenuUtility.getOwner(), amount);
                System.out.println(e.getSlot());
                System.out.println(e.getClickedInventory());

                e.getView().setCursor(new ItemStack(Material.AIR));


                new GemDepositGUI(homeward.getPlayerMenuUtility(playerMenuUtility.getOwner())).open();


                e.setCancelled(false);

            } else {
                e.setCancelled(true);
            }

        } else {
            e.setCancelled(true);
        }
    }

    @Override
    public void dragItem(InventoryDragEvent e) {
        System.out.println("");

    }

    @Override
    public void moveItem(InventoryMoveItemEvent e) {
        System.out.println(e.getItem().getType());
    }

    @Override
    public void setMenuItems() {

//        ItemStack itemStack = new ItemStack(Material.CYAN_STAINED_GLASS_PANE, 1);
//        ItemMeta itemMeta = itemStack.getItemMeta();
//        itemMeta.setDisplayName("BUTTON");
//        itemStack.setItemMeta(itemMeta);
//
//        inventory.setItem(4, itemStack);

    }
}
