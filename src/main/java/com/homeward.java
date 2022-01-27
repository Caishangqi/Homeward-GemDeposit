package com;

import com.util.ConfigFactory;
import com.util.DateLogger;
import com.util.commandRegister;
import com.util.eventRegister;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class homeward extends JavaPlugin {

    public ConfigFactory configFactory; //配置工厂 自制

    @Override
    public void onEnable() {
        System.out.println(ChatColor.translateAlternateColorCodes('&', "&7&l[&2+&7] &f加载成功"));
        // Plugin startup logic
        //注册默认Config,没有的话创建一个
        saveDefaultConfig();

        //注册自定义config
        this.saveResource("settings.yml", true);
        new DateLogger(this).modifyDateByDefault();
        //注册配置工厂
        configFactory = new ConfigFactory(this);

        //注册指令注册器
        //注册事件注册器
        new eventRegister(this).RegisterEvent();
        new commandRegister(this).RegisterCommand();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println(ChatColor.translateAlternateColorCodes('&', "&7&l[&c-&7] &f关闭成功"));

    }
}
