package View;

import Model.Level;

public class ConsoleOutput {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static void consoleMapDisplay(Level lvl) {

        int[][] cacheMap = lvl.getMapLevel();

        for (int i = 0; i < lvl.goalCoord.size(); i++) {
            if (cacheMap[lvl.goalCoord.get(i).getX()][lvl.goalCoord.get(i).getY()] == 0)
                cacheMap[lvl.goalCoord.get(i).getX()][lvl.goalCoord.get(i).getY()] = 4;
        }
        for (int i = 0; i < lvl.mapLevel.length; i++) {
            for (int j = 0; j < lvl.mapLevel[0].length; j++) {
                if (cacheMap[i][j] == 1)
                    System.out.print(ANSI_RED + "1 " + ANSI_RESET);
                else if (cacheMap[i][j] == 2)
                    System.out.print(ANSI_BLUE + "2 " + ANSI_RESET);
                else if (cacheMap[i][j] == 5)
                    System.out.print(ANSI_PURPLE + "5 " + ANSI_RESET);
                else if (cacheMap[i][j] == 4)
                    System.out.print(ANSI_GREEN + "4 " + ANSI_RESET);
                else System.out.print(cacheMap[i][j] + " ");
            }
            System.out.println();
        }
    }
}
