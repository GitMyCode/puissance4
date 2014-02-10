package Views;

/**
 * Created by desk on 2/9/14.
 */

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;


import javax.swing.*;

public class GameGrid extends JFrame implements java.util.Observer {


    JButton[] squares;
    JPanel panel;
    int nb_square;
    public GameGrid(){
        setSize(200, 100);
         }
    public GameGrid(int row,int col){
       super("Puissance 4!");
        this.nb_square = row * col;

        setSize(400,400);
         panel = new JPanel();
        squares = new JButton[nb_square];

        panel.setLayout(new GridLayout(row,col));
        for(int i =0; i<nb_square;i++){
            squares[i] = new JButton();
            panel.add(squares[i]);

        }
        add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void addController(ActionListener c){
        for(int i=0;i<nb_square; i++){
            squares[i].addActionListener(c);
        }
    }



    @Override
    public void update(Observable observable, Object o) {
        int[] t = (int[]) o;
        System.out.print("ici");
        this.squares[t[0]].setText(String.valueOf(t[1]));
           System.out.print(t[1]);
    }


    public JButton getSquareIndex(int index){
        return this.squares[index];
    }
    public int getNbSquare(){
        return nb_square;
    }
}
