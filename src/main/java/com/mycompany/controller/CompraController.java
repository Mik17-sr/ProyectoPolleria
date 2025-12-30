package com.mycompany.controller;

import com.mycompany.Utility.ComboHelper;
import com.mycompany.model.CompraDAO;
import com.mycompany.Utility.PlaceholderUtil;
import com.mycompany.model.Compra;
import com.mycompany.model.Proveedor;
import com.mycompany.model.proveedorDAO;
import com.mycompany.vista.FrmPrincipal;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CompraController implements ActionListener {

    private FrmPrincipal frm;
    private CompraDAO ob;
    private static final SimpleDateFormat FORMATO_FECHA
            = new SimpleDateFormat("yyyy-MM-dd");

    public CompraController(FrmPrincipal frm) {
        this.frm = frm;
        ob = new CompraDAO();
        frm.getBtnregistrarcompra().addActionListener(e -> registrar());
        frm.getBtnagrProvRegistraraComp().addActionListener(e -> frm.mostrarCard(FrmPrincipal.CARD_REG_PROV));
        frm.getBtnSdVerCompras().addActionListener(e -> mostrarCompras());
        ProveedorController.rellenarcombox(frm);
        proveedorDAO dao = new proveedorDAO();
        List<Proveedor> lista = dao.listarTodos();
        ComboHelper.habilitarFiltrado(frm.getCmbcompraReg(), lista);
        setFechaHoy();
        rellenarcasillas();
        frm.getCmbcompraReg().setEditable(true);

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

        // Debug en consola
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

        // 3. Crear el modelo
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // 4. Configuración de Formatos (Fecha y Moneda COP)
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.text.NumberFormat formatoCOP = java.text.NumberFormat.getCurrencyInstance(new java.util.Locale("es", "CO"));
        formatoCOP.setMaximumFractionDigits(0); // Para que no muestre decimales si es COP

        double total = 0;

        // 5. Llenar el modelo con la lista
        for (Compra c : listCompras) {
            total += c.getPrecio();

            // Formatear fecha
            String fechaFormateada = (c.getFecha() != null) ? sdf.format(c.getFecha()) : "";

            // Formatear precio a moneda
            String precioFormateado = formatoCOP.format(c.getPrecio());

            Object[] fila = {
                c.getProveedor(),
                fechaFormateada,
                precioFormateado, // <--- Ahora se pasa el String con formato $
                c.getObservacion()
            };
            modelo.addRow(fila);
        }

        // 6. Asignar el modelo y el total formateado
        frm.getTblCompras().setModel(modelo);
        frm.getLblTotalCompras().setText(formatoCOP.format(total));
    }

}
