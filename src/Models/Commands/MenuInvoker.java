package Models.Commands;

/**
 * Created by MB on 4/4/2014.
 */
public class MenuInvoker {

    Commands demarrerCommand;
    Commands configurerCommand;
    Commands arreterCommand;
    Commands annulerCommand;

    public MenuInvoker(){
    }

    public void demarrer(){
        demarrerCommand.executer();
    }
    public void configurer(){
        configurerCommand.executer();
    }
    public void arreter(){
        arreterCommand.executer();
    }
    public void annuler(){
        annulerCommand.executer();
    }




    public void setDemarrerCommand(Commands demarrerCommand){
       this.demarrerCommand = demarrerCommand;
    }

    public void setConfigurerCommand(Commands configurerCommand){
        this.configurerCommand = configurerCommand;
    }

    public void setArreterCommand(Commands arreterCommand) {
        this.arreterCommand = arreterCommand;
    }

    public void setAnnulerCommand(Commands annulerCommand) {
        this.annulerCommand = annulerCommand;
    }
}
