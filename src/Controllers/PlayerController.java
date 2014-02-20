package Controllers;

import Models.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by mb on 2/19/14.
 */
public class PlayerController  {



    Player player1;
    Player player2;


    public PlayerController(){

    }

    public void play(){

        Player current = getCurrentPlayer();





    }

    public void setPlayers(Player p1, Player p2){
        this.player1 = p1;
        this.player2 = p2;
    }


    private void changeTurn(){
       player1.setTurn( !player1.getTurn());
       player2.setTurn( !player2.getTurn());
    }

    private Player getCurrentPlayer(){

        return player1.getTurn() ? player1 : player2;
    }

}
