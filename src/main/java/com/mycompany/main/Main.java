package com.mycompany.main;

import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import com.mycompany.controller.Controller;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
    FlatArcOrangeIJTheme.setup();
    
    SwingUtilities.invokeLater(() -> {
        try {
            Controller cont = new Controller();
            cont.iniciar();
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    });
    }
}
