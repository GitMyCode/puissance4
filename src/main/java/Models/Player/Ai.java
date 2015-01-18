package Models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.BeansException;


/**
 * Created by mb on 2/19/14.
 */
public class Ai extends Player{
    ApplicationContext context;
    private Strategy strategy;


    public Ai(int color) {
        super(color);
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        strategy = (Strategy) context.getBean("AIStrategy");
    }

    @Override
    public boolean play(int index) {
        int move =strategy.move(super.mGrid,getColor());
       return super.play(move);
    }

    @Override
    public boolean hasWin() {
        return super.hasWin();
    }

    @Override
    public boolean isReadyToPlay() {
        return true; // Le AI est toujoru pres a jouer
    }

    @Override
    public int getColor() {
        return super.getColor();
    }


    @Override
    public void setReady(boolean turn) {
        super.setReady(turn);
    }

    @Override
    public void setTurn(boolean turn) {
        super.setTurn(turn);
    }

    @Override
    public boolean getTurn() {
        return super.getTurn();
    }

}
