package com.mycompany.Utility;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextPane;

public class PlaceholderUtil {

    // método estático para reutilizar en toda la app
    public static void placeholder(JTextField txt, String texto) {
        txt.setText(texto);
        txt.setForeground(Color.GRAY);

        txt.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                if (txt.getText().equals(texto)) {
                    txt.setText("");
                    txt.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txt.getText().isEmpty()) {
                    txt.setText(texto);
                    txt.setForeground(Color.GRAY);
                }
            }
        });
    }

    public static void placeholder(JTextPane txt, String texto) {
        txt.setText(texto);
        txt.setForeground(Color.GRAY);

        txt.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                if (txt.getText().equals(texto)) {
                    txt.setText("");
                    txt.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txt.getText().isEmpty()) {
                    txt.setText(texto);
                    txt.setForeground(Color.GRAY);
                }
            }
        });
    }
}
