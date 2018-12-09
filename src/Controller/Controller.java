package Controller;

import Model.Level;
import View.ConsoleOutput;
import View.Menu;
import sun.net.ProgressSource;

import javax.swing.*;
import java.util.ResourceBundle;

public class Controller {

    private static Level lvl;





    public static void main(String[] args) {


        ResourceBundle bundle = ResourceBundle.getBundle("Ressources.domaine.properties.config");


        int i=1;
        do {
            String level_load = bundle.getString("lvl_" +i);

            lvl = new Level();


            lvl.loadLevel(level_load);

            Menu menu = new Menu(lvl);
            i++;
        }while(GoalTest.test(lvl));



    }
}
