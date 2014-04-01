package Models.Player;

import Models.GridFacadeInterface;
import Models.algorithme.MinMax;

/**
 * Created by MB on 4/1/2014.
 */
public class Normal implements Strategy{
    @Override
    public int move(GridFacadeInterface grid) {
        return MinMax.getMove(grid);
    }
}
