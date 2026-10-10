package com.minealpha.tools.commands;

import com.minealpha.tools.MineAlphaProxyTools;
import com.minealphaproxy.api.MineAlphaPlayer;
import com.minealphaproxy.api.command.CommandSource;
import com.minealphaproxy.api.command.MineAlphaCommand;

import java.util.stream.Collectors;

public final class MListCommand extends MineAlphaCommand {

    private final MineAlphaProxyTools plugin;

    public MListCommand(MineAlphaProxyTools plugin) {
        super("mlist", "List online players", "/mlist", null, "list", "plist");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSource sender, String[] args) {
        if (plugin.getProxy().getPlayerCount() == 0) {
            sender.sendMessage("§7Сейчас никого нет онлайн.");
            return;
        }
        String names = plugin.getProxy().getPlayers().stream()
                .map(MineAlphaPlayer::getName)
                .collect(Collectors.joining("§7, §f"));
        sender.sendMessage("§8§m------§r §aОнлайн: §f"
                + plugin.getProxy().getPlayerCount() + " §8§m------");
        sender.sendMessage("§f" + names);
    }
}