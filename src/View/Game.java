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

    private Level lvl;
    private Deplacement deplacement;

    private String str;
    private Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();


    public Game(Level level) throws HeadlessException {

        this.lvl = level;
        this.deplacement = new Deplacement(lvl);
        getContentPane().add(new LoadGame(lvl));

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

            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {

                    case KeyEvent.VK_Z:
                        str = Character.toString(e.getKeyChar());
                        lvl = deplacement.deplacementScanner(lvl, str);
                        repaint();
                        revalidate();
                        break;

                    case KeyEvent.VK_S:
                        str = Character.toString(e.getKeyChar());
                        lvl = deplacement.deplacementScanner(lvl, str);
                        repaint();
                        revalidate();
                        break;

                    case KeyEvent.VK_Q:
                        str = Character.toString(e.getKeyChar());
                        lvl = deplacement.deplacementScanner(lvl, str);
                        repaint();
                        revalidate();
                        break;

                    case KeyEvent.VK_D:
                        str = Character.toString(e.getKeyChar());
                        lvl = deplacement.deplacementScanner(lvl, str);
                        repaint();
                        revalidate();
                        break;
                }
                if (GoalTest.test(lvl)) {
                    JOptionPane.showMessageDialog(Game.super.getContentPane(), "Partie Gagnée en " + Level.getCounter_step() + " coups");
                }
            }
        });
    }
}
