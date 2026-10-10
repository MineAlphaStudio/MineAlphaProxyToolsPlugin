package com.minealpha.tools.commands;

import com.minealpha.tools.MineAlphaProxyTools;
import com.minealphaproxy.api.command.CommandSource;
import com.minealphaproxy.api.command.MineAlphaCommand;

public final class AlertCommand extends MineAlphaCommand {

    private final MineAlphaProxyTools plugin;

    public AlertCommand(MineAlphaProxyTools plugin) {
        super("alert", "Broadcast alert to all", "/alert <msg>",
                null, "broadcast", "bc");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSource sender, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("§cИспользование: §f/alert <сообщение>");
            return;
        }
        String msg = String.join(" ", args);
        plugin.getProxy().broadcastMessage("§8[§c§lALERT§8] §r§f" + msg);
        sender.sendMessage("§aОтправлено §f"
                + plugin.getProxy().getPlayerCount() + " §aигрок(ам)");
        plugin.getLogger().info("[ALERT by {}] {}", sender.getName(), msg);
    }
}