package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by desk on 2/9/14.
 */
import Models.*;
import Views.ConfigurationView;
import Views.DialogView;
import Views.MenuView;
import Views.ViewGrid;

import javax.xml.bind.annotation.XmlElementDecl;

public class GameController implements MouseListener, ActionListener{
    /*
    *   Les actions commande pour que le controller
    *   sache  quel radio button est choisi dans la fenetre configuration
    * */
    final String action_AI = "AI";
    final String action_HUMAN = "HUMAN";
    final String action_PLAYER1 = "PLAYER1";
    final String action_PLAYER2 = "PLAYER2";
    final String action_COULISSE= "COULISSE";
    final String action_EXACT = "EXACT";


    final int IN_GAME=3;
    final int HUMAN = 0;
    final int AI    = 1;

   private GameFactory factory;
   //private GridFacadeInterface mGrid;
   private Options mOptions;
   private Game mGame;
   private Puissance4 mFrame;



    private ViewGrid vGrid;
    private MenuView vMenu;
    private ConfigurationView vConf;


    private DialogView vDialog = new DialogView();


    public GameController(){

    }


    /*************************************
    * Getter setter models
    **************************************/
    /*public void addModelGrid(GridFacadeInterface g){
        this.mGrid = g;
    }
    public GridFacadeInterface getModelGrid(){return this.mGrid;}*/

    public void addModelOption(Options options){
       this.mOptions = options ;
    }
    public Options getModelOption(){return this.mOptions;}

    public void addModelGame(Game game){
        this.mGame = game;
    }

    /*************************************
    * Getter setter Views
    **************************************/
    public void addFrame(Puissance4 frame ){
        this.mFrame = frame;
    }
    public Puissance4 getFrame(){return this.mFrame;}

    public void addViewGrid(ViewGrid vGrid){
        this.vGrid = vGrid;
    }
    public ViewGrid getViewGrid(){return this.vGrid;}

    public void addViewMenu(MenuView menuView){
       this.vMenu = menuView;
    }
    public MenuView getViewMenu(){return this.vMenu;}

    public void addViewConfiguration (ConfigurationView vConfiguration){
        this.vConf = vConfiguration;
    }
    public ConfigurationView getViewConfiguration(){return this.vConf;}




    /*TODO
        Creer  le factory et lui passer les options la reference??
        creer la view  -> prendre la reference
        creer la grid  -> ne PAS prendre la reference
        creer la grame -> prendre la reference
    * */
    public void init(){
        factory = new GameFactory(mOptions);
        vGrid = factory.createGrid();
        mGame = factory.createGame();




        mFrame.add(vGrid) ;
        vGrid.addController(this);
        vGrid.updateUI();
    }
    public void reset(){
        mFrame.remove(vGrid);
        vGrid.removeAll();
        vGrid=null;
        mGame=null;


        vGrid = factory.createGrid();
        mGame = factory.createGame();

        mFrame.add(vGrid);
        vGrid.addController(this);
        vGrid.updateUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (e.getActionCommand() == "Démarrer"){


          if(vGrid == null){
              init();
          }
        }else if(e.getActionCommand() == "Arrêter"){

            reset();

        }else if(e.getActionCommand() == "Configurer"){
            syncFromOption();
            vConf.setVisible(true);
        }

        else if(e.getActionCommand() == "Annuler"){

               mGame.Undo();
               vGrid.updateUI();

        }


        else if(e.getActionCommand()== "Ok"){

            syncToOption();
            vConf.setVisible(false);
        }else if ( e.getActionCommand()== "Cancel"){

            vConf.setVisible(false);
        }

    }
    /*
    * Prend les nouvelles configuration et les sauvegarde dans les options
    * */
    public void syncToOption(){

        //Set l'option avec le action_commande du button selectionner dans le buttonGroup
        mOptions.setPlayer1Type(Integer.parseInt(vConf.getSlectedButton(vConf.getGroupP1type())));
        mOptions.setPlayer2Type(Integer.parseInt(vConf.getSlectedButton(vConf.getGroupP2type())));

        mOptions.setStartingPlayer(Integer.parseInt(vConf.getSlectedButton(vConf.getGroupTurn())));

        mOptions.setSizeX(Integer.parseInt(vConf.getRow().getText()));
        mOptions.setSizeY(Integer.parseInt(vConf.getCol().getText()));

        boolean clickAbove = (vConf.getSlectedButton(vConf.getGroupPlacement())==action_COULISSE);
        mOptions.setAllowClickAbove(clickAbove);
//        System.out.println(vConf.getSlectedButton(vConf.getGroupTurn()));
    }


    /*
    * Va chercher les données dans mOptions et synchronise la vue Configuration
    * sur ces données vers vConf
    * */
    public void syncFromOption(){

        // Pour le type du joueur 1 : AI ou Humain
        switch (mOptions.getPlayer1Type()){
            case AI:     vConf.getGroupP1type().setSelected(vConf.getP1Ai().getModel(),true); break;
            case HUMAN : vConf.getGroupP1type().setSelected(vConf.getP1Human().getModel(),true); break;
        }

        // Pour le type du joueur 2 : Ai ou Humain
        switch (mOptions.getPlayer2Type()){
            case AI:     vConf.getGroupP2type().setSelected(vConf.getP2Ai().getModel(),true); break;
            case HUMAN : vConf.getGroupP2type().setSelected(vConf.getP2Human().getModel(),true); break;
        }

        // Pour le joueur qui commence la partie
        switch (mOptions.getStartingPlayer()){
            case 1: vConf.getGroupTurn().setSelected(vConf.getP1Turn().getModel(),true); break;
            case 2: vConf.getGroupTurn().setSelected(vConf.getP2Turn().getModel(),true); break;
        }

        // La taille de la grille
        vConf.getRow().setText(String.valueOf(mOptions.getSizeX()));
        vConf.getCol().setText(String.valueOf(mOptions.getSizeY()));

        // Si on peut clicker au dessu ou doit etre exact
        if(mOptions.isAllowClickAbove()){
            vConf.getGroupPlacement().setSelected(vConf.getCoulisse().getModel(),true);
        }else{
            vConf.getGroupPlacement().setSelected(vConf.getExact().getModel(),true);
        }

    }


    /*
    * Est appeler lorsque l'utilisateur click sur la grille
    * */
    @Override
    public void mousePressed(MouseEvent mouseEvent) {


        Object obj = mouseEvent.getSource();
        for(int i=0;i< vGrid.getNbSquare();i++){
            if(obj == vGrid.getSquareIndex(i)){
                    mGame.play(i);
                    vGrid.updateUI();
                    if(mGame.getGameState() != IN_GAME){

                        if(mGame.getGameState() == 4){
                            String full = "Game full";
                            vDialog.showWin(full);
                        }else{
                            String player = (mGame.getGameState()==0)? "Player rouge":"Player jaune";
                            vDialog.showWin(player);
                        }

                    }

            }
        }
    }



    @Override
    public void mouseClicked(MouseEvent mouseEvent) {}
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {}
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {}
    @Override
    public void mouseExited(MouseEvent mouseEvent) {}


}
