package Models;

/**
 * Created by desk on 2/9/14.
 */
public class Grid extends java.util.Observable {

    private int row;
    private int col;
    private Square[] grid;

    public Grid(int row, int col){
        this.row = row;
        this.col = col;
        create_grid();
    }


    private void create_grid(){
        int nb_square = this.row * this.col;
        grid = new Square[nb_square];
        for(int i=0; i< nb_square; i++){
            grid[i] = new Square();
        }
        /*grid = new Square[this.row][this.col];
        for (int i =0; i<row ; i++){
            for(int j=0; j<col; j++){
                grid[i][j] = new Square();
            }
        }
        */
    }
    public void changeSquare(int index){
        this.grid[index].incrementStatus();
        int send[] = new int[2];
        send[0] = index;
        send[1] = this.grid[index].getStatus();
        setChanged();
        notifyObservers(send);
    }

}
