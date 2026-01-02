package com.mycompany.controller;

import com.mycompany.Utility.ComboHelper;
import com.mycompany.model.proveedorDAO;
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
        rellenarcombox(frm);
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
        if (nombre == null || nombre.isBlank() || nombre.equals("Nombre (Obligatorio)")) {
            JOptionPane.showMessageDialog(frm, "El nombre no puede estar vacío");
            return;
        }

        Proveedor prov = new Proveedor(0,
                nombre.trim(),
                telefono == null ? "" : telefono.trim(),
                direccion == null ? "" : direccion.trim());

        int opcion = JOptionPane.showConfirmDialog(
                frm,
                "¿Está seguro de registrar el proveedor: " + prov.getNombre() + "?",
                "Confirmación de registro",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        System.out.println("Cojone");

        if (opcion == JOptionPane.YES_OPTION) {
            ob.guardar(prov);
            JOptionPane.showMessageDialog(frm, "Proveedor: " + prov.getNombre() + "\nRegistrado Correctamente", "Proveedor", JOptionPane.INFORMATION_MESSAGE);

        } else {
            return;
        }
        frm.getTxtnombreproveedor().setText("");
        frm.getTxttelefonoproveedor().setText("");
        frm.getTxtdireccionproveedor().setText("");
        rellenarcombox(frm);
    }

    private void actualizar(int idprovedor, String nombre, String telefono, String direccion) {
        if (frm.getCmbnombreEditproveedor().getSelectedIndex() == 0) {
            return;
        } else {
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
            rellenarcombox(frm);
        }
    }

    private void rellenarcasillas() {
        PlaceholderUtil.placeholder(frm.getTxtnombreproveedor(), "Nombre (Obligatorio)");
        PlaceholderUtil.placeholder(frm.getTxttelefonoproveedor(), "Telefono (Opcional)");
        PlaceholderUtil.placeholder(frm.getTxtdireccionproveedor(), "Direccion (Opcional)");
    }

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
            ComboHelper.habilitarFiltrado(frm.getCmbcompraReg(), lista);

            frm.getCmbnombreEditproveedor().setModel(modelo);
            frm.getCmbnombreEditproveedor().setSelectedIndex(0);

        } catch (Exception e) {
            System.err.println("Error al cargar proveedores: " + e.getMessage());
            // Aquí podrías mostrar un JOptionPane de error
        }
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
