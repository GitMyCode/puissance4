package Views;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by desk on 2/9/14.
 */
public class SquareView extends JButton {
    private static final Random rnd = new Random();
    public SquareView(){
        super();
       // this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        this.setBackground(new Color(rnd.nextInt()));
    }

}
