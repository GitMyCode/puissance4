package Models.Commands;

import Models.Facades.GridFacadeInterface;
import Models.Game;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Iterator;
import java.io.PrintWriter;
/**
 * Created by MB on 4/4/2014.
 */
public class SauverCommand implements Commands {


    Game mGame;
    GridFacadeInterface mGrid;
    String path;

    public SauverCommand(Game mGame){
        this.mGame = mGame;
        this.path = "/tmp/test.json";
    }


    @Override
    public void executer() {
        String jsonSave = mGame.getJSONSaveString();
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(this.path, "UTF-8");
            writer.println(jsonSave);
        } catch (IOException ex) {
            // report
        } finally {
            try {writer.close();} catch (Exception ex) {}
        }

    }
}
