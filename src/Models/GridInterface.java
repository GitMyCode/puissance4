package Models;

/**
 * Created by mb on 2/23/14.
 */
public interface GridInterface {


    boolean checkWin(int color);
    boolean checkAvailibility(int index);
    int getLenght();
    int getCol();
    int getRow();
    boolean isFull();
    GridInterface copyGrid();

    void changeSquare(int index,int playerTurn);
    void sendChange();

    Memento storeInMemento();
    void restoreFromMemento(Memento memento);
}
