package com.minealpha.tools.commands;

import com.minealpha.tools.MineAlphaProxyTools;
import com.minealphaproxy.api.command.CommandSource;
import com.minealphaproxy.api.command.MineAlphaCommand;

public final class PingCommand extends MineAlphaCommand {

    private final MineAlphaProxyTools plugin;

    public PingCommand(MineAlphaProxyTools plugin) {
        super("ping", "Proxy status", "/ping", null, "gp");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSource sender, String[] args) {
        sender.sendMessage("§7Прокси работает. Онлайн: §f"
                + plugin.getProxy().getPlayerCount());
        sender.sendMessage("§7Версия: §f" + plugin.getProxy().getVersion());
    }
}