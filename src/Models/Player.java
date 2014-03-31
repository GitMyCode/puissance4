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


     private int nbCoup = 0;

    Caretaker caretaker = new Caretaker();
    Originator originator = new Originator();



    public Player(int color){
        this.player_color = color;
        this.name = name;
    }

    /*
    * Retourn False si la case n'est pas valide
    * donc que le jouer n`a pas put faire son coup
    * */
    public boolean play(int index){
        if(mGrid.checkAvailibility(index)){
            mGrid.changeSquare(index,player_color);
            nbCoup++;
            originator.set(mGrid.getGrid());
            caretaker.addMemento(originator.storeInMemento());

            return true;
        }else{
            return false;
        }
    }

    public void Undo(){

        if(nbCoup>0){
            nbCoup--;
            mGrid.setGrid(caretaker.getMemento(nbCoup).getMementoSave());
            mGrid.sendChange();
        }

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
