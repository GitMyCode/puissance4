/**
 * Created by desk on 2/9/14.
 */
public class Grid {

    private int row;
    private int col;
    private Square[][] grid;

    public Grid(int row, int col){
        this.row = row;
        this.col = col;
    }


    private void create_grid(){
        for (int i =0; i<row ; i++){
            for(int j=0; j<col; j++){
                grid[i][j] = new Square();
            }
        }
    }

}
