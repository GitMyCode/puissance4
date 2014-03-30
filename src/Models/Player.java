package Models;


/**
 * Created by desk on 2/9/14.
 */
public abstract class Player extends java.util.Observable {


    private int player_color;
    private boolean ready;
    private boolean turn;// si c'est a son tour ou non
    private String name;
    private Grid mGrid = Grid.getInstance();

    public Player(int color, String name){
        this.player_color = color;
        this.name = name;
    }

    public void play(int index){
        mGrid.changeSquare(index,player_color);

    }


    public boolean hasWin(){
        return mGrid.checkWin(player_color);
    }
    public boolean isReadyToPlay(){
        return this.ready;
    }

    /*************************************
    * Getter setter
    **************************************/
    public int getColor(){
        return this.player_color;
    }

    public void setReady(boolean ready){
        this.ready = ready;
    }


    public void setTurn(boolean turn){
        this.turn = turn;
    }
    public boolean getTurn(){return this.turn;}





}
