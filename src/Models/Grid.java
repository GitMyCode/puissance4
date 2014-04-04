package Models;

import Models.GLOBAL;
/**
 * Created by desk on 2/9/14.
 */
public class Grid extends java.util.Observable implements GridInterface {

    final int RED = 0;
    final int YELLOW = 1;
    final int WIN = 4;

    private int row;
    private int col;
    private boolean clickAbove;

    private Square[] grid;

    private  int[] resultat = new int[4];

    public  Grid(int row, int col,boolean clickAbove){
        this.row = row;
        this.col = col;
        this.clickAbove = clickAbove;
        create_grid();
    }

    public Grid copyGrid(){
        Grid copiedGrid = new Grid(this.row, this.col, false); // le MinMax n'utilise pas coulisse

        Square[] copiedSquares = new Square[this.grid.length];
        for(int i=0; i< this.grid.length; i++){
            copiedSquares[i] = new Square();
            copiedSquares[i].setStatus(this.grid[i].getStatus());
        }
        copiedGrid.setGrid(copiedSquares);
        return copiedGrid;



    }

    void setGrid(Square[] squares){
        this.grid = squares;
    }

    private void create_grid(){
        int nb_square = this.row * this.col;
        grid = new Square[nb_square];
        for(int i=0; i< nb_square; i++){
            grid[i] = new Square();
        }
    }

    public void changeSquare(int index,int playerTurn){
        int south = index + this.col;
        if (checkAvailibility(index)){
            if(clickAbove){

                System.out.println("ici");

                if ( index < this.grid.length - this.col-1){ // Si pas la premiere rangé
                    while(isInGrid(south) && grid[south].getStatus()==GLOBAL.FREE){// boulce jusqu'a derniere espace libre
                        index = south;
                        south = index + this.col;
                        System.out.println(" south" +south);
                    }
                }

            }

            this.grid[index].incrementStatus(playerTurn);
            sendChange();
        }
    }

    public void sendChange(){
        int send[] = new int[this.grid.length];
        for(int i=0;i<this.grid.length;i++){
            send[i] = this.grid[i].getStatus();
        }
        setChanged();
        notifyObservers(send);

    }

    public boolean checkAvailibility(int index){
        int south = index + this.col;
        boolean check = false;


        if(this.grid[index].getStatus() != GLOBAL.FREE){ //check si case disponible
            return false;

        }else if(!this.clickAbove){//Si on ne peut pas clicker au dessus
            if (index > this.grid.length - this.col-1){ // Si premiere ranger
                return  true;
            }else if(this.grid[south].getStatus() != GLOBAL.FREE ){ // Si la case d'en dessou est occupé
                return true;
            }else{
                return false;
            }


        }
        return true;
    }

    public boolean isFull(){
        for(int i=0;i<grid.length; i++){
            if(grid[i].getStatus()== GLOBAL.FREE)
                return false;
        }
        return true;
    }

    public boolean checkWin(int color){
        boolean check = false;
        check = checkHorizontal(color);
        if (!check) check = checkVertical(color);
        if (!check) check = checkDiag(color);

        return check;
    }





    /**********************************************
    *
     * PRIVATE METHODE
    *
    ************************************************/

    /*
    *Check if a index is in the grid;
    * */
    private boolean isInGrid(int index){
        return (index >0 && index < grid.length);
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
                check = (count == WIN) ? true: false;
            }else{
                count= 0;
            }
        }
        if(check)
            System.out.println("Horizontal");
        return check;
    }
    private boolean checkVertical(int color){
        boolean check = false;
        for (int j =0; j < col; j++){
            int count =0;
            for (int i =grid.length -j-1 ; i >= 0 && !check; i-=col){
                if(grid[i].getStatus() == color){
                    resultat[count]= i;
                    count++;
                    check = (count >= WIN);
                }else{
                    count= 0;
                }
            }
        }
        if(check){
            System.out.println("Vertical");
            for(int i=0;i<4;i++){
                System.out.print(resultat[i] + " ");
            }
            System.out.println();
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
                if (count != WIN)
                    count = recurs_diag(1,color,i-col+droite,droite);
                check = count >=WIN;
            }
        }

        if(check){
            System.out.println("diagonal");
            for(int i=0;i<4;i++){
                System.out.print(resultat[i]+ " ");
            }
            System.out.println();
            System.out.println();
        }


        return check;
    }
    private int recurs_diag(int count,int color,int next,int direction){

        int space_border;
        if(count == WIN){
            resultat[count-1] = next;
            return count;
        }

        if (next <0)
            return 0;
        //                               distance bordure droite    distance bordure gauche
        space_border = (direction <0 ) ? (col - ((next+1) % col)) : (next % (col));
        if(direction > 0){
            //System.out.println("space_order: "+space_border + " color: "+color+" next: "+next+" count "+count);
        }
        if (space_border >= count){
               if(this.grid[next].getStatus() == color){
                   resultat[count-1] = next;
                   return  recurs_diag(count+1, color, next-col+direction, direction) ;
               }
        }

        return count;
    }


    public int getLenght(){
        return this.row * this.col;
    }
    public int getCol(){return this.col;}
    public int getRow(){return this.row;}

    public Memento storeInMemento(){
        return new Memento(grid);
    }

    public void restoreFromMemento(Memento memento){
        grid = memento.getMementoSave();
    }

}
