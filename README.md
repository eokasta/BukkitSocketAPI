# BukkitSocketAPI
### A simple Socket API with Bukkit.

* To initiate connection to the ServerSocket:
```
SocketNotification socketNotification = new SocketNotification(*Your JavaPlugin*, *Your Port*);
socketNotification.init();
```

* To send a message to ServerSocket:
```
socketNotification.send("Message");
```

* To listen to the message that was sent:
```
@EventHandler
public void onListen(SocketNotificationEvent event) {
    System.out.println(event.getMessage());
}
```

* To close connection to the ServerSocket:
```
socketNotification.close();
```