package Models;

/**
 * Created by desk on 2/9/14.
 */
public class Square  {

    /**
    status = 0 = libre
    status = 1 = player1
    status = 2 = player2
    * */
    int status =0;
    public Square(){

    }

    public Square(int status){
        // faire un check si entre 0 et 2
        this.status = status;
    }

    public void incrementStatus(){
        this.status++;
        this.status%=3;
    }
    public void setStatus(int status){
        this.status = status;
    }
    public int getStatus(){
        return this.status;
    }

}
