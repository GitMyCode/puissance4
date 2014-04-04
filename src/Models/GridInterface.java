package Models;

import java.util.Observer;

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
    void addObserver(Observer observer);

    void changeSquare(int index,int playerTurn);

    Memento storeInMemento();
    void restoreFromMemento(Memento memento);
}
