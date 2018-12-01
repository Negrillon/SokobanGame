package View;

import Model.Level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoadGame extends JPanel {

    Level lvl;
    String str="z";
    ImageIcon image0 = new ImageIcon("src/Ressources/Images/0.png");
    ImageIcon image1 = new ImageIcon("src/Ressources/Images/1.png");
    ImageIcon image2 = new ImageIcon("src/Ressources/Images/2.png");
    ImageIcon image3 = new ImageIcon("src/Ressources/Images/3.png");
    ImageIcon image4 = new ImageIcon("src/Ressources/Images/4.png");
    ImageIcon image5haut = new ImageIcon("src/Ressources/Images/5haut.png");
    ImageIcon image5bas = new ImageIcon("src/Ressources/Images/5bas.png");
    ImageIcon image5gauche = new ImageIcon("src/Ressources/Images/5gauche.png");
    ImageIcon image5droite = new ImageIcon("src/Ressources/Images/5droite.png");

    public LoadGame(Level lvl) {
        this.lvl = lvl;
    }

    public void paintComponent(Graphics graphics) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 19; j++) {
                switch (lvl.mapLevel[i][j]) {
                    case 0:
                        graphics.drawImage(image0.getImage(), j * 20, i * 20, null);
                        break;
                    case 1:
                        graphics.drawImage(image1.getImage(), j * 20, i * 20, null);
                        break;
                    case 2:
                        graphics.drawImage(image2.getImage(), j * 20, i * 20, null);
                        break;
                    case 3:
                        graphics.drawImage(image3.getImage(), j * 20, i * 20, null);
                        break;
                    case 4:
                        graphics.drawImage(image4.getImage(), j * 20, i * 20, null);
                        break;
                    case 5:
                        switch (str) {
                            case "z":
                                graphics.drawImage(image5haut.getImage(), j * 20, i * 20, null);
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
        }
    }
}
