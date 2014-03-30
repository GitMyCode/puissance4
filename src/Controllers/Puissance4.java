package Controllers;
import Models.*;
import Views.ConfigurationView;
import Views.MenuView;
import Views.ViewGrid;

import javax.swing.*;
import java.awt.*;

/**
 * Created by desk on 2/9/14.
 */
public class Puissance4  extends JFrame{

    final static int AI =1;
    final static int HUMAN =0;


   /*************************************
    * Les models
    **************************************/
    private Options mOptions;


   /*************************************
    *  Les views
    **************************************/
    private ViewGrid vGrid;
    private MenuView vMenu;
    private ConfigurationView vConfiguration;


   /*************************************
    *  Le Controller
    **************************************/
   private GameController cGameController;

     private static Frame frame;

    public Puissance4(){

        super("Puissance 4");
        setSize(450,550);

        /*
        * Creer le Controller et le mettre au courant
        * des Options
        * */
        cGameController = new GameController();
        mOptions = new Options();
        cGameController.addModelOption(mOptions);


        /**
        * Creer la view du menu puis connecter le GameController
        * avec celle-ci et l'ajouter le vMenu au JFrame
        * */
        vMenu = new MenuView();
        add(vMenu, BorderLayout.SOUTH);
        cGameController.addViewMenu(vMenu);
        vMenu.addController(cGameController);



        /*
        * Creer la vue pour les configuration et faire la liaison
        * avec le Controller
        * */
        ConfigurationView config = new ConfigurationView();
        cGameController.addViewConfiguration(config);
        config.addController(cGameController);

        /**
        * Je dois passer la referance du Jframe afin que le cGameController
        * puisse ajouter les views qu'il cree au Jframe
        * */
        cGameController.addFrame(this);




        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args){

        Puissance4 puissance4 = new Puissance4();


/*
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


        //TODO Game devrait etre creer par le controller
        Options options = new Options();
        Game game = new Game(0,"Player1",0,"Player2",1);
        gameController.addModelGame(game);



        gameController.addViewMenu(menuView);
        gameController.addModelOption(options);
        menuView.addController(gameController);






*/
    }

}
