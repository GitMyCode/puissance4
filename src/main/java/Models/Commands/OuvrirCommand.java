package Models.Commands;

import Models.Facades.GridFacadeInterface;
import Models.Game;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by MB on 4/4/2014.
 */
public class OuvrirCommand implements PathCommands {


    Game mGame;
    GridFacadeInterface mGrid;
    String path;

    public OuvrirCommand(Game mGame, GridFacadeInterface mGrid){
        this.mGame = mGame;
        this.mGrid = mGrid;
    }


    @Override
    public void executer() {
        mGame.reset();
        mGrid.reset();
        JSONParser parser = new JSONParser();
        System.out.println("Path:" + this.path);
        try {

            //Object obj = parser.parse(new FileReader("c:\\test.json"));
            Object obj = parser.parse(new FileReader(path));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("Json string:  " + jsonObject.toJSONString());
            mGame.restoreFromJSONObject(jsonObject);

            // loop array
            JSONArray msg = (JSONArray) jsonObject.get("messages");
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }
}
