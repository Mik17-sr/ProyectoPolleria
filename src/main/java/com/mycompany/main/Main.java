package com.mycompany.main;

import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                FlatArcOrangeIJTheme.setup();

                JFrame frame = new JFrame("ProyPolleria");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
