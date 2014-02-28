package Models;

/**
 * Created by desk on 2/23/14.
 */
public class Game {



    Player player1;
    Player player2;


    public Game(String p1,String p1_name, String p2,String p2_name){
        player1 = (p1 == "Ai") ? new Ai(1,p1_name) : new Human(1,p1_name);
        player2 = (p2 == "Ai") ? new Ai(1,p2_name) : new Human(1,p2_name);
    }


    public void playGame(){

        while(getCurrentPlayer().getTurn()){


        }


    }

    private Player getCurrentPlayer(){
        return player1.getTurn() ? player1 : player2;
    }
}
