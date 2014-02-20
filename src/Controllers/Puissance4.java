package Controllers;
import Models.Grid;
import Views.ViewGrid;

import java.awt.event.ActionEvent;

/**
 * Created by desk on 2/9/14.
 */
public class Puissance4  implements java.awt.event.ActionListener {

    public static void main(String[] args){
        System.out.print("yo");

        //Cree le model grid
        Grid model_grid = new Grid(6,7);
        //Cree la view sur grid
        ViewGrid view_grid = new ViewGrid(6,7);

          //Le model est observer par la view
        model_grid.addObserver(view_grid);


        //On cree maintenant le controller
        GridController gridController = new GridController();
        gridController.addModel(model_grid); // lui passer le model
        gridController.addView(view_grid);// lui passer la vue

        view_grid.addController(gridController);



    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.print("action dans Puissance4");
    }
}
