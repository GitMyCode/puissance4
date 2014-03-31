package Models;

import java.util.ArrayList;

/**
 * Created by MB on 3/30/14.
 */
public class Caretaker {

    ArrayList<Memento> savedGrids = new ArrayList<Memento>();

    public void addMemento(Memento m ){savedGrids.add(m);}

    public Memento getMemento(int index){return savedGrids.get(index);}

}
