package Models.Commands;

import Models.Facades.GridFacade;
import Models.Facades.GridFacadeInterface;
import Models.Game;
import Models.Options;

/**
 * Created by MB on 4/4/2014.
 */
public class DemarrerCommand implements Commands {


    private Game mGame;
    private GridFacadeInterface mGrid;
    private Options mOptions;

    public DemarrerCommand(Game mGame,GridFacadeInterface mGrid, Options mOptions){
        this.mGame = mGame;
        this.mGrid = mGrid;
        this.mOptions = mOptions;
    }
    @Override
    public void executer() {
        mGrid.reset();
        mGrid.newGrid(mOptions.getSizeX(),mOptions.getSizeY(),mOptions.isAllowClickAbove());

        mGame.newGame(mOptions.getPlayer1Type(),
                      mOptions.getPlayer2Type(),
                      mOptions.getStartingPlayer());



    }
}
