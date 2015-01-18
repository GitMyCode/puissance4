package Models.Commands;

import Models.Facades.GridFacadeInterface;
import Models.Game;

/**
 * Created by MB on 4/4/2014.
 */
public class ArreterCommand implements Commands {

    Game mGame;
    GridFacadeInterface mGrid;

    public ArreterCommand(Game mGame, GridFacadeInterface mGrid){
        this.mGame = mGame;
        this.mGrid = mGrid;
    }


    @Override
    public void executer() {
        mGame.reset();
        mGrid.reset();
    }
}
