package io.github.slimshadeey1.JCom.Server.ServerPostVersion;


import org.apache.http.impl.*;

import java.io.*;
import java.net.*;

/**
 * Created by Ben Byers on 8/8/2014.
 */
public class ServerMain {
    public static void Start() {
        Boolean listening = true;
        Integer portNumber = 80;
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (listening) {
                new ZachMultiThread(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
        }
    }
}

