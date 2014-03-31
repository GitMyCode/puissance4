package Models.Player;

import Models.algorithme.MinMax;

/**
 * Created by mb on 2/19/14.
 */
public class Ai extends Player {
    public Ai(int color ) {
        super(color);
    }

    @Override
    public boolean play(int index) {
        int move =MinMax.getMove(super.mGrid);
       return super.play(move);
    }

    @Override
    public boolean hasWin() {
        return super.hasWin();
    }

    @Override
    public boolean isReadyToPlay() {
        return true; // Le AI est toujoru pres a jouer
    }

    @Override
    public int getColor() {
        return super.getColor();
    }


    @Override
    public void setReady(boolean turn) {
        super.setReady(turn);
    }

    @Override
    public void setTurn(boolean turn) {
        super.setTurn(turn);
    }

    @Override
    public boolean getTurn() {
        return super.getTurn();
    }

}
