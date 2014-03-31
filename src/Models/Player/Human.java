package Models.Player;

import Models.Grid;
import Models.GridFacadeInterface;

/**
 * Created by MB on 3/29/14.
 */
public class Human extends Player{



     private int nbCoup =0;


    public Human(int color) {
        super(color);
    }

    @Override
    public boolean play(int index) {
        if(getGrid().checkAvailibility(index)){
            getGrid().saveState();
            getGrid().changeSquare(index, getColor());

            nbCoup++;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void Undo() {
        if(mGrid.existsPreviousState()){
            System.out.println("Undo :"+getColor());
            nbCoup--;
            getGrid().loadPreviousState();
            getGrid().sendChange();
        }
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

    @Override
    protected GridFacadeInterface getGrid() {
        return super.getGrid();
    }


}
