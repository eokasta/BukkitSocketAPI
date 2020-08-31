package com.github.eokasta.bukkitsocketapi.socket;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@RequiredArgsConstructor
@Getter
public class SocketNotification {

    private final JavaPlugin plugin;
    private final int port;
    private ServerSocket serverSocket;

    public void init() {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            try {
                serverSocket = new ServerSocket(port);
                listen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void listen() {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            try {
                while (serverSocket != null) {
                    final Socket accept = serverSocket.accept();
                    final DataInputStream inputStream = new DataInputStream(accept.getInputStream());

                    final String message = inputStream.readUTF();
                    final SocketNotificationEvent event = new SocketNotificationEvent(serverSocket, accept, message);
                    Bukkit.getServer().getPluginManager().callEvent(event);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void send(String message) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            try {
                final Socket socket = new Socket(serverSocket.getInetAddress(), port);
                final DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                outputStream.writeUTF(message);
            } catch (java.net.ConnectException ignored) {
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void close() {
        try {
            if (!serverSocket.isClosed())
                serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
