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
/*
* 0 - player 1 won
* 1 - player 2 won
* 3 - not finish
* */
    int gameState;
    Player player1;
    Player player2;



    public Game(int p1, int p2, int startPlayer, GridFacadeInterface mGrid){

        int playe1Color= (startPlayer ==1)? GLOBAL.RED : GLOBAL.YELLOW;
        int playe2Color= (startPlayer ==2)? GLOBAL.RED : GLOBAL.YELLOW;
        this.gameState = GLOBAL.IN_GAME;
        player1 = (p1 == GLOBAL.AI) ? new Ai(playe1Color) : new Human(playe1Color);
        player2 = (p2 == GLOBAL.AI) ? new Ai(playe2Color) : new Human(playe2Color);

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

            /*
            * N'affect que le Human, cette fonction ne change pas le ready
            * state
            * */
            current.setReady(false);



            if(current.hasWin()){
                setGameState(current.getColor());
                break;
            }else if(current.getIsFull()){
                setGameState(GLOBAL.GAME_FULL);
            }


            changeTurn();
            current = getCurrentPlayer();


        }while(current.isReadyToPlay());


    }

    public void Undo(){

        getCurrentPlayer().Undo();

        changeTurn();
       if(getCurrentPlayer().getClass() == Ai.class){
            changeTurn();
        }
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
