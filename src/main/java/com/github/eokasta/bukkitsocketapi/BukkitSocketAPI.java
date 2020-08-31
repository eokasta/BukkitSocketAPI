package com.github.eokasta.bukkitsocketapi;

import com.github.eokasta.bukkitsocketapi.socket.SocketNotification;
import com.github.eokasta.bukkitsocketapi.tests.Listeners;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitSocketAPI extends JavaPlugin {

    private SocketNotification socketNotification;

    @Override
    public void onEnable() {
        this.socketNotification = new SocketNotification(this, 45000);
        socketNotification.init();
        new Listeners(this);

        Bukkit.getScheduler().scheduleSyncDelayedTask(this, () ->
                socketNotification.send("Testando!"), 20L);
    }

    @Override
    public void onDisable() {
        socketNotification.close();
    }

}
