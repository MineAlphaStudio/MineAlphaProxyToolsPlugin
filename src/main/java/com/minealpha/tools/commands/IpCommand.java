package com.minealpha.tools.commands;

import com.minealpha.tools.MineAlphaProxyTools;
import com.minealphaproxy.api.MineAlphaPlayer;
import com.minealphaproxy.api.command.CommandSource;
import com.minealphaproxy.api.command.MineAlphaCommand;

import java.util.Optional;

public final class IpCommand extends MineAlphaCommand {

    private final MineAlphaProxyTools plugin;

    public IpCommand(MineAlphaProxyTools plugin) {
        super("ip", "Show player IP", "/ip <nick>", null, "getip");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSource sender, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("§cИспользование: §f/ip <ник>");
            return;
        }
        Optional<MineAlphaPlayer> target = plugin.getProxy().getPlayer(args[0]);
        if (target.isEmpty()) {
            sender.sendMessage("§cИгрок §f" + args[0] + " §cне найден.");
            return;
        }
        sender.sendMessage("§7IP игрока §e"
                + target.get().getName() + "§7: §f"
                + target.get().getAddress());
    }
}