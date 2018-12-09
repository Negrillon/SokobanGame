package Controller;

import Model.Level;
import View.ConsoleOutput;

import java.util.Scanner;


public class BoutonConsole {

    private Level level;
    private Deplacement deplacement;

    public void actionBoutonConsole(Level lvl) {

        this.level = lvl;
        deplacement = new Deplacement(lvl);

        while (!GoalTest.test(level)) {
            ConsoleOutput.consoleMapDisplay(level);
            System.out.println("Veuillez saisir votre déplacement: ");
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            level = deplacement.deplacementScanner(level, str);
        }
        System.out.println("Partie gagnée !");
    }
}
