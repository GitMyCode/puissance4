package Models;

/**
 * Created by MB on 3/29/14.
 */
public class Options {

    final int HUMAN = 0;
    final int AI    = 1;


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
        allowClickAbove =true;
        player1Type = GLOBAL.HUMAN;
        player2Type = GLOBAL.HUMAN;
        startingPlayer = 1;
        sizeX = 7;
        sizeY = 6;

    }

    public boolean isAllowClickAbove() {
        return allowClickAbove;
    }

    public void setAllowClickAbove(boolean allowClickAbove) {
        this.allowClickAbove = allowClickAbove;
    }

    public int getPlayer1Type() {
        return player1Type;
    }

    public void setPlayer1Type(int player1Type) {
        this.player1Type = player1Type;
    }

    public int getPlayer2Type() {
        return player2Type;
    }

    public void setPlayer2Type(int player2Type) {
        this.player2Type = player2Type;
    }

    public int getStartingPlayer() {
        return startingPlayer;
    }

    public void setStartingPlayer(int startingPlayer) {
        this.startingPlayer = startingPlayer;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }
}
