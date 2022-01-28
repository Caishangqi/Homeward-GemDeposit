package com.util;


import com.command.GemDepositCommand;
import com.homeward;

//用来测试命令注册
public class CommandRegister {
    public homeward plugin;

    public CommandRegister() {
        System.out.println("初始化构造器");
    }

    public CommandRegister(homeward plugin) {
        this.plugin = plugin;
    }

    public void RegisterCommand() {
        System.out.println("指令模块开始注册");
//        plugin.getCommand("vault").setExecutor(new VaultCommand());
        plugin.getCommand("gemdeposit").setExecutor(new GemDepositCommand());
        System.out.println("指令模块注册完毕");
    }
}
