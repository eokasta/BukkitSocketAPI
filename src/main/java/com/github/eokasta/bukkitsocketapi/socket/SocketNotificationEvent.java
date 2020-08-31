package com.github.eokasta.bukkitsocketapi.socket;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.net.ServerSocket;
import java.net.Socket;

@Data
@RequiredArgsConstructor
public class SocketNotificationEvent extends Event {

    @Getter
    private static HandlerList handlerList = new HandlerList();

    private final ServerSocket serverSocket;
    private final Socket client;
    private final String message;

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
