package com.minealpha.tools.commands;

import com.minealpha.tools.MineAlphaProxyTools;
import com.minealphaproxy.api.command.CommandSource;
import com.minealphaproxy.api.command.MineAlphaCommand;

public final class ToolsCommand extends MineAlphaCommand {

    private final MineAlphaProxyTools plugin;

    public ToolsCommand(MineAlphaProxyTools plugin) {
        super("tools", "Show tools help", "/tools", null, "mtools", "mat");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSource sender, String[] args) {
        sender.sendMessage("§8§m----- §aMineAlphaProxyTools §7by §eMineAlphaStudio §8§m-----");
        sender.sendMessage("§e/alert <текст> §7— предупреждение всем");
        sender.sendMessage("§e/broadcast <текст> §7— объявление");
        sender.sendMessage("§e/find <ник> §7— информация об игроке");
        sender.sendMessage("§e/ip <ник> §7— IP игрока");
        sender.sendMessage("§e/kick <ник> §7— кикнуть игрока");
        sender.sendMessage("§e/mlist §7— список онлайн");
        sender.sendMessage("§e/ping §7— статус прокси");
        sender.sendMessage("§e/proxy §7— информация о прокси");
        sender.sendMessage("§e/send <ник> <сервер> §7— перемещение");
        sender.sendMessage("§e/server <имя> §7— смена сервера");
        sender.sendMessage("§7Версия: §f1.0.0");
    }
}