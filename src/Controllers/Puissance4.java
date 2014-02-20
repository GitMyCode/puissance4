package Controllers;
import Models.*;
import Views.ViewGrid;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by desk on 2/9/14.
 */
public class Puissance4 implements Runnable {

    private static Player player1;
    private static Player player2;

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

        PlayerColor jaune = new PlayerColor(1);
        PlayerColor rouge = new PlayerColor(0);
         player1 = new Human(0,"player1");
         player2 = new Ai(1,"player2");

        gridController.addPlayers(player1, player2);

 






    }

    @Override
    public void run() {
        while(true){
            player1.play();
            try{
                player1.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            player2.play();
            try{
                player2.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }

    }
}
