package Models;

/**
 * Created by desk on 2/9/14.
 */
public class Grid extends java.util.Observable implements GridInterface {

    private int row;
    private int col;
    private Square[] grid;
    private static Grid instance = null;

    public  Grid(int row, int col){
        this.row = row;
        this.col = col;
        create_grid();
        instance = this;
    }

    public static Grid getInstance(){

        return instance;
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

    public boolean checkAvailibility(int index){
        int south = index + this.col;
        boolean check = false;
      //  System.out.print("\nindex = " + index + "  south= " + south);
        if(this.grid[index].getStatus() != 2){
            check = false;
        }
        else if (index > this.grid.length - this.col-1){
            check = true;
        }else if(this.grid[south].getStatus() != 2){
            check = true;
        }else{
            check = false;
        }

        return check;
    }

    public boolean checkWin(int color){
        boolean check = false;
        check = checkHorizontal(color);
        if (!check) check = checkVertical(color);
        if (!check) check = checkDiag(color);

        return check;
    }

    private boolean checkHorizontal(int color){
        boolean check = false;
        int count =0;
        for (int i =grid.length-1 ; i >= 0 && !check; i--){
            if(((i+1) % col) == 0){
                count = 0;
            }
            if(grid[i].getStatus() == color){
                count++;
                check = (count == 4) ? true: false;
            }else{
                count= 0;
            }
        }
        return check;
    }
    private boolean checkVertical(int color){
        boolean check = false;
        int count =0;
        for (int j =0; j < col; j++){
            for (int i =grid.length -j-1 ; i >= 0 && !check; i-=col){
                if(grid[i].getStatus() == color){
                    count++;
                    check = (count >= 4);
                }else{
                    count= 0;
                }
            }
        }
        return check;
    }
    private boolean checkDiag(int color ){
        boolean check = false;
        int count =0;
        int gauche = -1;
        int droite = 1;

        for (int i =grid.length -1 ; i >= 0 && !check; i--){
            if(grid[i].getStatus() == color){
                count = recurs_diag(1,color,i-col+gauche,gauche);
                if (count != 4)
                    count = recurs_diag(1,color,i-col+droite,droite);
                check = count >=4;
            }
        }

        return check;
    }
    private int recurs_diag(int count,int color,int next,int direction){

        int space_border;
        if(count == 4)
            return count;

        if (next <0)
            return 0;
        //                               distance bordure droite    distance bordure gauche
        space_border = (direction <0 ) ? (col - ((next+1) % col)) : (next % (col));
        if(direction > 0){
            System.out.println("space_order: "+space_border + " color: "+color+" next: "+next+" count "+count);
        }
        if (space_border >= count){
               if(this.grid[next].getStatus() == color)
                 return  recurs_diag(count+1, color, next-col+direction, direction) ;
        }

        return count;
    }


}
