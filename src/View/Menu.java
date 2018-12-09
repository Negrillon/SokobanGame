package View;

import Controller.BoutonConsole;
import Controller.GoalTest;
import Controller.Deplacement;
import Model.Coordinates;
import Model.Level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.Console;
import java.util.Scanner;

public class Menu extends JFrame {

    private JPanel jPanel = new JPanel(new GridLayout());
    private JButton jButtonConsole = new JButton("Mode Console");
    private JButton jButtonGraphic = new JButton("Mode Graphique");
    private JButton jButtonIA = new JButton("Mode IA");
    private MenuBar menuBar = new MenuBar();

    private Level level;
    private Deplacement deplacement;
    private Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public Menu(Level lvl) throws HeadlessException {

        this.level = lvl;
        this.deplacement = new Deplacement(lvl);

        //Initialisation du JPanel
        getContentPane().add(jPanel);
        setTitle("Menu");
        setSize(((int) dimension.getWidth()) / 3, ((int) dimension.getHeight()) / 3);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //Initialisation du bouton Console
        jPanel.add(jButtonConsole);
        jButtonConsole.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                BoutonConsole boutonConsole = new BoutonConsole();
                boutonConsole.actionBoutonConsole(lvl);
            }
        });

        //Initialisation du bouton Graphique
        jPanel.add(jButtonGraphic);
        jButtonGraphic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                //Créer une classe ControleurGraphique pour faire le lien View - Controller
                new Game(lvl);
            }
        });

        //Initialisation du bouton IA
        jPanel.add(jButtonIA);
        jButtonIA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Code à aller chercher dans le contrôleur pour lancer l'IA
                new Game(lvl);

                try {
                    Robot robot = new Robot();

                    robot.setAutoDelay(2000);

                    robot.keyPress(KeyEvent.VK_Z);

                    ConsoleOutput.consoleMapDisplay(lvl);

                    Coordinates save_player = lvl.playerCoord;
                    while(save_player != lvl.playerCoord){
                        robot.keyPress(KeyEvent.VK_Z);
                        robot.setAutoDelay(2000);
                    }
                    while(save_player != lvl.playerCoord){
                        robot.keyPress(KeyEvent.VK_S);
                        robot.setAutoDelay(2000);
                    }
                    while(save_player != lvl.playerCoord){
                        robot.keyPress(KeyEvent.VK_D);
                        robot.setAutoDelay(2000);
                    }
                    while(save_player != lvl.playerCoord){
                        robot.keyPress(KeyEvent.VK_Q);
                        robot.setAutoDelay(2000);
                    }

                } catch (AWTException e1) {
                    e1.printStackTrace();
                }




            }
        });

        //Mise en place de la MenuBar
        getContentPane().add(menuBar);
    }
}
