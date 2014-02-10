package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by desk on 2/9/14.
 */
import Models.Grid;
import Views.GameGrid;
public class GridController implements java.awt.event.ActionListener{


    Grid grid;
    GameGrid gameGrid;

    public GridController(){}

    @Override
    public void actionPerformed(ActionEvent e) {

        Object obj = e.getSource();
        for(int i=0;i<gameGrid.getNbSquare();i++){
            if(obj == gameGrid.getSquareIndex(i)){

                grid.changeSquare(i);

            }
        }


    }

    public void addModel(Grid g){
        this.grid = g;
    }


    public void addView(GameGrid gg){
        this.gameGrid = gg;
    }
    public void init(){

    }
}
