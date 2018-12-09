package View;

import Controller.GoalTest;
import Controller.Deplacement;
import Model.Coordinates;
import Model.Level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame {

    Level lvl;
    //private Deplacement deplacement = new Deplacement(lvl);

    private String str;
    private Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    int counter_step;
    Coordinates save_player;

    public Game(Level level) throws HeadlessException {

        this.lvl = level;
        Deplacement deplacement = new Deplacement(lvl);
        LoadGame loadGame = new LoadGame(lvl);
        getContentPane().add(loadGame);

        counter_step = 0;

        //Initialisation de la Frame Game
        setTitle("Game");
        setSize(((int) dimension.getWidth()) / 4, ((int) dimension.getHeight()) / 4);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //Ajout de l'évènement KeyPressed afin de faire bouger notre personnage en mode graphique après avoir appuyer sur une touche
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_Z:
                        System.out.println("z");

                        counter_step++;

                        str = Character.toString(e.getKeyChar());
                        lvl = deplacement.deplacementScanner(lvl, str);
                        repaint();
                        revalidate();
                        break;
                    case KeyEvent.VK_S:
                        System.out.println("s");

                        counter_step++;

                        str = Character.toString(e.getKeyChar());
                        lvl = deplacement.deplacementScanner(lvl, str);
                        repaint();
                        revalidate();
                        break;
                    case KeyEvent.VK_Q:
                        System.out.println("q");

                        counter_step++;

                        str = Character.toString(e.getKeyChar());
                        lvl = deplacement.deplacementScanner(lvl, str);
                        repaint();
                        revalidate();
                        break;
                    case KeyEvent.VK_D:
                        System.out.println("d");

                        save_player = lvl.playerCoord;

                        str = Character.toString(e.getKeyChar());
                        lvl = deplacement.deplacementScanner(lvl, str);
                        repaint();
                        revalidate();

                        if (lvl.playerCoord != save_player) {
                            counter_step++;
                        }

                        break;
                }
                if (GoalTest.test(lvl)) {
                    JOptionPane.showMessageDialog(Game.super.getContentPane(), "Partie Gagnée en " + counter_step + " coups");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
/*
    private void displayCharacter(){
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 19; j++) {
                switch (str) {
                    case "z":

                        loadGame.drawImage(image5haut.getImage(), j * 20, i * 20, null);
                        break;
                    case "s":
                        graphics.drawImage(image5bas.getImage(), j * 20, i * 20, null);
                        break;
                    case "q":
                        graphics.drawImage(image5gauche.getImage(), j * 20, i * 20, null);
                        break;
                    case "d":
                        graphics.drawImage(image5droite.getImage(), j * 20, i * 20, null);
                        break;

                }

            }
        }
    }*/
}
