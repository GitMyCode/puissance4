package Models;

import Views.ViewGrid;

/**
 * Created by MB on 3/29/14.
 */
public class GameFactory {

    Options mOptions;
    ViewGrid vGrid;

    GridInterface mGrid;
    Game mGame;

    public GameFactory(Options mOptions){
        this.mOptions = mOptions;
    }


    public ViewGrid createGrid(){
        vGrid = new ViewGrid(mOptions.getSizeX(),mOptions.getSizeY());
        mGrid = new Grid(mOptions.getSizeX(),mOptions.getSizeY()) ;

        // Lie l'oberver vGrid avec l'objet mGrid
        mGrid.addObserver(vGrid);

        return vGrid;
    }

    public Game createGame(){
       mGame = new Game(mOptions.getPlayer1Type(),
                        mOptions.getPlayer2Type(),
                        mOptions.getStartingPlayer());

        return mGame;
    }




}
