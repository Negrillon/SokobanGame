package Controller;

import Model.Coordinates;
import Model.Level;

import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Deplacement {

    private Level level;

    private int directionX, directionY;

    public Deplacement(Level lvl) {
        this.level = lvl;
    }

    public Level deplacementScanner(Level lvl, String string) {
        String str = string;
        switch (str) {
            case "z":
                directionX = -1;
                directionY = 0;
                move(level);
                Level.setCounter_step(Level.getCounter_step() + 1);
                break;
            case "q":
                directionX = 0;
                directionY = -1;
                move(level);
                Level.setCounter_step(Level.getCounter_step() + 1);
                break;
            case "s":
                directionX = 1;
                directionY = 0;
                move(level);
                Level.setCounter_step(Level.getCounter_step( ) + 1);
                break;
            case "d":
                directionX = 0;
                directionY = 1;
                move(level);
                Level.setCounter_step(Level.getCounter_step() + 1);
                break;
        }
        return level;
    }

    public void move(Level lvl) {

        if ((level.getMapLevel()[level.playerCoord.getX() + directionX][level.playerCoord.getY() + directionY] != 1) && (level.getMapLevel()[level.playerCoord.getX() + directionX][level.playerCoord.getY() + directionY] != 2)) {

            level.mapLevel[level.playerCoord.getX() + directionX][level.playerCoord.getY() + directionY] = 5;
            level.mapLevel[level.playerCoord.getX()][level.playerCoord.getY()] = 0;

            if (directionX == 0) {
                level.playerCoord.setY(level.playerCoord.getY() + directionY);
            } else {
                level.playerCoord.setX(level.playerCoord.getX() + directionX);
            }

        } else if ((level.getMapLevel()[level.playerCoord.getX() + directionX][level.playerCoord.getY() + directionY] == 2) && ((level.getMapLevel()[level.playerCoord.getX() + directionX + directionX][level.playerCoord.getY() + directionY + directionY] == 0) || (level.getMapLevel()[level.playerCoord.getX() + directionX + directionX][level.playerCoord.getY() + directionY + directionY] == 4))) {
            moveBlock(level);
            if (directionX == 0) {
                level.playerCoord.setY(level.playerCoord.getY() + directionY);
            } else {
                level.playerCoord.setX(level.playerCoord.getX() + directionX);
            }
        }
    }

    private void moveBlock(Level lvl) {

        level.mapLevel[level.playerCoord.getX() + directionX + directionX][level.playerCoord.getY() + directionY + directionY] = 2;
        level.mapLevel[level.playerCoord.getX() + directionX][level.playerCoord.getY() + directionY] = 5;
        level.mapLevel[level.playerCoord.getX()][level.playerCoord.getY()] = 0;
    }

}
