package View;

import Controller.GoalTest;
import Model.Deplacement;
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

    public Game(Level level) throws HeadlessException {

        this.lvl = level;
        Deplacement deplacement = new Deplacement(lvl);
        LoadGame loadGame = new LoadGame(lvl);
        getContentPane().add(loadGame);

        setTitle("Game");
        setSize(((int) dimension.getWidth()) / 3, ((int) dimension.getHeight()) / 3);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_Z:
                        System.out.println("z");
                        str = Character.toString(e.getKeyChar());
                        lvl = deplacement.deplacementScanner(lvl, str);
                        repaint();
                        revalidate();
                        break;
                    case KeyEvent.VK_S:
                        System.out.println("s");
                        str = Character.toString(e.getKeyChar());
                        lvl = deplacement.deplacementScanner(lvl, str);
                        repaint();
                        revalidate();
                        break;
                    case KeyEvent.VK_Q:
                        System.out.println("q");
                        str = Character.toString(e.getKeyChar());
                        lvl = deplacement.deplacementScanner(lvl, str);
                        repaint();
                        revalidate();
                        break;
                    case KeyEvent.VK_D:
                        System.out.println("d");
                        str = Character.toString(e.getKeyChar());
                        lvl = deplacement.deplacementScanner(lvl, str);
                        repaint();
                        revalidate();
                        break;
                }
                if(GoalTest.test(lvl)){
                    JOptionPane.showMessageDialog(Game.super.getContentPane(),"Partie Gagnée");
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
