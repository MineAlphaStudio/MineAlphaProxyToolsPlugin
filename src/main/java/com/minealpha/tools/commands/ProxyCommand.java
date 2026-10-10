package com.minealpha.tools.commands;

import com.minealpha.tools.MineAlphaProxyTools;
import com.minealphaproxy.api.command.CommandSource;
import com.minealphaproxy.api.command.MineAlphaCommand;

public final class ProxyCommand extends MineAlphaCommand {

    private final MineAlphaProxyTools plugin;

    public ProxyCommand(MineAlphaProxyTools plugin) {
        super("proxy", "Proxy info", "/proxy", null, "proxyinfo");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSource sender, String[] args) {
        sender.sendMessage("§8§m-------§r §aMineAlphaProxy §8§m-------");
        sender.sendMessage("§7Версия:       §f" + plugin.getProxy().getVersion());
        sender.sendMessage("§7Бренд:        §f" + plugin.getProxy().getBrand());
        sender.sendMessage("§7Игроков:      §f" + plugin.getProxy().getPlayerCount());
        sender.sendMessage("§7По умолч.:    §f" + plugin.getProxy().getDefaultServer());
        sender.sendMessage("§7Разработчик:  §eMineAlphaStudio");
    }
}