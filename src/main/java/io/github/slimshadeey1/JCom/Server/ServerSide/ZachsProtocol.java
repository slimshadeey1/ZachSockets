package io.github.slimshadeey1.JCom.Server.ServerSide;

/**
 * Created by Ben Byers on 8/8/2014.
 */
public class ZachsProtocol {
    private static final int WAITING = 0;
    private static final int SENTCONNECTED = 1;
    private static final int HANDSHAKE = 2;
    private static final int RESPONSE = 3;
    private String check = "Zach443"; //This could be a password or hardcoded, to ensure that this is the right thing :)
    private String handShake = "Ok!";//This should be hardcoded but can also be a password that is secret, this is used to
    // tell the client its ok to communicate now.

    private static final int NUMJOKES = 5;

    private int state = WAITING;
    private int currentJoke = 0;

    private String[] clues = {};
    private String[] answers = {};

    public String processInput(String theInput) {
        String theOutput = null;

        if (state == WAITING) {
            theOutput = "Server Connected";
            state = SENTCONNECTED;
        } else if (state == SENTCONNECTED) {
            if (theInput.equalsIgnoreCase(check)) {
                theOutput = handShake;
                state = HANDSHAKE;
            } else {
                theOutput = "Error in HandShake!";
            }
        } else if (state == HANDSHAKE) {
            /*
            In here is where we receive the primary info!
            Whatever you act on, you do it here. I would
            personally make a HashMap with methods, which
            I can explain if need be, but for simplicity I
            will do a switch case
             */
            switch (theInput){
                case "Button1":
                    /*
                    The methods to be run here when button one is pressed, for now lets just echo back a simple string
                     */
                    String response = "You have pressed: "+theInput+" which makes me do this!";
                    break;
                default:
                    /*
                    Error message to be returned here.
                     */
                    break;
            }
        } else if (state == RESPONSE) {
            if (theInput.equalsIgnoreCase("end")) {
                theOutput = "close";
            }
        }
        return theOutput;
    }
}
