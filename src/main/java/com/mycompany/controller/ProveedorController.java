package com.mycompany.controller;

import com.mycompany.DAO.proveedorDAO;
import com.mycompany.Utility.PlaceholderUtil;
import com.mycompany.model.Proveedor;
import com.mycompany.vista.FrmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ProveedorController implements ActionListener {

    private List<Proveedor> listaProv;
    private FrmPrincipal frm;
    private proveedorDAO ob;

    public ProveedorController(FrmPrincipal frm) {
        ob = new proveedorDAO();
        this.frm = frm;
        rellenarcasillas();
        rellenarcombox();
        frm.getBtnregistrarproveedor().addActionListener(this);
        frm.getBtnEditproveedor().addActionListener(this);
        frm.getCmbnombreEditproveedor().addActionListener(e -> cargarProveedorSeleccionado());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.getBtnregistrarproveedor()) {
            String nombre = frm.getTxtnombreproveedor().getText();
            String telefono = frm.getTxttelefonoproveedor().getText();
            String direccion = frm.getTxtdireccionproveedor().getText();
            registrar(nombre, telefono, direccion);
        }
        if (e.getSource() == frm.getCmbnombreEditproveedor()) {
            Proveedor[] lista = consulta();
        }
        if (e.getSource() == frm.getBtnEditproveedor()) {
            Proveedor prov = (Proveedor) frm.getCmbnombreEditproveedor().getSelectedItem();
            int idprovedor = prov.getIdproveedor();
            String nombre = frm.getTxtnombreEditproveedor().getText();
            String telefono = frm.getTxttelefonoEditproveedor().getText();
            String direccion = frm.getTxtdireccionEditproveedor().getText();

            actualizar(idprovedor, nombre, telefono, direccion);
        }
    }

    public void registrar(String nombre, String telefono, String direccion) {
        if (nombre == null || nombre.isBlank() || nombre.equals("Nombre obligatorio")) {
            JOptionPane.showMessageDialog(frm, "El nombre no puede estar vacío");
            return;
        }

        Proveedor prov = new Proveedor(0,
                nombre.trim(),
                telefono == null ? "" : telefono.trim(),
                direccion == null ? "" : direccion.trim());

        ob.guardar(prov);
        JOptionPane.showMessageDialog(frm, "Proveedor registrado correctamente");
        frm.getTxtnombreproveedor().setText("");
        frm.getTxttelefonoproveedor().setText("");
        frm.getTxtdireccionproveedor().setText("");
        rellenarcombox();
    }

    private void actualizar(int idprovedor, String nombre, String telefono, String direccion) {
        Proveedor editprov = new Proveedor(idprovedor, nombre, telefono, direccion);
        if (editprov.getIdproveedor() == 0) {
            return;
        }
        if (nombre == "Nombre obligatorio" || nombre.trim().equals("Nombre obligatorio") || nombre == "" || nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frm, "El nombre no puede estar vacío");
            return;
        }
        ob.actualizar(editprov);
        frm.getTxtnombreEditproveedor().setText("");
        frm.getTxttelefonoEditproveedor().setText("");
        frm.getTxtdireccionEditproveedor().setText("");
        rellenarcombox();
    }

    private void rellenarcasillas() {
        PlaceholderUtil.placeholder(frm.getTxtnombreproveedor(), "Nombre obligatorio");
        PlaceholderUtil.placeholder(frm.getTxttelefonoproveedor(), "Telefono Opcional");
        PlaceholderUtil.placeholder(frm.getTxtdireccionproveedor(), "Direccion Opcional");

    }

    private void rellenarcombox() {
        DefaultComboBoxModel<Proveedor> modelo = new DefaultComboBoxModel<>();
        proveedorDAO ob = new proveedorDAO();

        Proveedor dummy = new Proveedor();
        dummy.setIdproveedor(-1);
        dummy.setNombre("Seleccione proveedor...");
        modelo.addElement(dummy);

        List<Proveedor> lista = ob.listarTodos();

        lista.sort(Comparator.comparing(
                p -> p.getNombre().toLowerCase()
        ));

        for (Proveedor p : lista) {
            modelo.addElement(p);
        }

        frm.getCmbnombreEditproveedor().setModel(modelo);
        frm.getCmbnombreEditproveedor().setSelectedIndex(0);
    }

    private void cargarProveedorSeleccionado() {
        Proveedor p = (Proveedor) frm.getCmbnombreEditproveedor().getSelectedItem();

        if (p == null || p.getIdproveedor() == -1) {
            limpiarCamposEdicion();
            return;
        }

        frm.getTxtnombreEditproveedor().setText(p.getNombre());
        frm.getTxttelefonoEditproveedor().setText(p.getTelefono());
        frm.getTxtdireccionEditproveedor().setText(p.getDireccion());
    }

    private void limpiarCamposEdicion() {
        frm.getTxtnombreEditproveedor().setText("");
        frm.getTxttelefonoEditproveedor().setText("");
        frm.getTxtdireccionEditproveedor().setText("");
    }
}
