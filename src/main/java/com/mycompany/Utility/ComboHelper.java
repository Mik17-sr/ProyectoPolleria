/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Utility;

/**
 *
 * @author krate
 */
import com.mycompany.model.Cliente;
import com.mycompany.model.Proveedor;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.Vector;

public class ComboHelper {

    public static void habilitarFiltrado(JComboBox<Proveedor> combo, List<Proveedor> listaOriginal) {
        combo.setEditable(true);
        JTextField field = (JTextField) combo.getEditor().getEditorComponent();

        // Guardamos la lista completa original
        Vector<Proveedor> original = new Vector<>(listaOriginal);

        field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String texto = field.getText().toLowerCase();
                combo.hidePopup();

                DefaultComboBoxModel<Proveedor> modelo = new DefaultComboBoxModel<>();

                // Agregar siempre el dummy como primer elemento
                Proveedor dummy = new Proveedor();
                dummy.setIdproveedor(-1);
                dummy.setNombre("Seleccione proveedor...");
                modelo.addElement(dummy);

                for (Proveedor p : original) {
                    if (p.getNombre().toLowerCase().contains(texto)) {
                        modelo.addElement(p);
                    }
                }

                combo.setModel(modelo);
                field.setText(texto); // Restaurar el texto
                combo.showPopup();
            }
        });
    }

    public static void habilitarFiltradoC(JComboBox<Object> combo, List<Cliente> listaOriginal) {
        combo.setEditable(true);
        JTextField field = (JTextField) combo.getEditor().getEditorComponent();

        // Guardamos la lista completa original
        Vector<Cliente> original = new Vector<>(listaOriginal);

        field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String texto = field.getText().toLowerCase();
                combo.hidePopup();

                DefaultComboBoxModel<Object> modelo = new DefaultComboBoxModel<>();


                for (Cliente p : original) {
                    if (p.getNombre().toLowerCase().contains(texto)) {
                        modelo.addElement(p);
                    }
                }

                combo.setModel(modelo);
                field.setText(texto); // Restaurar el texto
                combo.showPopup();
            }
        });
    }
}
