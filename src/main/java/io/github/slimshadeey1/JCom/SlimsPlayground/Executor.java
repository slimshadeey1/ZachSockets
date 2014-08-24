package io.github.slimshadeey1.JCom.SlimsPlayground;

import org.bukkit.*;
import org.bukkit.entity.*;

/**
 * Created by Ben Byers on 8/23/2014.
 */
public class Executor {
    private String theKey = "myKey";

    public Executor(String user, String key, String process) {
        if (key == theKey) {
            Player player = Bukkit.getPlayer(user); //In case you need it.
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), process);//This executes the command in the process
        } else {
            Bukkit.getLogger().warning("User: " + user + " Has been used in attempt to fake the donation! " +
                    "They tried running the command: " + process + " With key: " + key);
        }
    }
}

