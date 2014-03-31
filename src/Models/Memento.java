package Models;

/**
 * Created by MB on 3/30/14.
 */
public class Memento {


    private Square[] grid;

    public Memento(Square[] gridSave){
        grid = new Square[gridSave.length];
        for(int i=0; i< gridSave.length; i++){
            grid[i] = new Square();
            grid[i].setStatus(gridSave[i].getStatus());
        }

    }
    public Square[] getMementoSave(){return this.grid;}

}
