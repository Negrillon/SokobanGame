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

        String level_load = bundle.getString("lvl_1");

        lvl = new Level();


        lvl.loadLevel(level_load);

        Menu menu = new Menu(lvl);

    }
}
