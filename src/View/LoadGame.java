package View;

import Model.Level;

import javax.swing.*;
import java.awt.*;

public class LoadGame extends JPanel {

    Level lvl;

    public LoadGame(Level lvl) {
        this.lvl = lvl;
    }

    public void paintComponent(Graphics graphics){
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 19; j++) {
                switch (lvl.mapLevel[i][j]){
                    case 0:  graphics.drawImage(new ImageIcon("/Users/joris/Document/Projet ING3/Sokoban/Sokoban/src/Ressources/Images/0.png").getImage(), j*20, i*20,  null);
                        break;
                    case 1:  graphics.drawImage(new ImageIcon("/Users/joris/Document/Projet ING3/Sokoban/Sokoban/src/Ressources/Images/1.png").getImage(), j*20, i*20, null);
                        break;
                    case 2:  graphics.drawImage(new ImageIcon("/Users/joris/Document/Projet ING3/Sokoban/Sokoban/src/Ressources/Images/2.png").getImage(), j*20, i*20, null);
                        break;
                    case 3:  graphics.drawImage(new ImageIcon("/Users/joris/Document/Projet ING3/Sokoban/Sokoban/src/Ressources/Images/3.png").getImage(), j*20, i*20, null);
                        break;
                    case 4:  graphics.drawImage(new ImageIcon("/Users/joris/Document/Projet ING3/Sokoban/Sokoban/src/Ressources/Images/4.png").getImage(), j*20, i*20,  null);
                        break;
                    case 5:  graphics.drawImage(new ImageIcon("/Users/joris/Document/Projet ING3/Sokoban/Sokoban/src/Ressources/Images/5haut.png").getImage(),j*20, i*20,  null);
                        break;
                }
            }
        }
    }
}
