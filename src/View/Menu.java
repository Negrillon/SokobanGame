package View;

import Controller.BoutonConsole;
import Controller.GoalTest;
import Controller.Deplacement;
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
    private JButton jButtonIA = new JButton("Mode IA");
    private MenuBar menuBar = new MenuBar();

    private Level level;
    private Deplacement deplacement;
    private Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public Menu(Level lvl) throws HeadlessException {

        this.level = lvl;
        this.deplacement = new Deplacement(lvl);

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
                new BoutonConsole().actionBoutonConsole(lvl);
            }
        });

        //Initialisation du bouton Graphique
        jPanel.add(jButtonGraphic);
        jButtonGraphic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                new Game(lvl);
            }
        });

        //Initialisation du bouton IA
        jPanel.add(jButtonIA);
        jButtonIA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Code à aller chercher dans le contrôleur pour lancer l'IA
            }
        });

        //Mise en place de la MenuBar
        getContentPane().add(menuBar);
    }
}
