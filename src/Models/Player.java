package Models;


import java.util.ArrayList;

/**
 * Created by desk on 2/9/14.
 */
public class Player extends java.util.Observable {

    private PlayerColor player_color;
    private boolean turn; // si c'est a son tour ou non
    private String name;
    private ArrayList<Jetons> jetons;

    public Player(PlayerColor color, String name){
        this.player_color = color;
        this.name = name;
    }

    public void play(){
        this.turn = true;
        System.out.println(this.name);



        notify();
        this.turn= false;
    }

    public void setTurn(boolean turn){
        this.turn = turn;
    }

    public boolean getTurn(){
        return this.turn;
    }




}
