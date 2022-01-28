package com.util;


import com.event.welcomeMsg;
import com.homeward;
import com.listeners.GUIDragListener;
import com.listeners.GUIClickListener;
import com.listeners.GUIMoveListener;


//事件注册器，用来集中注册事件
public class EventRegister extends CommandRegister {

    public homeward plugin;

    public EventRegister(homeward plugin) {
        this.plugin = plugin;
    }

    public void RegisterEvent() {
        System.out.println("事件模块开始注册");
        plugin.getServer().getPluginManager().registerEvents(new welcomeMsg(), plugin);
//        plugin.getServer().getPluginManager().registerEvents(new GUIOpenEvent(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new GUIClickListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new GUIDragListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new GUIMoveListener(), plugin);
        System.out.println("事件模块注册完毕");

    }

}
