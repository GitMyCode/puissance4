package Models;

/**
 * Created by desk on 2/9/14.
 */
public class Grid extends java.util.Observable {

    private int row;
    private int col;
    private Square[][] grid;

    public Grid(int row, int col){
        this.row = row;
        this.col = col;
        create_grid();
    }


    private void create_grid(){
        grid = new Square[this.row][this.col];
        for (int i =0; i<row ; i++){
            for(int j=0; j<col; j++){
                grid[i][j] = new Square();
            }
        }
    }

}
