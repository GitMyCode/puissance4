package Models;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by MB on 3/30/14.
 */
public class Caretaker {

    Stack<Memento> savedGrids = new Stack<Memento>();

    public void addMemento(Memento m ){savedGrids.push(m);}

    public Memento getMemento(){return savedGrids.pop();}

}
