package Models.Commands;

import Models.Facades.GridFacadeInterface;
import Models.Game;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.IOException;
import java.util.Iterator;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by MB on 4/4/2014.
 */
public class SauverCommand implements Commands{


    Game mGame;
    GridFacadeInterface mGrid;
    String path;

    public SauverCommand(Game mGame, GridFacadeInterface mGrid){
        this.mGame = mGame;
        this.mGrid = mGrid;
    }


    @Override
    public void executer() {

        path = null;
        path = askPathToSave();

        if(path!=null){
             JSONObject jsonSave = mGame.getJSONSaveString();
                jsonSave = mGrid.saveToJSON(jsonSave);

                PrintWriter writer = null;
                try {
                    writer = new PrintWriter(path, "UTF-8");
                    writer.println(jsonSave);
                } catch (IOException ex) {
                    // report
                } finally {
                    try {writer.close();} catch (Exception ex) {}
                }

        }

    }



    private String askPathToSave(){
        path = null;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Voulez-vous sauvegarder le jeu?", "Dialogue de sauvgarde", JOptionPane.YES_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION) {

            path  = JOptionPane.showInputDialog("À quel endroit le jeu devrait-il enregistrer votre partie?");

        }
       return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
