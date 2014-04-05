package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by desk on 2/9/14.
 */
import Models.*;
import Models.Commands.*;
import Models.Facades.GridFacadeInterface;
import Views.ConfigurationView;
import Views.DialogView;
import Views.MenuView;
import Views.ViewGrid;

public class GameController implements MouseListener, ActionListener{


   private GameFactory factory;
   private GridFacadeInterface mGrid;
   private Options mOptions;
   private Game mGame;
   private Puissance4 mFrame;


    private MenuInvoker menuInvoker;

    private ViewGrid vGrid;
    private MenuView vMenu;
    private ConfigurationView vConf;


    private DialogView vDialog = new DialogView();


    public GameController(Options mOptions,ConfigurationView vConf, Puissance4 mFrame){
        this.mOptions = mOptions;
        this.mFrame   = mFrame;
        this.vConf =    vConf;
        init();

    }

    private void init(){
        factory = new GameFactory(mOptions);
        vGrid = factory.createViewGrid();
        mGrid = factory.createModelGrid();

        /*Liaison du pattron Observer entre mGrid et vGrid*/
        mGrid.addObserver(vGrid);



        mFrame.add(vGrid) ;
        vGrid.addController(this);
        vGrid.updateUI();



        mGame = factory.createGame();


        initMenuInvoker();

    }

    private void initMenuInvoker(){
        Commands configurer  = new ConfigurerCommand(mOptions,vConf);

        Commands demarrer = new DemarrerCommand(mGame,mGrid,mOptions);

        Commands arreter = new ArreterCommand(mGame,mGrid);

        Commands annuler = new AnnulerCommand(mGame);

        Commands ok = new AccepterConfigCommand(mOptions,vConf );

        Commands cancel = new AnnulerConfigCommand(vConf);



        menuInvoker = new MenuInvoker();
        menuInvoker.setConfigurerCommand(configurer);
        menuInvoker.setAnnulerCommand(annuler);
        menuInvoker.setArreterCommand(arreter);
        menuInvoker.setDemarrerCommand(demarrer);
        menuInvoker.setAccepterConfigCommand(ok);
        menuInvoker.setAnnulerConfigCommand(cancel);
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


    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (e.getActionCommand() == "Démarrer"){


            menuInvoker.demarrer();
            vGrid.updateUI();
       }else if(e.getActionCommand() == "Arrêter"){

            menuInvoker.arreter();

        }else if(e.getActionCommand() == "Configurer"){


            menuInvoker.configurer();
        }

        else if(e.getActionCommand() == "Annuler"){

            menuInvoker.annuler();
        }

        else if(e.getActionCommand()== "Ok"){

            menuInvoker.accepterConfig();

        }else if ( e.getActionCommand()== "Cancel"){

            menuInvoker.annulerConfig();
        }

    }

    /*
    * Est appeler lorsque l'utilisateur click sur la grille
    * */
    @Override
    public void mousePressed(MouseEvent mouseEvent) {


        System.out.println(" event");
        Object obj = mouseEvent.getSource();
        for(int i=0;i< vGrid.getNbSquare();i++){
            if(obj == vGrid.getSquareIndex(i)){

                    mGame.play(i);

                    if(mGame.getGameState() != GLOBAL.IN_GAME){

                        if(mGame.getGameState() == GLOBAL.GAME_FULL){
                            String full = "Game full";
                            vDialog.showWin(full);
                        }else{
                            String player = (mGame.getGameState()==GLOBAL.RED)? "Player rouge":"Player jaune";
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
