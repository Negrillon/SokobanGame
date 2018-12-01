package Model;

import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Deplacement {

    private Level lvl;

    private int directionX, directionY;

    public Deplacement(Level lvl) {
        this.lvl = lvl;
    }

    public Level deplacementScanner(Level lvl, String string) {
        String str = string;
        switch (str) {
            case "z":
                directionX = -1;
                directionY = 0;
                move();
                break;
            case "q":
                directionX = 0;
                directionY = -1;
                move();
                break;
            case "s":
                directionX = 1;
                directionY = 0;
                move();
                break;
            case "d":
                directionX = 0;
                directionY = 1;
                move();
                break;
        }
        return lvl;
    }

    public Level deplacementScannerv2(Level lvl, KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_Z:
                directionX = -1;
                directionY = 0;
                move();
                break;
            case KeyEvent.VK_Q:
                directionX = 0;
                directionY = -1;
                move();
                break;
            case KeyEvent.VK_S:
                directionX = 1;
                directionY = 0;
                move();
                break;
            case KeyEvent.VK_D:
                directionX = 0;
                directionY = 1;
                move();
                break;
        }
        return lvl;
    }

    public void move() {

        if ((lvl.getMapLevel()[lvl.playerCoord.getX() + directionX][lvl.playerCoord.getY() + directionY] != 1) && (lvl.getMapLevel()[lvl.playerCoord.getX() + directionX][lvl.playerCoord.getY() + directionY] != 2)) {

            lvl.mapLevel[lvl.playerCoord.getX() + directionX][lvl.playerCoord.getY() + directionY] = 5;
            lvl.mapLevel[lvl.playerCoord.getX()][lvl.playerCoord.getY()] = 0;

            if (directionX == 0) {
                lvl.playerCoord.setY(lvl.playerCoord.getY() + directionY);
            } else {
                lvl.playerCoord.setX(lvl.playerCoord.getX() + directionX);
            }

        } else if ((lvl.getMapLevel()[lvl.playerCoord.getX() + directionX][lvl.playerCoord.getY() + directionY] == 2) && ((lvl.getMapLevel()[lvl.playerCoord.getX() + directionX + directionX][lvl.playerCoord.getY() + directionY + directionY] == 0) || (lvl.getMapLevel()[lvl.playerCoord.getX() + directionX + directionX][lvl.playerCoord.getY() + directionY + directionY] == 4))) {
            moveBlock();
            if (directionX == 0) {
                lvl.playerCoord.setY(lvl.playerCoord.getY() + directionY);
            } else {
                lvl.playerCoord.setX(lvl.playerCoord.getX() + directionX);
            }
        }
    }

    private void moveBlock() {

        lvl.mapLevel[lvl.playerCoord.getX() + directionX + directionX][lvl.playerCoord.getY() + directionY + directionY] = 2;
        lvl.mapLevel[lvl.playerCoord.getX() + directionX][lvl.playerCoord.getY() + directionY] = 5;
        lvl.mapLevel[lvl.playerCoord.getX()][lvl.playerCoord.getY()] = 0;
    }
}
