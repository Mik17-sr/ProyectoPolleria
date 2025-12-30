/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author krate
 */
public class guardarBD {

    public static void descargar() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Guardar archivo");
        chooser.setSelectedFile(new File("Copia_DB.pdf"));
        int opcion = chooser.showSaveDialog(null);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            File destino = chooser.getSelectedFile();
            Path origen = Paths.get("pollodb.db");
            try {
                Files.copy(origen, destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                JOptionPane.showMessageDialog(null,
                        "Archivo guardado correctamente");

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,
                    "Error al guardar el archivo",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
