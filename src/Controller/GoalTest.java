package Controller;

import Model.Level;

public class GoalTest {

    public static boolean test(Level lvl) {

        int nbgoalvide = lvl.goalCoord.size();

        for (int i = 0; i < lvl.goalCoord.size(); i++) {
            if (lvl.mapLevel[lvl.goalCoord.get(i).getX()][lvl.goalCoord.get(i).getY()] == 2) {
                nbgoalvide--;
            }
        }
        if (nbgoalvide == 0) {
            //Toutes cases goal sont remplies
            return true;
        }
        //Les cases ne sont pas toutes remplies
        return false;
    }
}
