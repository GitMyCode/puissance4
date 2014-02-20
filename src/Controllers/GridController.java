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
    Player[] player = new Player[2];


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


    public void addPlayer(Player p, Player p2){
        this.player[0] = p;
        this.player[1] = p2;

    }

    public void addView(ViewGrid gg){
        this.viewGrid = gg;
    }
    public void init(){

    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        Object obj = mouseEvent.getSource();
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
