package Models;

/**
 * Created by mb on 2/23/14.
 */
public interface GridInterface {


    boolean checkWin(int color);
    boolean checkAvailibility(int index);
    void sendChange();
    int getLenght();
    int getCol();
    int getRow();
    boolean isFull();
    GridInterface copyGrid();

    Memento storeInMemento();
    void restoreFromMemento(Memento memento);
}
