package Models.Commands;

import Models.Game;

/**
 * Created by MB on 4/4/2014.
 */
public class AnnulerCommand implements Commands{


    private Game mGame;

    public AnnulerCommand(Game mGame){
        this.mGame = mGame;
    }

    @Override
    public void executer() {
        mGame.Undo();
    }
}
