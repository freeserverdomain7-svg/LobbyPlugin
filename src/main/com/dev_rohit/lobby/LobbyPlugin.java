package com.dev_rohit.lobby;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class LobbyPlugin extends JavaPlugin {
    private ScoreboardManager scoreboardManager;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.scoreboardManager = new ScoreboardManager(this);

        // Register commands
        this.getCommand("lobby").setExecutor(new TeleportCommand(this, "lobby"));
        this.getCommand("hub").setExecutor(new TeleportCommand(this, "hub"));
        this.getCommand("spawn").setExecutor(new TeleportCommand(this, "spawn"));
        this.getCommand("npc").setExecutor(new NpcCommandBridge(this));

        // Events
        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);

        getLogger().info("LobbyPlugin enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("LobbyPlugin disabled");
    }

    public ScoreboardManager getScoreboardManager() { return scoreboardManager; }
}
