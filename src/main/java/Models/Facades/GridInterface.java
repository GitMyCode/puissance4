package Models.Facades;

import Models.Memento.Memento;
import org.json.simple.JSONObject;

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
    boolean getClickAbove();
    boolean isFull();
    GridInterface copyGrid();
    void addObserver(Observer observer);

    void changeSquare(int index, int playerTurn);

    void reset();

    void newGrid(int row, int col, boolean clickAbove);


    Memento storeInMemento();
    Memento JSONToMemento(JSONObject jsonSave);
    void restoreFromMemento(Memento memento);
    JSONObject mementoToJSON(Memento memento);

}
