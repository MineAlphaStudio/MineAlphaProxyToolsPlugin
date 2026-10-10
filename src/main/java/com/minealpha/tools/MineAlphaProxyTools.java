package com.minealpha.tools;

import com.minealphaproxy.api.MineAlphaPlugin;
import com.minealphaproxy.api.annotation.MineAlphaPluginInfo;
import com.minealphaproxy.api.annotation.Subscribe;
import com.minealphaproxy.api.event.PlayerJoinEvent;
import com.minealphaproxy.api.event.PlayerLeaveEvent;
import com.minealphaproxy.api.event.ProxyStartEvent;
import com.minealpha.tools.commands.*;

import java.util.concurrent.TimeUnit;

@MineAlphaPluginInfo(
        id = "minealphaproxy_tools",
        name = "MineAlphaProxyTools",
        version = "1.0.0",
        author = "MineAlphaStudio",
        description = "Admin utilities for MineAlphaProxy"
)
public class MineAlphaProxyTools extends MineAlphaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("========================================");
        getLogger().info("  MineAlphaProxyTools v1.0.0");
        getLogger().info("  by MineAlphaStudio");
        getLogger().info("========================================");

        var cm = getProxy().getCommandManager();

        cm.register(new AlertCommand(this));
        cm.register(new BroadcastCommand(this));
        cm.register(new FindCommand(this));
        cm.register(new IpCommand(this));
        cm.register(new KickCommand(this));
        cm.register(new MListCommand(this));
        cm.register(new PingCommand(this));
        cm.register(new ProxyCommand(this));
        cm.register(new SendCommand(this));
        cm.register(new ServerCommand(this));
        cm.register(new ToolsCommand(this));

        getProxy().getScheduler().runAsyncRepeating(() -> {
            getLogger().info("Онлайн: {} игроков", getProxy().getPlayerCount());
        }, 0, 60, TimeUnit.SECONDS);

        getLogger().info("MineAlphaProxyTools включён");
    }

    @Override
    public void onDisable() {
        getLogger().info("MineAlphaProxyTools выключен");
    }

    @Subscribe
    public void onStart(ProxyStartEvent event) {
        getLogger().info("Событие: прокси запущен");
    }

    @Subscribe
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("§aДобро пожаловать, §e"
                + event.getPlayer().getName() + "§a!");
        getLogger().info("→ {} зашёл ({})",
                event.getPlayer().getName(),
                event.getPlayer().getAddress());
    }

    @Subscribe
    public void onLeave(PlayerLeaveEvent event) {
        getLogger().info("← {} вышел", event.getPlayer().getName());
    }
}