package com.minealpha.tools.commands;

import com.minealpha.tools.MineAlphaProxyTools;
import com.minealphaproxy.api.command.CommandSource;
import com.minealphaproxy.api.command.MineAlphaCommand;

public final class BroadcastCommand extends MineAlphaCommand {

    private final MineAlphaProxyTools plugin;

    public BroadcastCommand(MineAlphaProxyTools plugin) {
        super("broadcast", "Broadcast message", "/broadcast <msg>", null);
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSource sender, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("§cИспользование: §f/broadcast <сообщение>");
            return;
        }
        String msg = String.join(" ", args);
        plugin.getProxy().broadcastMessage(
                "§8§m----------------------------------------");
        plugin.getProxy().broadcastMessage("§e§l" + msg);
        plugin.getProxy().broadcastMessage(
                "§8§m----------------------------------------");
        sender.sendMessage("§aОтправлено §f"
                + plugin.getProxy().getPlayerCount() + " §aигрок(ам)");
    }
}