package Models;

/**
 * Created by desk on 2/9/14.
 */
public class Player extends java.util.Observable {

    private PlayerColor player_color;
    private boolean turn; // si c'est a son tour ou non
    private String name;

    public Player(PlayerColor color, String name){
        this.player_color = color;
        this.name = name;
    }




}
