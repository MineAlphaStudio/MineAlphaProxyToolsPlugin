package com.minealpha.tools.commands;

import com.minealpha.tools.MineAlphaProxyTools;
import com.minealphaproxy.api.MineAlphaPlayer;
import com.minealphaproxy.api.command.CommandSource;
import com.minealphaproxy.api.command.MineAlphaCommand;

import java.util.Optional;

public final class FindCommand extends MineAlphaCommand {

    private final MineAlphaProxyTools plugin;

    public FindCommand(MineAlphaProxyTools plugin) {
        super("find", "Find player info", "/find <nick>", null, "whereis");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSource sender, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("§cИспользование: §f/find <ник>");
            return;
        }
        String name = args[0];
        Optional<MineAlphaPlayer> found = plugin.getProxy().getPlayer(name);
        if (found.isEmpty()) {
            sender.sendMessage("§cИгрок §f" + name + " §cне найден.");
            return;
        }
        MineAlphaPlayer p = found.get();
        sender.sendMessage("§8§m----------§r §e" + p.getName() + " §8§m----------");
        sender.sendMessage("§7UUID:    §f" + p.getUniqueId());
        sender.sendMessage("§7IP:      §f" + p.getAddress());
        sender.sendMessage("§7Онлайн:  " + (p.isOnline() ? "§aда" : "§cнет"));
    }
}