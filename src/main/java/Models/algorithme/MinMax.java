package Models.algorithme;

import Models.Facades.GridFacadeInterface;
import Models.GLOBAL;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MB on 3/30/14.
 */


public class MinMax {



    static int current_player;
    static int opponent;

    public static int getMove(GridFacadeInterface grid,int playerColor){

        /* Si le joueur est rouge alors son opposent est Jaune*/
        opponent = (playerColor == GLOBAL.RED)? GLOBAL.YELLOW : GLOBAL.RED;
        current_player = playerColor;

        int[] play = minmax(grid,5, current_player,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return play[0];
    }

    public static int[] minmax(GridFacadeInterface grid, int depth,int player,int alpha,int beta) {//



        int score= (evaluer(grid, player));
        if(score != 0 || grid.isFull() || depth == 0){
            // System.out.print("-------------" +
            //       "\n" + score);
            // grid1.show();
            int test =0;
            test = (score >0) ? depth : (test -depth);
            return new int[] {0,score + test} ;
        }


        List<Integer> nextMove = getPossibleMoves(grid);
        int bestScore;
        int currentScore;
        int bestMove =0;
        /*if(nextMove.isEmpty() || depth == 0){
            bestScore = evaluer(grid1);
            return  new int[] {bestMove,bestScore};
        }*/
        for(int move : nextMove){
            GridFacadeInterface newGrid = grid.copyGridFacade();
            newGrid.changeSquare(move,player);
            if(player == current_player ){
                currentScore = minmax(newGrid,depth-1, opponent, alpha,beta)[1];
                if(currentScore > alpha){
                    alpha = currentScore;
                    bestMove = move;

                    for(int i=0;i<depth;i++){
                        //System.out.print("  ");
                    }
                    //System.out.println("                      GLOBAL.AI:"+ move);
                }
            }else {
                currentScore = minmax(newGrid,depth-1,current_player,alpha,beta)[1];
                if(currentScore < beta){
                    beta = currentScore;
                    bestMove = move;
                    for(int i=0;i<depth;i++){
                        //System.out.print("  ");
                    }
                    //System.out.println("                      P:"+ move);
                }

            }
            // reset la case?
        }


        return new int[] {bestMove, ((player == current_player)? alpha: beta)};

    }

    private static List<Integer> getPossibleMoves(GridFacadeInterface grid){
        List<Integer> posMoves = new ArrayList<Integer>();
        for(int i=0 ; i<grid.getLenght(); i++){
            if(grid.checkAvailibility(i)){
                posMoves.add(i);
            }
        }
        return posMoves;
    }

    private static int evaluer(GridFacadeInterface grid,int turn){
        if(grid.checkWin(turn)){
            if(turn== opponent){
                return -10;
            }else{
                return 10;
            }
        }
        return 0;
    }
}
