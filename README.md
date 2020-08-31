# BukkitSocketAPI
### A simple Socket API with Bukkit.

* To initiate connection to the ServerSocket:
```java
SocketNotification socketNotification = new SocketNotification(/* your JavaPlugin */, /* your port */);
socketNotification.init();
```

* To send a message to ServerSocket:
```java
socketNotification.send("Message");
```

* To listen to the message that was sent:
```java
@EventHandler
public void onListen(SocketNotificationEvent event) {
    System.out.println(event.getMessage());
}
```

* To close connection to the ServerSocket:
```java
socketNotification.close();
```