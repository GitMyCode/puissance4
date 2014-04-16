package Models.Player;

import Models.Facades.GridFacadeInterface;
import Models.algorithme.MinMax;

/**
 * Created by MB on 4/1/2014.
 */
public class Normal implements Strategy {
    @Override
    public int move(GridFacadeInterface grid,int playerColor) {
        return MinMax.getMove(grid, playerColor);
    }
}
