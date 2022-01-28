package com;

import com.util.*;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.logging.Logger;

public final class homeward extends JavaPlugin {

    private static final Logger log = Logger.getLogger("Minecraft");

    public ConfigFactory configFactory; //配置工厂 自制

    private static Economy econ = null;

    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();

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
        new EventRegister(this).RegisterEvent();
        new CommandRegister(this).RegisterCommand();


        if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println(ChatColor.translateAlternateColorCodes('&', "&7&l[&c-&7] &f关闭成功"));

    }

    public static  PlayerMenuUtility getPlayerMenuUtility(Player player) {

        PlayerMenuUtility playerMenuUtility;

        if(playerMenuUtilityMap.containsKey(player)) {
            return  playerMenuUtilityMap.get(player);
        } else {
            playerMenuUtility = new PlayerMenuUtility(player);
            playerMenuUtilityMap.put(player,playerMenuUtility);

            return playerMenuUtility;

        }

    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static Economy getEcon() {
        return econ;
    }
}
