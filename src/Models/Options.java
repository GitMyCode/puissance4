package Models;

/**
 * Created by MB on 3/29/14.
 */
public class Options {
    boolean allowClickAbove;
    int player1Type;
    int player2Type;
    int startingPlayer;
    int sizeX;
    int sizeY;




    public Options(){
       defaultOptions();
    }
    private void defaultOptions(){
        allowClickAbove =false;
        player1Type = 0;
        player2Type = 0;
        startingPlayer = 1;
        sizeX = 7;
        sizeY = 6;

    }

}
