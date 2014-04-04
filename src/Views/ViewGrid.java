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

    public void addController(MouseListener c){
        for(int i=0;i<nb_square; i++){
            squares[i].addMouseListener(c);
        }
    }
    @Override
    public void update(Observable observable, Object o) {
        int[] t = (int[]) o;





        for(int i=0;i<t.length;i++){
            Color square_color;
            if(t[i] == GLOBAL.RED){
                System.out.println("ici");
                squares[i].setColor(Color.RED);

            }else if(t[i] == GLOBAL.YELLOW){

                squares[i].setColor(Color.YELLOW);

            }else{
                squares[i].setColor(Color.WHITE);
            }

        }


    }


    public JPanel getSquareIndex(int index){
        return this.squares[index];
    }
    public int getNbSquare(){
        return nb_square;
    }
}
