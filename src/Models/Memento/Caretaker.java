package Models.Memento;

import java.util.Stack;

/**
 * Created by MB on 3/30/14.
 */
public class Caretaker {

    Stack<Memento> savedGrids = new Stack<Memento>();

    public void addMemento(Memento m ){savedGrids.push(m);}
    public Memento initialStateMemento(){
        Memento memento = null;
        while(!savedGrids.empty()){
            memento = savedGrids.pop();
        }
        return memento;
    }

    public Memento getMemento(){return savedGrids.pop();}
    public boolean existPreviousMemento(){return !savedGrids.empty();}

}
