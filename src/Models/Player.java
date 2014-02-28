package Models;


import java.util.ArrayList;

import Models.Grid;
/**
 * Created by desk on 2/9/14.
 */
public abstract class Player extends java.util.Observable {


    private int player_color;
    private boolean turn; // si c'est a son tour ou non
    private String name;
    private ArrayList<Jetons> jetons;
    private Grid grid = Grid.getInstance();

    public Player(int color, String name){
        this.player_color = color;
        this.name = name;
    }

    public void play(int index){

    }
    public int getColor(){
        return this.player_color;
    }

    public void setTurn(boolean turn){
        this.turn = turn;
    }

    public boolean getTurn(){
        return this.turn;
    }





}
