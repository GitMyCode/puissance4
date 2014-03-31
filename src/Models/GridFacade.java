package Models;

import java.util.Observer;

/**
 * Created by desk on 2/9/14.
 */
public class GridFacade implements GridFacadeInterface {
    Caretaker caretaker;
    GridInterface grid;

    public GridFacade(GridInterface grid) {
        this.grid = grid;
        this.caretaker = new Caretaker();
    }

    public GridFacade(int row, int col) {
        this.grid = new Grid(row, col);
        this.caretaker = new Caretaker();
    }

    @Override
    public void reset() {
        Memento memento = caretaker.initialStateMemento();
        this.grid.restoreFromMemento(memento);
    }

    @Override
    public void saveState() {
        Memento memento = this.grid.storeInMemento();
        this.caretaker.addMemento(memento);
    }

    @Override
    public void loadPreviousState() {
        Memento memento = this.caretaker.getMemento();
        this.grid.restoreFromMemento(memento);
    }

    @Override
    public boolean existsPreviousState() {
        return this.caretaker.existPreviousMemento();
    }

    @Override
    public void addObserver(Observer observer) {
        grid.addObserver(observer);
    }

    @Override
    public boolean checkWin(int color) {
        return false;
    }

    @Override
    public boolean checkAvailibility(int index) {
        return this.grid.checkAvailibility(index);
    }

    @Override
    public void changeSquare(int index, int playerTurn) {
        this.grid.changeSquare(index, playerTurn);
    }

    @Override
    public void sendChange() {
        this.grid.sendChange();
    }

    @Override
    public int getLenght() {
        return this.grid.getLenght();
    }

    @Override
    public int getCol() {
        return this.grid.getCol();
    }

    @Override
    public int getRow() {
        return this.grid.getRow();
    }

    @Override
    public boolean isFull() {
        return this.grid.isFull();
    }

    @Override
    public GridFacadeInterface copyGridFacade() {
        GridInterface copiedGrid = this.grid.copyGrid();
        GridFacadeInterface copiedFacade = new GridFacade(copiedGrid);
        return copiedFacade;
    }


}
