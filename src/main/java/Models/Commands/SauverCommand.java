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
public class SauverCommand implements PathCommands{


    Game mGame;
    GridFacadeInterface mGrid;
    String path;

    public SauverCommand(Game mGame, GridFacadeInterface mGrid){
        this.mGame = mGame;
        this.mGrid = mGrid;
    }


    @Override
    public void executer() {
        JSONObject jsonSave = mGame.getJSONSaveString();
        jsonSave = mGrid.saveToJSON(jsonSave);

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

    @Override
    public void setPath(String path) {
        this.path = path;
    }
}
