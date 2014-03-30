package Views;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.Event.*;
import java.awt.event.ActionEvent;

/**
 * Created by desk on 2/23/14.
 */
public class MenuView extends JPanel{

    private JButton demarrer;
    private JButton arreter;
    private JButton annuler;
    private JButton ouvrir;
    private JButton configurer;
    public MenuView(){
        super();

        demarrer = new JButton();
        arreter= new JButton();
        annuler= new JButton();
        ouvrir= new JButton();
        configurer= new JButton();

        demarrer.setText("Démarrer");
        arreter.setText("Arrêter");
        annuler.setText("Annuler");
        ouvrir.setText("Ouvrir");
        configurer.setText("Configurer");

        MenuView.this.add(demarrer);
        MenuView.this.add(arreter);
        MenuView.this.add(annuler);
        MenuView.this.add(ouvrir);
        MenuView.this.add(configurer);
    }


    public void addController(ActionListener mouseListener){
        demarrer.addActionListener(mouseListener);
    }
}
