package io.github.slimshadeey1.JCom.Server.ServerSide;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Created by Ben Byers on 8/8/2014.
 */
public class ServerMain {
    public ServerMain() {
        Integer portNumber = 80;
        Boolean listening = true;
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
                while (listening) {
                    new ClientHandler(serverSocket.accept()).start();
                }
            } catch (IOException e) {
                System.err.println("Could not listen on port " + portNumber);
        }
    }
}
