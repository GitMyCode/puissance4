package Controllers;
import Models.*;
import Views.ConfigurationView;
import Views.OptionsView;
import Views.ViewGrid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by desk on 2/9/14.
 */
public class Puissance4 extends JFrame {

    private static Player player1;
    private static Player player2;

    public static void main(String[] args){

        //Cree le model grid
        Grid model_grid = new Grid(6,7);
        //Cree la view sur grid

        JFrame frame = new JFrame("Puissance 4");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

        ViewGrid view_grid = new ViewGrid(6,7);

        OptionsView optionsView = new OptionsView();
        optionsView.setSize(20,10);

        frame.add(optionsView, BorderLayout.SOUTH);
        frame.add(view_grid,BorderLayout.CENTER);

        frame.add(view_grid);



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


        ConfigurationView config = new ConfigurationView();

    }

  }
