package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Level {

    public int[][] mapLevel;

    private static int counter_step = 0;

    public Coordinates playerCoord;

    public static int getCounter_step() {
        return counter_step;
    }

    public static void setCounter_step(int counter_step) {
        Level.counter_step = counter_step;
    }

    public List<Coordinates> goalCoord = new ArrayList<Coordinates>();


    public void loadLevel(String lvl_id) {

        mapLevel = new int[11][19];

        File file = new File(lvl_id);

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("erreur file reader");
            e.printStackTrace();
        }

        String st = "";

        try {
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 19; j++) {
                    if ((st = br.readLine()) != null) {
                        mapLevel[i][j] = parseInt(st);
                    }
                }

            }

            getGoalInitmap();

        } catch (Exception e) {
            System.out.println("erreur readLine");
            System.out.println(e);
        }
    }

    public int[][] getMapLevel() {
        return mapLevel;
    }

    //Méthode permettant de récupérer les cases GOAL au chargement de la map
    public void getGoalInitmap() {
        int k = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 19; j++) {
                if (mapLevel[i][j] == 4) {
                    goalCoord.add(k, new Coordinates(i, j));
                    k++;
                } else if (mapLevel[i][j] == 5) {
                    playerCoord = new Coordinates(i, j);
                }
            }
        }
    }
}
