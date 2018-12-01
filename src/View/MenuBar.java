package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MenuBar extends JMenuBar {

    private JMenu jMenu = new JMenu("Menu");
    private JMenu jSubMenu = new JMenu("SubMenu");
    private JMenuItem jMenuItem = new JMenuItem("Quit");

    public MenuBar() {
        jMenu.addSeparator();
        jMenu.add(jSubMenu);
        add(jMenu);

        //Raccourci (ex: Ctrl Q) pour aller plus vite sans devoir passer par le menu
        jMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,KeyEvent.VK_ALT));
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jMenu.add(jMenuItem);

    }
}
