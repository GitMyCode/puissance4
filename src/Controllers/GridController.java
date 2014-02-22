package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by desk on 2/9/14.
 */
import Models.Grid;
import Models.Player;  // Je ne penses pas que ca devrais etre la
import Views.ViewGrid;

public class GridController implements MouseListener{


    Grid grid;
    ViewGrid viewGrid;

    Player player1;
    Player player2;


    public GridController(){}

   /* @Override
    public void actionPerformed(ActionEvent e) {

        Object obj = e.getSource();
        for(int i=0;i< viewGrid.getNbSquare();i++){
            if(obj == viewGrid.getSquareIndex(i)){
                int joueurTurn = 0;
                if (player[0].getTurn()){
                    joueurTurn =0;
                }else{
                    joueurTurn = 1;
                }

                grid.changeSquare(i,joueurTurn);

                player[joueurTurn].setTurn(false);
                if(joueurTurn == 1){
                    player[0].setTurn(true);
                }else{
                    player[1].setTurn(true);
                }


            }
        }


    }*/

    public void addModel(Grid g){
        this.grid = g;
    }


    public void addPlayers(Player p1, Player p2){
        this.player1 = p1;
        this.player2 = p2;
    }



    public void addView(ViewGrid gg){
        this.viewGrid = gg;
    }
    public void init(){

    }

    private void changeTurn(){
        player1.setTurn( !player1.getTurn());
        player2.setTurn( !player2.getTurn());
    }

    private Player getCurrentPlayer(){

        return player1.getTurn() ? player1 : player2;
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        Object obj = mouseEvent.getSource();
        for(int i=0;i< viewGrid.getNbSquare();i++){
            if(obj == viewGrid.getSquareIndex(i)){

                if(grid.checkAvailibility(i)){
                    Player current = getCurrentPlayer();
                    grid.changeSquare(i,current.getColor());
                    if(grid.checkWin(current.getColor())){
                        System.out.println("WIN");
                        //System.exit(0);
                    }

                    changeTurn();
                }
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
