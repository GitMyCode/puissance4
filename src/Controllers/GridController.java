package Controllers;

import java.awt.event.ActionEvent;

/**
 * Created by desk on 2/9/14.
 */
import Models.Grid;
import Views.ViewGrid;

public class GridController implements java.awt.event.ActionListener{


    Grid grid;
    ViewGrid viewGrid;

    public GridController(){}

    @Override
    public void actionPerformed(ActionEvent e) {

        Object obj = e.getSource();
        for(int i=0;i< viewGrid.getNbSquare();i++){
            if(obj == viewGrid.getSquareIndex(i)){

                grid.changeSquare(i);

            }
        }


    }

    public void addModel(Grid g){
        this.grid = g;
    }


    public void addView(ViewGrid gg){
        this.viewGrid = gg;
    }
    public void init(){

    }
}
