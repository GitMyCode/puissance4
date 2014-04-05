package Models.Player;

import Models.Facades.GridFacadeInterface;

/**
 * Created by MB on 4/1/2014.
 */
public interface Strategy {
    /*
    * Demande un grid et retourn un index a jouer
    * */
    int move(GridFacadeInterface grid,int playerColor);

}
