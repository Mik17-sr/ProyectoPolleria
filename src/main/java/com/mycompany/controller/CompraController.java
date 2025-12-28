package com.mycompany.controller;

import com.mycompany.model.CompraDAO;
import com.mycompany.Utility.PlaceholderUtil;
import com.mycompany.model.Compra;
import com.mycompany.model.Proveedor;
import com.mycompany.vista.FrmPrincipal;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CompraController implements ActionListener {

    private FrmPrincipal frm;
    private CompraDAO ob;

    public CompraController(FrmPrincipal frm) {
        this.frm = frm;
        ob = new CompraDAO();
        frm.getBtnregistrarcompra().addActionListener(e -> registrar());
        frm.getBtnagrProvRegistraraComp().addActionListener(e -> frm.mostrarCard(FrmPrincipal.CARD_REG_PROV));
        frm.getBtnSdVerCompras().addActionListener(e -> mostrarCompras());
        ProveedorController.rellenarcombox(frm);
        setFechaHoy();
        rellenarcasillas();
    }

    public void registrar() {
        Proveedor prov = new Proveedor();
        prov = (Proveedor) frm.getCmbcompraReg().getSelectedItem();
        if (prov.getIdproveedor() != -1) {
            if (frm.getjDatefechaCompra().getDate() == null) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha");
                return;
            }
            Date fechaUtil = frm.getjDatefechaCompra().getDate();
            java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime());

//            if (frm.getTxtpreciocompra().getText() == null || !validacion.esDouble(frm.getTxtpreciocompra().getText())) {
//                JOptionPane.showMessageDialog(null, "Valor de precio no aceptado");
//                return;
//            }
            double precio = ((Number) frm.getTxtPrecioCompra().getValue()).doubleValue();

            if (precio < 0) {
                JOptionPane.showMessageDialog(null, "Precio no valido");
                return;
            }

            String observaciones = frm.getTxtobservacionescompra().getText();
            System.out.print(precio);
            Compra compra = new Compra(prov, 0, precio, fechaSql, observaciones);
            ob.guardar(compra);
            setFechaHoy();
            frm.getCmbcompraReg().setSelectedIndex(0);
            rellenarcasillas();
            ProveedorController.rellenarcombox(frm);
        } else {
            return;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e
    ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setFechaHoy() {
        JDateChooser dateChooser = frm.getjDatefechaCompra();
        dateChooser.setDate(new Date());
    }

    private void rellenarcasillas() {
        PlaceholderUtil.placeholder(frm.getTxtobservacionescompra(), "No es obligatorio ");
    }

    private void redirigir() {

    }

    private void mostrarCompras() {
        // 1. Obtener los datos
        List<Compra> listCompras = ob.listarTodas();
        System.out.println("\n--- DEBUG: LISTA DE COMPRAS ---");
        for (Compra c : listCompras) {
            System.out.println("Proveedor: " + c.getProveedor()
                    + " | Fecha: " + c.getFecha()
                    + " | Precio: " + c.getPrecio());
        }
        System.out.println("Total registros: " + listCompras.size());
        System.out.println("-------------------------------\n");
        // 2. Definir columnas
        String[] columnas = {"Proveedor", "Fecha compra", "Precio Compra", "Observaciones"};

        // 3. Crear el modelo (podemos hacerlo vacío inicialmente)
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // 4. EL PASO QUE FALTA: Llenar el modelo con la lista
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");

        for (Compra c : listCompras) {
            // 2. Convierte la fecha a String (manejando posibles nulos para evitar errores)
            String fechaFormateada = (c.getFecha() != null) ? sdf.format(c.getFecha()) : "";

            Object[] fila = {
                c.getProveedor(),
                fechaFormateada, // <--- Aquí pasamos el String ya formateado
                c.getPrecio(),
                c.getObservacion()
            };
            modelo.addRow(fila);
        }

        // 5. Asignar el modelo a la tabla del formulario
        frm.getTblCompras().setModel(modelo);
    }
}
