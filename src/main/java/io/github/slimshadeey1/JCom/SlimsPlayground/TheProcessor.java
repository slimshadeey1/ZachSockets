package io.github.slimshadeey1.JCom.SlimsPlayground;

/**
 * Created by Ben Byers on 8/23/2014.
 */
public class TheProcessor {
    String Data;
    public TheProcessor(String dat){
        Data = dat;
    }
    public String getResponse(){
        try {
            String[] parsed = Data.split("-");
            String username = parsed[0];
            String key = parsed[1];
            String process = parsed[2];
        /*
        Method to execute with the new info
         */
            new Executor(username,key,process);
            return "done";
        }catch(Exception e){
            return e.getMessage();
        }
    }
}
