package Models.Commands;

import Models.GLOBAL;
import Models.Options;
import Views.ConfigurationView;


/**
 * Created by MB on 4/4/2014.
 */
public class ConfigurerCommand implements Commands {


    private Options mOptions;
    private ConfigurationView vConf;



    public ConfigurerCommand(Options mOption, ConfigurationView vConf){
        this.mOptions = mOption;
        this.vConf = vConf;
    }

    @Override
    public void executer() {
        syncFromOption();
        vConf.setVisible(true);

    }

    public void syncFromOption(){

        // Pour le type du joueur 1 : AI ou Humain

        switch (mOptions.getPlayer1Type()){
            case GLOBAL.AI:     vConf.getGroupP1type().setSelected(vConf.getP1Ai().getModel(),true); break;
            case GLOBAL.HUMAN : vConf.getGroupP1type().setSelected(vConf.getP1Human().getModel(),true); break;
        }

        // Pour le type du joueur 2 : Ai ou Humain
        switch (mOptions.getPlayer2Type()){
            case GLOBAL.AI:     vConf.getGroupP2type().setSelected(vConf.getP2Ai().getModel(),true); break;
            case GLOBAL.HUMAN: vConf.getGroupP2type().setSelected(vConf.getP2Human().getModel(),true); break;
        }

        // Pour le joueur qui commence la partie
        switch (mOptions.getStartingPlayer()){
            case 1: vConf.getGroupTurn().setSelected(vConf.getP1Turn().getModel(),true); break;
            case 2: vConf.getGroupTurn().setSelected(vConf.getP2Turn().getModel(),true); break;
        }

        // La taille de la grille
        vConf.getRow().setText(String.valueOf(mOptions.getSizeX()));
        vConf.getCol().setText(String.valueOf(mOptions.getSizeY()));

        // Si on peut clicker au dessu ou doit etre exact
        if(mOptions.isAllowClickAbove()){
            vConf.getGroupPlacement().setSelected(vConf.getCoulisse().getModel(),true);
        }else{
            vConf.getGroupPlacement().setSelected(vConf.getExact().getModel(),true);
        }

    }


}
