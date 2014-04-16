package Models.Facades;

import Models.Grid;
import Models.Memento.Caretaker;
import Models.Memento.Memento;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.util.Iterator;
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

    public GridFacade(int row, int col, boolean clickAbove) {
        this.grid = new Grid(row, col, clickAbove);
        this.caretaker = new Caretaker();
    }

    @Override
    public void reset() {
        if(existsPreviousState()){
            Memento memento = caretaker.initialStateMemento();
            this.grid.restoreFromMemento(memento);

        }

        /*
        * Apres avoir vider le memento on vite la grid aussi
        * */
        this.grid.reset();
    }

    @Override
    public void newGrid(int row, int col, boolean clickAbove) {
        this.caretaker = new Caretaker();
        this.grid.newGrid(row,col,clickAbove);
    }

    @Override
    public void restoreFromJSONObject(JSONObject jsonObject) {
        this.caretaker = new Caretaker();

        int row = Integer.parseInt((String) jsonObject.get("rows"));
        int col = Integer.parseInt((String) jsonObject.get("cols"));
        //TODO
        boolean clickAbove = true;

        this.grid.newGrid(row,col,clickAbove);

        // loop array
        JSONArray jsonMementos = (JSONArray) jsonObject.get("mementos");
        Iterator<JSONObject> iterator = jsonMementos.iterator();
        while (iterator.hasNext()) {
            Memento memento = this.grid.JSONToMemento(iterator.next());
            caretaker.addMemento(memento);
        }
        loadPreviousState();

    }

    @Override
    public JSONObject saveToJSON(JSONObject jsonSave){
        this.saveState();
        jsonSave.put("rows", this.grid.getRow());
        jsonSave.put("cols", this.grid.getCol());
        jsonSave.put("clickAbove", this.grid.getClickAbove());

        JSONArray mementoList = new JSONArray();


        Iterator<Memento> mementoIterator = this.caretaker.getIterator();
        while(mementoIterator.hasNext()){
            Memento memento = mementoIterator.next();
            JSONObject mementoSave = grid.mementoToJSON(memento);

            mementoList.add(mementoSave);
        }


        jsonSave.put("mementos", mementoList);
        return jsonSave;
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
        return grid.checkWin(color);
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
