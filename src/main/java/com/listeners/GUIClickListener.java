package com.listeners;

import com.gui.GemDepositGUI;
import com.gui.GUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

public class GUIClickListener implements Listener {

    @EventHandler
    public void onGUIClick(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();

        if (e.getClickedInventory() == null)
            return;

        InventoryHolder holder = e.getClickedInventory().getHolder();

        InventoryHolder top = e.getView().getTopInventory().getHolder();

        if (e.getClick().isShiftClick() && top instanceof GemDepositGUI) {
            System.out.println("这是一个shift点击");
            System.out.println(top);
            e.setCancelled(true);
            return;
        }

        //if (holder instanceof EvoGUI) {
        /**
         * 上方是错误的代码，holder使用了 e.getClickedInventory().getHolder(); 但是
         * 这个时候菜单没有初始化，在打印holder的时候是我的背包，所以获取上面的GUI.getTop
         * Inventory() 来修正这个功能
         */
        if (holder instanceof GemDepositGUI) {


            e.setCancelled(true);

//            if (e.getClick().isShiftClick()) {
//                System.out.println("这是一个shift点击");
//                return;
//            }

            if (e.getCurrentItem() == null) {
                //神奇代码 我不知道为什么但是成功了
                System.out.println(e.getCursor().getType());
                ;
            }


            GUI ui = (GUI) holder;
            ui.handelMenu(e);
        }



    }

}
