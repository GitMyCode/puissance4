package Models;

/**
 * Created by MB on 3/30/14.
 */
public class Originator {

    private Square[] grid;

    public void set(Square[] newGrid){
        this.grid = newGrid;
    }

    public Memento storeInMemento(){
        return new Memento(grid);
    }

    public Square[] restoreFromMemento(Memento memento){
        grid = memento.getMementoSave();
        return grid;
    }
}

