/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Utility;

import com.mycompany.DAO.proveedorDAO;
import com.mycompany.model.Proveedor;
import com.mycompany.vista.FrmPrincipal;
import java.util.Comparator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author krate
 */
public class utility {

    static public void rellenarcombox(FrmPrincipal frm) {
        DefaultComboBoxModel<Proveedor> modelo = new DefaultComboBoxModel<>();
        proveedorDAO ob = new proveedorDAO();

        try {
            List<Proveedor> lista = ob.listarTodos();
            Proveedor dummy = new Proveedor();

            if (lista == null || lista.isEmpty()) {
                frm.getCmbcompraReg().setEnabled(false);
                frm.getBtnregistrarcompra().setEnabled(false);

                frm.getCmbnombreEditproveedor().setEnabled(false);
                frm.getBtnEditproveedor().setEnabled(false);

                dummy.setIdproveedor(-1);
                dummy.setNombre("No hay proveedores registrados");
            } else {
                frm.getCmbcompraReg().setEnabled(true);
                frm.getBtnregistrarcompra().setEnabled(true);
                frm.getCmbnombreEditproveedor().setEnabled(true);
                frm.getBtnEditproveedor().setEnabled(true);
                dummy.setIdproveedor(-1);
                dummy.setNombre("Seleccione proveedor...");

                // Ordenar alfabéticamente ignorando mayúsculas
                lista.sort(Comparator.comparing(Proveedor::getNombre, String.CASE_INSENSITIVE_ORDER));
            }

            // Agregar primero el marcador de posición
            modelo.addElement(dummy);

            // Agregar el resto de la lista si no está vacía
            if (lista != null) {
                lista.forEach(modelo::addElement);
            }

            frm.getCmbcompraReg().setModel(modelo);
            frm.getCmbcompraReg().setSelectedIndex(0);

            frm.getCmbnombreEditproveedor().setModel(modelo);
            frm.getCmbnombreEditproveedor().setSelectedIndex(0);

        } catch (Exception e) {
            System.err.println("Error al cargar proveedores: " + e.getMessage());
            // Aquí podrías mostrar un JOptionPane de error
        }
    }
}
