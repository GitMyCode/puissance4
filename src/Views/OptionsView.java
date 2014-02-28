package Views;

import javax.swing.*;

/**
 * Created by desk on 2/23/14.
 */
public class OptionsView extends JPanel{

    private JButton demarrer;
    private JButton arreter;
    private JButton annuler;
    private JButton ouvrir;
    private JButton configurer;
    public OptionsView(){
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

        OptionsView.this.add(demarrer);
        OptionsView.this.add(arreter);
        OptionsView.this.add(annuler);
        OptionsView.this.add(ouvrir);
        OptionsView.this.add(configurer);
    }

}
