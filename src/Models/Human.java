package Models;

/**
 * Created by MB on 3/29/14.
 */
public class Human extends Player{




    public Human(int color, String name) {
        super(color, name);
    }

    @Override
    public void play(int index) {
        super.play(index);


    }

    @Override
    public boolean hasWin() {
        return super.hasWin();
    }

    @Override
    public boolean isReadyToPlay() {
        return super.isReadyToPlay();
    }

    @Override
    public int getColor() {
        return super.getColor();
    }

    @Override
    public void setReady(boolean ready) {
        super.setReady(ready);
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
