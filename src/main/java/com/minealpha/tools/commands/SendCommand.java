package com.minealpha.tools.commands;

import com.minealpha.tools.MineAlphaProxyTools;
import com.minealphaproxy.api.MineAlphaPlayer;
import com.minealphaproxy.api.command.CommandSource;
import com.minealphaproxy.api.command.MineAlphaCommand;

import java.util.Optional;

public final class SendCommand extends MineAlphaCommand {

    private final MineAlphaProxyTools plugin;

    public SendCommand(MineAlphaProxyTools plugin) {
        super("send", "Send player to server", "/send <nick> <server>", null, "gsend");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSource sender, String[] args) {
        if (args.length < 2) {
            sender.sendMessage("§cИспользование: §f/send <ник> <сервер>");
            return;
        }
        Optional<MineAlphaPlayer> target = plugin.getProxy().getPlayer(args[0]);
        if (target.isEmpty()) {
            sender.sendMessage("§cИгрок §f" + args[0] + " §cне найден.");
            return;
        }
        sender.sendMessage("§7Игрок §f" + target.get().getName()
                + " §7будет отправлен на §f" + args[1]);
        sender.sendMessage("§eСмена серверов пока в разработке.");
    }
}