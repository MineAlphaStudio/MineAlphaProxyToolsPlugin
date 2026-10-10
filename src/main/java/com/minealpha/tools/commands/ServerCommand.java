package com.minealpha.tools.commands;

import com.minealpha.tools.MineAlphaProxyTools;
import com.minealphaproxy.api.command.CommandSource;
import com.minealphaproxy.api.command.MineAlphaCommand;

public final class ServerCommand extends MineAlphaCommand {

    private final MineAlphaProxyTools plugin;

    public ServerCommand(MineAlphaProxyTools plugin) {
        super("server", "Switch server", "/server <name>", null, "srv");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSource sender, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("§7Сервера:");
            plugin.getProxy().getServers().forEach(s ->
                    sender.sendMessage("§7- §f" + s.getName() + " §7("
                            + s.getAddress() + ":" + s.getPort() + ")"));
            return;
        }
        sender.sendMessage("§eСмена серверов пока в разработке.");
    }
}