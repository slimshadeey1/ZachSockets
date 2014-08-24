package io.github.slimshadeey1.JCom.SlimsPlayground;

import java.io.*;
import java.net.*;

/**
 * Created by Ben Byers on 8/23/2014.
 */
public class DServerThread extends Thread {
    Socket socket;

    public DServerThread(Socket sock) {
        super("DServerThread");
        this.socket = sock;
    }

    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(
                    socket.getInputStream()
                )
            );
            String data = in.readLine();
            /*
            This can now be used in a easy manner, as the data is a string! and we can call a method to do what it needs to do.
             */
            out.print(new TheProcessor(data).getResponse());
        }catch (IOException e){}
    }
}