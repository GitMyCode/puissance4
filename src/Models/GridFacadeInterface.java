package Models;

/**
 * Created by mb on 2/23/14.
 */
public interface GridFacadeInterface {


    void reset();
    void saveState();
    void loadPreviousState();
    boolean existsPreviousState();

    boolean checkWin(int color);
    boolean checkAvailibility(int index);
    void sendChange();
    int getLenght();
    int getCol();
    int getRow();
    boolean isFull();
    GridFacadeInterface copyGridFacade();

}
