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
        System.out.print("check");

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
