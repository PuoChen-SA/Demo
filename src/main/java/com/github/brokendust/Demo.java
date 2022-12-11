package com.github.brokendust;

import com.github.brokendust.command.ExampleCommand;
import com.github.brokendust.listener.ListenPlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Demo extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Hello World");
        getCommand("sendmessage").setExecutor(new ExampleCommand());
        Bukkit.getPluginManager().registerEvents(new ListenPlayerJoin() , this);
    }

    @Override
    public void onDisable() {

    }

}