package com.github.brokendust.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExampleCommand implements CommandExecutor {
    @Override
    /*
    *
    * sender -> 发送者
    * command -> 命令
    * label -> 真正发送的东西
    * args -> 参数
    *   参数详解:
    *      参数索引从0开始,如在我们要实现的功能中,/sendmessage <player> <message>
    *      player即为args[0]
    *      message即为args[1]
    *
    * */
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //为什么要判断args长度是0呢,当你输入/sendmessage时,并没有指定任何参数,该命令依旧执行,提醒他命令参数不全
        if (args.length == 0){
            sender.sendMessage("§7[§4!§7]§4命令参数不全,Usage: /sendmessage <player> <message>");
        }
        /*
        *
        * Java知识点: 数组的索引下标与数组长度的辨析
        *   下标从0开始计算
        *   而数组长度从1开始计算
        *
        * */
        if (args.length >= 1){
            if (Bukkit.getPlayerExact(args[0]) != null){
                if (args.length == 2){
                    Player player = Bukkit.getPlayerExact(args[0]);
                    player.sendMessage(args[1]);
                }else {
                    sender.sendMessage("§7[§4!§7]§4命令参数不全,Usage: /sendmessage <player> <message>");
                }
            }else {
                sender.sendMessage("§7[§4!§7]§4玩家不在线");
            }
        }
        return false;
    }
}
