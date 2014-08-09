package io.github.slimshadeey1.JCom.Server.ServerPostVersion;

import org.apache.http.*;
import org.apache.http.impl.*;
import org.apache.http.params.*;
import org.apache.http.protocol.*;
import org.apache.http.util.*;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Created by Ben Byers on 8/9/2014.
 */
public class ZachMultiThread extends Thread {

    private Socket clientSocket = null;

    public ZachMultiThread(Socket socket){
        super("Zach443_Client_Handler");
        clientSocket = socket;
    }
    public void Start(){
        DefaultHttpServerConnection conn = new DefaultHttpServerConnection();
        try {
            conn.bind(clientSocket, new BasicHttpParams());
            HttpRequest test = conn.receiveRequestHeader();
            HttpEntity entity = null;
            if(test instanceof HttpEntityEnclosingRequest)
                entity = ((HttpEntityEnclosingRequest)test).getEntity();
            byte[] data;
            if (entity == null){
                data = new byte[0];
            }else {
                data = EntityUtils.toByteArray(entity);
            }
            String[] nData = new String(data).split(" ");
            switch(nData[0]){
                case "Slimshadeey1":
                    //Whatever you want to do here
                    HttpResponse response =
                    conn.sendResponseHeader();
            }
        }catch (Exception e){}
    }


}
