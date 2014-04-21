package Models.Commands;

/**
 * Created by MB on 4/4/2014.
 */
public class MenuInvoker {

    Commands demarrerCommand;
    Commands configurerCommand;
    Commands arreterCommand;
    Commands annulerCommand;
    Commands accepterConfigCommand;
    Commands annulerConfigCommand;
    PathCommands ouvrirCommand;
    PathCommands sauverCommand;

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
    public void sauver(String path){
        sauverCommand.setPath(path);
        sauverCommand.executer();
    }
    public void ouvrir(String path){
        ouvrirCommand.setPath(path);
        ouvrirCommand.executer();
    }
    public void accepterConfig(){
        accepterConfigCommand.executer();
    }
    public void annulerConfig(){
        annulerConfigCommand.executer();
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



    public void setAccepterConfigCommand(Commands accepterConfigCommand) {
        this.accepterConfigCommand = accepterConfigCommand;
    }

    public void setAnnulerConfigCommand(Commands annulerConfigCommand) {
        this.annulerConfigCommand = annulerConfigCommand;
    }

    public void setOuvrirCommand(PathCommands ouvrirCommand){
        this.ouvrirCommand = ouvrirCommand;
    }

    public void setSauverCommand(PathCommands sauverCommand) {

        this.sauverCommand = sauverCommand;
    }

}
