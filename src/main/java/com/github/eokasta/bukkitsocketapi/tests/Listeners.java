package com.github.eokasta.bukkitsocketapi.tests;

import com.github.eokasta.bukkitsocketapi.socket.SocketNotificationEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Listeners implements Listener {

    private final JavaPlugin plugin;

    public Listeners(JavaPlugin plugin) {
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onListen(SocketNotificationEvent event) {
        plugin.getLogger().info(String.format(
                "%s:%s - %s",
                event.getServerSocket().getInetAddress().getHostAddress(),
                event.getServerSocket().getLocalPort(),
                event.getMessage())
        );
    }
}
