package Views;

/**
 * Created by desk on 2/9/14.
 */

import Models.GLOBAL;

import java.awt.*;
import java.awt.event.MouseListener;
import java.util.Observable;


import javax.swing.*;

public class ViewGrid extends JPanel implements java.util.Observer {


    SquareView[] squares;
    //JPanel panel;


    int nb_square;
    private int row;
    private int col;

    MouseListener controller;

    public ViewGrid(){
        setSize(200, 100);
    }
    public ViewGrid(int row, int col){
        super();
        this.row = row;
        this.col = col;

        this.nb_square = row * col;

        //setSize(400,400);
        //  panel = new JPanel();
        squares = new SquareView[nb_square];

        setLayout(new GridLayout(row,col));

        for(int i =0; i<nb_square;i++){
            squares[i] = new SquareView();
            add(squares[i]);
        }
    }

   @Override
    public void update(Observable observable, Object o) {
        int[][] t = (int[][]) o;

        if(t[1][0] != this.row || t[1][1] != this.col){
            System.out.println(" okey");
            adapteNewGrid(t[1][0],t[1][1]);
        }

        for(int i=0;i<t[0].length;i++){
            Color square_color;
            if(t[0][i] == GLOBAL.RED){
                System.out.println("ici");
                squares[i].setColor(Color.RED);

            }else if(t[0][i] == GLOBAL.YELLOW){

                squares[i].setColor(Color.YELLOW);

            }else{
                squares[i].setColor(Color.WHITE);
            }
        }
   }

    private void adapteNewGrid(int newRow, int newCol){
        this.row = newRow;
        this.col = newCol;
        this.nb_square = newRow*newCol;
        removeAll();
        this.squares = new SquareView[newRow*newCol];

        for(int i =0; i<squares.length;i++){
            squares[i] = new SquareView();
            add(squares[i]);
            squares[i].addMouseListener(controller);
        }

        setLayout(new GridLayout(this.row,this.col));

    }

    public void addController(MouseListener c){
        controller = c;
        for(int i=0;i<nb_square; i++){
            squares[i].addMouseListener(c);
        }
    }
    public JPanel getSquareIndex(int index){
        return this.squares[index];
    }
    public int getNbSquare(){
        return nb_square;
    }
}
