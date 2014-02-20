package Views;

/**
 * Created by desk on 2/9/14.
 */

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Observable;


import javax.swing.*;

public class ViewGrid extends JFrame implements java.util.Observer {


    SquareView[] squares;
    JPanel panel;
    int nb_square;
    public ViewGrid(){
        setSize(200, 100);
         }
    public ViewGrid(int row, int col){
       super("Puissance 4!");
        this.nb_square = row * col;

        setSize(400,400);
         panel = new JPanel();
        squares = new SquareView[nb_square];

        panel.setLayout(new GridLayout(row,col));
        for(int i =0; i<nb_square;i++){
            squares[i] = new SquareView();
            panel.add(squares[i]);

        }
        add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void addController(MouseListener c){
        for(int i=0;i<nb_square; i++){
            squares[i].addMouseListener(c);
        }
    }



    @Override
    public void update(Observable observable, Object o) {
        int[] t = (int[]) o;
        System.out.println(t[0]);
        if (t[1] == 0){
            this.squares[t[0]].setColor(Color.RED);
        }else{
            this.squares[t[0]].setColor(Color.YELLOW);
        }


       // this.squares[t[0]].setText(String.valueOf(t[1]));

    }


    public JPanel getSquareIndex(int index){
        return this.squares[index];
    }
    public int getNbSquare(){
        return nb_square;
    }
}
