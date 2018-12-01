package View;

import Model.Deplacement;
import Model.Level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame {

    Level lvl;
    private Deplacement deplacement = new Deplacement(lvl);
    private String str;
    private Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public Game(Level level) throws HeadlessException {

        this.lvl = level;
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
                        lvl = deplacement.deplacementScannerv2(lvl, e);
                        repaint();
                        revalidate();
                        break;
                    case KeyEvent.VK_S:
                        System.out.println("s");
                        break;
                    case KeyEvent.VK_Q:
                        System.out.println("q");
                        break;
                    case KeyEvent.VK_D:
                        System.out.println("d");
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
}
