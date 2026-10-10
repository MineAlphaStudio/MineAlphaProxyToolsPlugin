# MineAlphaProxyTools

> Official admin tools plugin for [MineAlphaProxy](https://github.com/MineAlphaStudio/MineAlphaProxy) — 11 admin commands out of the box.

## About

**MineAlphaProxyTools** is the first-party plugin shipped with the MineAlphaProxy ecosystem. It provides essential administrative commands for server owners and moderators.

Built with the **MineAlpha Plugin API** — no external dependencies, single JAR, drop-in installation.

## Features

- **11 admin commands** — from alerts to player management
- **Zero configuration** — works out of the box
- **Console + in-game** — commands work from both places
- **Rus/Eng messages** — built-in localization
- **ANSI colors** — clean console output
- **Plugin events** — reacts to player join/leave, proxy start

## Installation

1. Download `MineAlphaProxyTools-1.0.0.jar` from [Releases](../../releases)
2. Place it in the `MineAlphaPlugins/` folder of your MineAlphaProxy server
3. Restart the proxy

Check console for:

    Loaded MineAlpha plugin: minealphaproxy_tools v1.0.0
    ========================================
      MineAlphaProxyTools v1.0.0
      by MineAlphaStudio
    ========================================
    Registered command: /alert
    ...
    MineAlphaProxyTools включён

## Commands

| Command | Aliases | Description |
|---|---|---|
| /alert | /a | Broadcast alert to all players |
| /broadcast | /bc | Broadcast with frame formatting |
| /find | /whereis | Show player UUID, IP, online status |
| /ip | /getip | Show player IP address |
| /kick | /gkick | Kick a player with optional reason |
| /mlist | /list, /plist | List all online players |
| /ping | /gp | Show proxy status and version |
| /proxy | /proxyinfo | Show detailed proxy information |
| /send | /gsend | Move player to another server (WIP) |
| /server | /srv | Switch server (WIP) |
| /tools | /mtools, /mat | Show all available commands |

## Building from Source

    git clone https://github.com/MineAlphaStudio/MineAlphaProxyToolsPlugin.git
    cd MineAlphaProxyToolsPlugin
    ./gradlew clean build

Output: `build/libs/MineAlphaProxyTools-1.0.0.jar`

**Note:** Building requires the main `MineAlphaProxy` JAR to be present at `D:/MineAlphaProxy1/build/libs/MineAlphaProxy-1.0.1-ALPHA.jar`, or adjust the path in `build.gradle.kts`.

## Plugin Structure

    MineAlphaProxyTools/
    |-- build.gradle.kts
    |-- settings.gradle.kts
    +-- src/main/
        |-- java/com/minealpha/tools/
        |   |-- MineAlphaProxyTools.java      <- main class
        |   +-- commands/
        |       |-- AlertCommand.java
        |       |-- BroadcastCommand.java
        |       |-- FindCommand.java
        |       |-- IpCommand.java
        |       |-- KickCommand.java
        |       |-- MListCommand.java
        |       |-- PingCommand.java
        |       |-- ProxyCommand.java
        |       |-- SendCommand.java
        |       |-- ServerCommand.java
        |       +-- ToolsCommand.java
        +-- resources/
            +-- minealpha-plugin.yml          <- plugin descriptor

## Plugin Descriptor

`minealpha-plugin.yml`:

    id: minealphaproxy_tools
    name: MineAlphaProxyTools
    version: 1.0.0
    author: MineAlphaStudio
    description: Admin utilities for MineAlphaProxy
    main: com.minealpha.tools.MineAlphaProxyTools

## Roadmap

| Version | Status | Changes |
|---|---|---|
| 1.0.0 | Released | 11 admin commands |
| 1.1.0 | Planned | Real /server (Respawn + Config state) |
| 1.2.0 | Planned | /mute, /unmute, /ban, /unban |
| 1.3.0 | Planned | Config file, permission system |
| 2.0.0 | Planned | Full command argument tab-completion |

## Known Limitations

- `/server` and `/send` are **stubs** — actual server switching is in development
- Commands currently work from **console**; in-game chat support is in development
- Permission checks are not yet enforced (`hasPermission` always returns `true`)

## Reporting Issues

Found a bug? [Open an issue](../../issues/new) with:

- Plugin version
- MineAlphaProxy version
- Command that failed
- Console log output

## Contributing

Pull requests welcome. For major changes, open an issue first to discuss what you would like to change.

## License

MIT License — see [LICENSE](LICENSE).

## Credits

- **MineAlphaStudio** — plugin author
- **ViaVersion Team** — proxy ecosystem inspiration
- **Kyori** — Adventure API

## Links

- **Main proxy:** [MineAlphaProxy](https://github.com/MineAlphaStudio/MineAlphaProxy)
- **Plugin collection:** [MineAlphaPlugins](https://github.com/MineAlphaStudio/MineAlphaPlugins)
- **Issues:** [Report a bug](../../issues)

---

**Made with love by MineAlphaStudio**