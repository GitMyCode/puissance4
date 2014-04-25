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

        int dialogResult = JOptionPane.showConfirmDialog(null, "Voulez-vous sauvegarder le jeu?", "Dialogue de sauvgarde", JOptionPane.YES_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            /*JFrame frame = new JFrame();
            frame.setSize(200,200);
            final JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(frame);
*/

            String path  = JOptionPane.showInputDialog("À quel endroit le jeu devrait-il enregistrer votre partie?");
            path = "c:\\test.json";
            if(path != null && !("".equals(path))){// test si path pas vide ou si cancel
                System.out.println("test");
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


    }

    public void setPath(String path) {
        this.path = path;
    }
}
