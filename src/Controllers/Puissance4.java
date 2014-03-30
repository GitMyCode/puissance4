package Controllers;
import Models.*;
import Views.MenuView;
import Views.ViewGrid;

import javax.swing.*;
import java.awt.*;

/**
 * Created by desk on 2/9/14.
 */
public class Puissance4  {

    private static Player player1;
    private static Player player2;

    private static Frame frame;

    public Puissance4(){

    }

    public static void main(String[] args){

        frame = new JFrame("Puissance 4");
        frame.setSize(400,400);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //Cree le model mGrid
        Grid model_grid = new Grid(6,7);
        //Cree la view sur mGrid


        ViewGrid view_grid = new ViewGrid(6,7);

        MenuView menuView = new MenuView();
        menuView.setSize(20,10);



        frame.add(menuView, BorderLayout.SOUTH);
        frame.add(view_grid,BorderLayout.CENTER);

        frame.add(view_grid);



        //Le model est observer par la view
        model_grid.addObserver(view_grid);


        //On cree maintenant le controller
        GameController gameController = new GameController();
        gameController.addModelGrid(model_grid); // lui passer le model
        gameController.addView(view_grid);// lui passer la vue
        view_grid.addController(gameController);


        Options options = new Options();
        Game game = new Game(0,"Player1",0,"Player2",1);
        gameController.addModelGame(game);
        gameController.addViewMenu(menuView);
        gameController.addModelOption(options);
        menuView.addController(gameController);


        player1 = new Human(0,"player1");
        player2 = new Ai(1,"player2");


        //TODO   le gameController ne devrais pas avoir les players
        gameController.addPlayers(player1, player2);


        //ConfigurationView config = new ConfigurationView();

    }

}
