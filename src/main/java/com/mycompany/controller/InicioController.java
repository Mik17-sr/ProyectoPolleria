/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.model.Cliente;
import com.mycompany.model.ClienteDAO;
import com.mycompany.model.Proveedor;
import com.mycompany.model.ProveedorDAO;
import com.mycompany.vista.FrmPrincipal;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author krate
 */
public class InicioController {

    private FrmPrincipal frm;
    private ClienteDAO clienteDAO;
    private ProveedorDAO proveedorDAO;

    InicioController(FrmPrincipal frm) {
        this.frm = frm;
        initEventos();
        rellenarclienteTable();
        rellenarProveedores();

    }

    private void initEventos() {
        frm.getBtnSdInicio().addActionListener(e -> {
            limpiarTablas();
            System.out.print("Limpiecito");
            rellenarclienteTable();
            rellenarProveedores();
        });
    }

    private void rellenarclienteTable() {
        
        // 1. Definir las columnas
        String[] columnas = {"Nombre", "Telefono", "Direccion"};

        // 2. Crear el modelo
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // 3. Obtener los datos desde el DAO
        ClienteDAO dao = new ClienteDAO();
        // Suponiendo que tu DAO tiene un método que devuelve List<Cliente>
        List<Cliente> lista = dao.readAll();

        // 4. Llenar el modelo con un bucle
        for (Cliente c : lista) {
            Object[] fila = {
                c.getNombre(),
                c.getTelefono(),
                c.getDireccion()
            };
            modelo.addRow(fila);
        }

        // 5. Asignar el modelo a la tabla
        frm.getjTable2().setModel(modelo);
    }

    public void rellenarProveedores() {
        // 1. Definir las columnas
        String[] columnas = {"Nombre", "Telefono", "Direccion"};

        // 2. Crear el modelo
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // 3. Obtener los datos (Suponiendo que tienes un ProveedorDAO similar al de Cliente)
        ProveedorDAO dao = new ProveedorDAO();
        List<Proveedor> lista = dao.listarTodos(); // Método que ejecuta SELECT * FROM proveedor

        // 4. Cargar los datos en el modelo
        for (Proveedor p : lista) {
            Object[] fila = {
                p.getNombre(),
                p.getTelefono(),
                p.getDireccion()
            };
            modelo.addRow(fila);
        }

        // 5. Asignar el modelo a la tabla
        frm.getjTable1().setModel(modelo);
    }

    public void limpiarTablas() {
        // Obtenemos el modelo de la tabla 1 (Proveedores) y reseteamos filas
        DefaultTableModel modelo1 = (DefaultTableModel) frm.getjTable1().getModel();
        modelo1.setRowCount(0);

        // Obtenemos el modelo de la tabla 2 (Clientes) y reseteamos filas
        DefaultTableModel modelo2 = (DefaultTableModel) frm.getjTable2().getModel();
        modelo2.setRowCount(0);
    }

}
