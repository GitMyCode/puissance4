package Models.algorithme;
import Models.Grid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MB on 3/30/14.
 */


public class MinMax {


final static  int HUMAN = 0;
final static  int AI    = 1;


    public static int getMove(Grid grid){

        int[] play = minmax(grid,5,AI,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return play[0];
    }

    public static int[] minmax(Grid grid, int depth,int player,int alpha,int beta) {//



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
                Grid newGrid = new Grid(grid);
                newGrid.changeSquare(move,player);
                if(player == AI){
                    currentScore = minmax(newGrid,depth-1,HUMAN, alpha,beta)[1];
                    if(currentScore > alpha){
                        alpha = currentScore;
                        bestMove = move;

                        for(int i=0;i<depth;i++){
                            //System.out.print("  ");
                        }
                        //System.out.println("                      AI:"+ move);
                    }
                }else {
                    currentScore = minmax(newGrid,depth-1,AI,alpha,beta)[1];
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


        return new int[] {bestMove, ((player == AI)? alpha: beta)};

    }

    private static List<Integer> getPossibleMoves(Grid grid){
        List<Integer> posMoves = new ArrayList<Integer>();
        for(int i=0 ; i<grid.getLenght(); i++){
            if(grid.checkAvailibility(i)){
                posMoves.add(i);
            }
        }
        return posMoves;
    }

    private static int evaluer(Grid grid,int turn){
        if(grid.checkWin(turn)){
            if(turn==HUMAN){
                return -10;
            }else{
                return 10;
            }
        }
        return 0;
    }
}
