package io.github.slimshadeey1.JCom.Server.ServerSide;

/**
 * Created by Ben Byers on 8/8/2014.
 */
    import java.net.*;
    import java.io.*;

    public class ClientHandler extends Thread {
        private Socket socket = null;

        public ClientHandler(Socket socket) {
            super("ClientHandler");
            this.socket = socket;
        }

        public void run() {

            try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));

                String inputLine, outputLine;
                ZachsProtocol zp = new ZachsProtocol();
                outputLine = zp.processInput(null);
                out.println(outputLine);

                while ((inputLine = in.readLine()) != null) {
                    outputLine = zp.processInput(inputLine);
                    out.println(outputLine);
                    if (outputLine.equals("Bye"))
                        break;
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

