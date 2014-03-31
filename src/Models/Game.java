package Models;

import Models.Player.Ai;
import Models.Player.Human;
import Models.Player.Player;

/**
 * Created by desk on 2/23/14.
 */
public class Game {

    final int PLAYER_1=0;
    final int PLAYER_2=1;
    final int IN_GAME=3;
/*
* 0 - player 1 won
* 1 - player 2 won
* 3 - not finish
* */
    int gameState;
    Player player1;
    Player player2;



    public Game(int p1, int p2, int startPlayer, GridFacadeInterface mGrid){

        int playe1Color= (startPlayer ==1)? 0 : 1;
        int playe2Color= (startPlayer ==2)? 0 : 1;
        this.gameState = IN_GAME;
        player1 = (p1 == 1) ? new Ai(playe1Color) : new Human(playe1Color);
        player2 = (p2 == 1) ? new Ai(playe2Color) : new Human(playe2Color);

        if(startPlayer==1){
            player1.setTurn(true);
            player2.setTurn(false);
        }else{
            player1.setTurn(false);
            player2.setTurn(true);
        }
        player1.setGrid(mGrid);
        player2.setGrid(mGrid);


        // Un check pour savoir si le Ai doit jouer en premier
        if(getCurrentPlayer().getClass() == Ai.class){
            System.out.println("Ai premier");
            getCurrentPlayer().play(38); // l'index donner au AI n'a pas d'importance il ne s'en sert pas
            changeTurn();
        }
    }


    public void play(int index){
        Player current = getCurrentPlayer();
        do{
            //Si le coup est invalide( case deja occupe)
            // le coup est annuler et on sort de la boucle
            if(!current.play(index)){
                break;
            }
            current.setReady(false);
            if(current.hasWin()){
                setGameState(current.getColor());
                break;
            }
            changeTurn();
            current = getCurrentPlayer();
        }while(current.isReadyToPlay());


    }

    public void Undo(){

        getCurrentPlayer().Undo();
       if(getCurrentPlayer().getClass() == Ai.class){
            changeTurn();
        }
        changeTurn();
    }


    private Player getCurrentPlayer(){
        return player1.getTurn() ? player1 : player2;
    }

    private void changeTurn(){
        player1.setTurn(!player1.getTurn());
        player2.setTurn(!player2.getTurn());

    }

    public void setGameState(int gameState){
        this.gameState = gameState;
    }
    public int getGameState(){return this.gameState;}
}
