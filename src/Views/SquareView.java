package Views;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by desk on 2/9/14.
 */


public class SquareView extends JPanel {

    private Color squareColor = Color.white;

    private static final Random rnd = new Random();
    public SquareView(){
        super();
       // this.setBorderPainted(false);
       // this.setFocusPainted(false);
      //  this.setContentAreaFilled(false);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setPreferredSize(new Dimension(100, 100));
       this.setBackground(Color.blue);
       // paintComponent((Graphics) this);
    }
/*
    @Override
    public void paintComponents(Graphics g) {
        System.out.println("ini");

        super.paintComponents(g);
        int h = getHeight();
        int w = getWidth();
        g.setColor(new Color(rnd.nextInt()));
        g.fillOval(w/2, h/2, w, h);
        //g.drawOval(0, 0, g.getClipBounds().width, g.getClipBounds().height);
    }*/
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(getColor());
        Dimension dim = getSize();
        g.fillOval(6, 6, dim.width -10, dim.height - 10);
    }


    public Color getColor(){
        return this.squareColor;
    }

    public void setColor(Color color){
        this.squareColor = color;
        repaint();
    }

}
