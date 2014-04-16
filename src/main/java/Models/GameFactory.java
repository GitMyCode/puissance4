package Models;

import Models.Facades.GridFacade;
import Models.Facades.GridFacadeInterface;
import Views.ViewGrid;

/**
 * Created by MB on 3/29/14.
 */
public class GameFactory {

    Options mOptions;
    ViewGrid vGrid;

    GridFacadeInterface mGrid;
    Game mGame;

    public GameFactory(Options mOptions){
        this.mOptions = mOptions;
    }


    public ViewGrid createViewGrid(){
        vGrid = new ViewGrid(mOptions.getSizeX(),mOptions.getSizeY());


       // mGrid = new GridFacade(mOptions.getSizeX(),mOptions.getSizeY(), mOptions.isAllowClickAbove()) ;

        // Lie l'oberver vGrid avec l'objet mGrid
        // mGrid.addObserver(vGrid);
        return vGrid;
    }

    public GridFacadeInterface createModelGrid(){

        mGrid = new GridFacade(mOptions.getSizeX(),mOptions.getSizeY(), mOptions.isAllowClickAbove()) ;

        return mGrid;
    }

    public Game createGame(){
       mGame = new Game(mOptions.getPlayer1Type(),
                        mOptions.getPlayer2Type(),
                        mOptions.getStartingPlayer(),mGrid);

        return mGame;
    }




}
