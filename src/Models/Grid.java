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

    public void changeSquare(int index,int playerTurn){

        if (checkAvailibility(index)){
            this.grid[index].incrementStatus(playerTurn);
            int send[] = new int[2];
            send[0] = index;
            send[1] = this.grid[index].getStatus();
            setChanged();
            notifyObservers(send);

        }

     }

    private boolean checkAvailibility(int index){
        int south = index + this.col;
        boolean check = false;
        System.out.println("index = "+index +"  south= "+south);
        if (index > this.grid.length - this.col-1){
            check = true;
        }else if(this.grid[south].getStatus() != 2){
            check = true;
        }else{
            check = false;
        }

      //  System.out.println(south + "  "+ this.grid.length + "  " + this.grid[south].getStatus());
/*

        if ((south > this.grid.length - this.col)){
            check = true;
            System.out.println("premier if");
        }else if ( ){
            check = true;
            System.out.println("deuxieme if ");
        }else {
            check = false;
            System.out.println("troisieme if ");
        }
*/


        return check;
    }
}
