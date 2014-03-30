package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by desk on 2/9/14.
 */
import Models.Game;
import Models.Grid;
import Models.Options;
import Models.Player;  // Je ne penses pas que ca devrais etre la
import Views.DialogView;
import Views.MenuView;
import Views.ViewGrid;

public class GameController implements MouseListener, ActionListener{


    final int IN_GAME=3;


    Grid mGrid;
    Options mOptions;
    Game mGame;



    ViewGrid vGrid;
    MenuView vMenu;

    Player player1;
    Player player2;

    DialogView vDialog = new DialogView();


    public GameController(){}


    /*************************************
    * Getter setter models
    **************************************/
    public void addModelGrid(Grid g){
        this.mGrid = g;
    }
    public Grid getModelGrid(){return this.mGrid;}

    public void addModelOption(Options options){
       this.mOptions = options ;
    }
    public Options getModelOption(){return this.mOptions;}

    public void addModelGame(Game game){
        this.mGame = game;
    }

    /*************************************
    * Getter setter Views
    **************************************/
    public void addViewGrid(ViewGrid vGrid){
        this.vGrid = vGrid;
    }
    public ViewGrid getViewGrid(){return this.vGrid;}

    public void addViewMenu(MenuView menuView){
       this.vMenu = menuView;
    }
    public MenuView getViewMenu(){return this.vMenu;}



    public void addModel(Grid g){
        this.mGrid = g;
    }


    public void addPlayers(Player p1, Player p2){
        this.player1 = p1;
        this.player2 = p2;
    }



    public void addView(ViewGrid gg){
        this.vGrid = gg;
    }
    public void init(){

    }

    private void changeTurn(){
        player1.setReady(!player1.getTurn());
        player2.setReady(!player2.getTurn());
    }

    private Player getCurrentPlayer(){

        return player1.getTurn() ? player1 : player2;
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {


        Object obj = mouseEvent.getSource();
        for(int i=0;i< vGrid.getNbSquare();i++){
            if(obj == vGrid.getSquareIndex(i)){

                if(mGrid.checkAvailibility(i)){

                    mGame.play(i);
                    if(mGame.getGameState() != IN_GAME){

                        String player = (mGame.getGameState()==0)? "Player 1":"Player 2";
                        vDialog.showWin(player);
                    }
                    /*Player current = getCurrentPlayer();

                    mGrid.changeSquare(i,current.getColor());
                    if(mGrid.checkWin(current.getColor())){
                        System.out.println("WIN :"+current.getColor());
                        String player = (current.getColor() == 1)? "Player 1":"Player 2";
                       // vDialog.setMessage(player);
                        vDialog.showWin(player);
                    }


                    changeTurn();
                    */
                    /*
                    while(currentPlayer.isReady() and !currenyPlayer.hasWin()){

                        validMove = currentPlayer.play(index)
                        if(currentPlayer.hasWin()){
                            break;
                        }
                        if (validMove){
                            currentPlayer = switch()
                        }
                        */
                    }
                }
            }
        }



    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(e.getActionCommand() == "Démarrer"){
            System.out.println("ok");
        }


    }
}
