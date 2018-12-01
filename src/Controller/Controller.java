package Controller;

import Model.Level;
import View.ConsoleOutput;
import View.Menu;

import javax.swing.*;

public class Controller {

    private static Level lvl;

    public static void main(String[] args) {
        lvl = new Level();
        lvl.loadLevel("/Users/joris/Document/Projet ING3/jojo-roro/MySokoban FX/src/ressource/map/map_01");

        Menu menu = new Menu(lvl);

    }
}
