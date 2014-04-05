package Models.Facades;

import java.util.Observer;

/**
 * Created by mb on 2/23/14.
 */
public interface GridFacadeInterface {


    void reset();
    void newGrid(int row, int col,boolean clickAbove);
    void saveState();
    void loadPreviousState();
    boolean existsPreviousState();
    void addObserver(Observer observer);


    boolean checkWin(int color);
    boolean checkAvailibility(int index);

    void changeSquare(int index,int playerTurn);

    int getLenght();
    int getCol();
    int getRow();
    boolean isFull();
    GridFacadeInterface copyGridFacade();

}
