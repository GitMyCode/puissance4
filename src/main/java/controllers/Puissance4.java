package controllers;

import Models.Options;
import Views.ConfigurationView;
import Views.MenuView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.*;

/**
 * Created by desk on 2/9/14.
 */
public class Puissance4  extends JFrame{

    final static int AI =1;
    final static int HUMAN =0;


   /*************************************
    * Les Models
    **************************************/
    private Options mOptions;


   /*************************************
    *  Les views
    **************************************/
    private MenuView vMenu;
    private ConfigurationView vConfiguration;


   /*************************************
    *  Le Controller
    **************************************/
   private GameController cGameController;

     private static Frame frame;

    public Puissance4(){

        super("Puissance 4");
        Dimension frame_dimension = new Dimension(450,550);
        setPreferredSize(frame_dimension);
        setMinimumSize(frame_dimension);
        setSize(frame_dimension);

        /*
        * Creer le Controller et le mettre au courant
        * des Options
        * */

        mOptions = new Options();

        ConfigurationView config = new ConfigurationView();
        cGameController = new GameController(mOptions,config,this);


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
        config.addController(cGameController);

        /**
        * Je dois passer la referance du Jframe afin que le cGameController
        * puisse ajouter les views qu'il cree au Jframe
        * */
       // cGameController.addFrame(this);




        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args){
        Puissance4 puissance4 = new Puissance4();


    }

}
