package com.util;


import com.command.OpenDepositGUI;
import com.homeward;

//用来测试命令注册
public class commandRegister {
    public homeward plugin;

    public commandRegister() {
        System.out.println("初始化构造器");
    }

    public commandRegister(homeward plugin) {
        this.plugin = plugin;
    }

    public void RegisterCommand() {
        System.out.println("指令模块开始注册");
//        plugin.getCommand("vault").setExecutor(new VaultCommand());
        plugin.getCommand("gemdeposit").setExecutor(new OpenDepositGUI());
        System.out.println("指令模块注册完毕");
    }
}
