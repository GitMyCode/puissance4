package Models.Commands;

import Models.Facades.GridFacadeInterface;
import Models.Game;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by MB on 4/4/2014.
 */
public class OuvrirCommand implements Commands {


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

        JSONObject jsonObject = null;
        path = askPathToOpen();
        jsonObject = getJSON(path);

        if(jsonObject!= null){
            this.mGrid.restoreFromJSONObject(jsonObject);
            mGame.restoreFromJSONObject(jsonObject);

        }

/*

        int dialogResult = JOptionPane.showConfirmDialog(null, "Voulez-vous charger la dernière sauvegarde?", "Dialogue de sauvgarde", JOptionPane.YES_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION) {

            String path = JOptionPane.showInputDialog("À quel la partie est enregistrer?");
            if (path != null && !("".equals(path))) {// test si path pas vide ou si cancel
                try {

                    //Object obj = parser.parse(new FileReader("c:\\test.json"));
                    Object obj = parser.parse(new FileReader(path));
                    JSONObject jsonObject = (JSONObject) obj;
                    System.out.println("Json string:  " + jsonObject.toJSONString());

                    this.mGrid.restoreFromJSONObject(jsonObject);
                    mGame.restoreFromJSONObject(jsonObject);



                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
*/
    }
    private JSONObject getJSON(String path){

        System.out.println("ici");

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        if (path != null && !("".equals(path))) {// test si path pas vide ou si cancel
            System.out.println(path);
                try {

                    //Object obj = parser.parse(new FileReader("c:\\test.json"));
                    Object obj = parser.parse(new FileReader(path));
                    jsonObject = (JSONObject) obj;
                    System.out.println("Json string:  " + jsonObject.toJSONString());




                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        return jsonObject;
    }

    private String askPathToOpen() {
        path = null;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Voulez-vous charger la dernière sauvegarde?", "Dialogue de sauvgarde", JOptionPane.YES_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {

            path = JOptionPane.showInputDialog("À quel la partie est enregistrer?");


        }

        return path;

    }

    public void setPath(String path) {
        this.path = path;
    }
}
