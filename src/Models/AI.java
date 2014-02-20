package Models;

/**
 * Created by mb on 2/19/14.
 */
public class AI extends Player {
    public AI(PlayerColor color, String name) {
        super(color, name);
    }

    @Override
    public void play() {
        super.play();
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
