package View;

import Controller.GoalTest;
import Model.Deplacement;
import Model.Level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Menu extends JFrame {

    private JPanel jPanel = new JPanel(new GridLayout());
    private JButton jButtonConsole = new JButton("Mode Console");
    private JButton jButtonGraphic = new JButton("Mode Graphique");
    private MenuBar menuBar = new MenuBar();

    private Level level;
    private Deplacement deplacement = new Deplacement(level);
    private GoalTest goalTest = new GoalTest();
    private Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public Menu(Level lvl) throws HeadlessException {

        this.level = lvl;

        //Initialisation du JPanel
        getContentPane().add(jPanel);
        setTitle("Menu");
        setSize(((int) dimension.getWidth()) / 3, ((int) dimension.getHeight()) / 3);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //Initialisation du bouton Console
        jPanel.add(jButtonConsole);
        jButtonConsole.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                //Créer une classe ControleurConsole pour faire le lien View - Controller
                while (!GoalTest.test(level)) {
                    ConsoleOutput.consoleMapDisplay(level);
                    System.out.println("Veuillez saisir votre déplacement: ");
                    Scanner sc = new Scanner(System.in);
                    String str = sc.nextLine();
                    level = deplacement.deplacementScanner(level, str);
                }
            }
        });

        //Initialisation du bouton Graphique
        jPanel.add(jButtonGraphic);
        jButtonGraphic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                //Créer une classe ControleurGraphique pour faire le lien View - Controller
                Game game = new Game(lvl);
                while (!GoalTest.test(level)) {

                }
                JOptionPane.showMessageDialog(game,"Partie gagnée!");
            }
        });

        //Mise en place de la MenuBar
        getContentPane().add(menuBar);
    }
}
