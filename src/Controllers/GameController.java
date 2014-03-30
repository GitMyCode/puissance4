package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by desk on 2/9/14.
 */
import Models.Game;
import Models.GameFactory;
import Models.Grid;
import Models.Options;
import Views.DialogView;
import Views.MenuView;
import Views.ViewGrid;

public class GameController implements MouseListener, ActionListener{


    final int IN_GAME=3;


    GameFactory factory;
    Grid mGrid;
    Options mOptions;
    Game mGame;
    Puissance4 mFrame;



    ViewGrid vGrid;
    MenuView vMenu;


    DialogView vDialog = new DialogView();


    public GameController(){}


    /*************************************
    * Getter setter models
    **************************************/
    public void addModelGrid(Grid g){
        this.mGrid = g;
    }
    public Grid getModelGrid(){return this.mGrid;}

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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(e.getActionCommand() == "Démarrer"){
            System.out.println("ok");
            init();
        }


    }


    @Override
    public void mousePressed(MouseEvent mouseEvent) {


        Object obj = mouseEvent.getSource();
        for(int i=0;i< vGrid.getNbSquare();i++){
            if(obj == vGrid.getSquareIndex(i)){
                System.out.println(i);
                    mGame.play(i);
                    vGrid.updateUI();
                    if(mGame.getGameState() != IN_GAME){

                        String player = (mGame.getGameState()==0)? "Player 1":"Player 2";
                        vDialog.showWin(player);
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
