package com.mycompany.main;

import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import com.mycompany.controller.Controller;
import java.awt.Color;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
    UIManager.put("Table.showHorizontalLines", true);
    UIManager.put("Table.showVerticalLines", true);
    UIManager.put("Table.gridColor", new Color(220, 220, 220));
    UIManager.put("Table.rowHeight", 28);

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
