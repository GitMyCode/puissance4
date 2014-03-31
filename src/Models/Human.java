package Models;

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
            getGrid().changeSquare(index, getColor());

            nbCoup++;
            originator.set(getGrid().getSquareGrid());
            caretaker.addMemento(originator.storeInMemento());
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void Undo() {
        if(nbCoup>0){
            System.out.println("Undo :"+getColor());
            nbCoup--;
            getGrid().setGrid(caretaker.getMemento().getMementoSave());
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
    public Grid getGrid() {
        return super.getGrid();
    }


}
