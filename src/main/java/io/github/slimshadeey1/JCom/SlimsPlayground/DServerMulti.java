package io.github.slimshadeey1.JCom.SlimsPlayground;

import java.io.*;
import java.net.*;

/**
 * Created by Ben Byers on 8/23/2014.
 */
public class DServerMulti {
    ServerSocket serverSocket;
    Boolean Accept;
    public DServerMulti(Integer port){
        try {
            serverSocket = new ServerSocket(port);
            Accept = true;
        }catch (IOException e){
            Accept = false;
        }
    }
    public void start(){
        while(Accept){
            try{
                new DServerThread(serverSocket.accept()).start();
            }catch (IOException e){}
        }
    }

}
