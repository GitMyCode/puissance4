package Models.Commands;

import Models.GLOBAL;
import Models.Options;
import Views.ConfigurationView;

/**
 * Created by MB on 4/4/2014.
 */
public class AccepterConfigCommand implements Commands{


    Options mOptions;
    ConfigurationView vConf;

    public AccepterConfigCommand(Options mOption, ConfigurationView vConf){
        this.mOptions = mOption;
        this.vConf = vConf;
    }

    @Override
    public void executer() {

        syncToOption();
        vConf.setVisible(false);
    }


    /*
    * Prend les nouvelles configuration et les sauvegarde dans les options
    * */
    public void syncToOption(){

        //Set l'option avec le action_commande du button selectionner dans le buttonGroup
        mOptions.setPlayer1Type(Integer.parseInt(vConf.getSlectedButton(vConf.getGroupP1type())));
        mOptions.setPlayer2Type(Integer.parseInt(vConf.getSlectedButton(vConf.getGroupP2type())));

        mOptions.setStartingPlayer(Integer.parseInt(vConf.getSlectedButton(vConf.getGroupTurn())));

        mOptions.setSizeX(Integer.parseInt(vConf.getRow().getText()));
        mOptions.setSizeY(Integer.parseInt(vConf.getCol().getText()));

        boolean clickAbove = (vConf.getSlectedButton(vConf.getGroupPlacement())== GLOBAL.action_COULISSE);
        mOptions.setAllowClickAbove(clickAbove);
    }
}
