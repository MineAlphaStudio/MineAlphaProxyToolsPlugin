package com.minealpha.tools.commands;

import com.minealpha.tools.MineAlphaProxyTools;
import com.minealphaproxy.api.MineAlphaPlayer;
import com.minealphaproxy.api.command.CommandSource;
import com.minealphaproxy.api.command.MineAlphaCommand;

import java.util.Arrays;
import java.util.Optional;

public final class KickCommand extends MineAlphaCommand {

    private final MineAlphaProxyTools plugin;

    public KickCommand(MineAlphaProxyTools plugin) {
        super("kick", "Kick player", "/kick <nick> [reason]", null, "gkick");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSource sender, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("§cИспользование: §f/kick <ник> [причина]");
            return;
        }
        String name = args[0];
        String reason = args.length > 1
                ? String.join(" ", Arrays.copyOfRange(args, 1, args.length))
                : "Кикнут администратором";

        Optional<MineAlphaPlayer> target = plugin.getProxy().getPlayer(name);
        if (target.isEmpty()) {
            sender.sendMessage("§cИгрок §f" + name + " §cне найден.");
            return;
        }
        MineAlphaPlayer p = target.get();
        p.kick("§c§lВы были кикнуты\n§r§7Причина: §f" + reason);
        sender.sendMessage("§aИгрок §f" + p.getName() + " §aкикнут.");
        plugin.getLogger().info("[KICK] {} кикнул {} — {}",
                sender.getName(), p.getName(), reason);
    }
}