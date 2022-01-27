package com.util;

import com.homeward;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

//// 读取配置文件
//// this.getDataFolder()方法返回插件配置文件夹的File对象
//File biuConfigFile = new File(this.getDataFolder(), "biu.yml");
//// 也可以在插件配置文件夹创建一个新的文件夹以存放配置文件
//// File biuConfigFile = new File(this.getDataFolder(), "test/biu.yml");
//        FileConfiguration biuConfig = YamlConfiguration.loadConfiguration(biuConfigFile);
//        biuConfig.get.......
//        biuConfig.set.......
//// set完了记得保存!
//        biuConfig.save(biuConfigFile);

public class ConfigFactory {

    private static homeward plugin;
    private File settingFile = null;
    YamlConfiguration settingFileYaml = null;


    public ConfigFactory(homeward plugin) {
        this.plugin = plugin;
    }


    public static FileConfiguration getConfig() {
        return plugin.getConfig();
    }

    public YamlConfiguration getSettings() {

        try {
            YamlConfiguration settingFileYaml = YamlConfiguration.loadConfiguration(settingFile);

        } catch (Exception e) {
            File settingFile = new File(plugin.getDataFolder(), "settings.yml");
        } finally {
            return settingFileYaml;
        }


    }

}
