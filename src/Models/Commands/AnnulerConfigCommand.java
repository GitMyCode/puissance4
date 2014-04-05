package Models.Commands;

import Views.ConfigurationView;

/**
 * Created by MB on 4/4/2014.
 */
public class AnnulerConfigCommand implements Commands {



    ConfigurationView vConf;

    public AnnulerConfigCommand(ConfigurationView vConf){
        this.vConf = vConf;
    }


    @Override
    public void executer() {
        this.vConf.setVisible(false);
    }
}
