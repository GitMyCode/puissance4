package Models;

/**
 * Created by mb on 2/19/14.
 */
public class Ai extends Player {
    public Ai(int color, String name) {
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
