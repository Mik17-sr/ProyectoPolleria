package com.mycompany.controller;

import com.mycompany.Utility.ComboHelper;
import com.mycompany.Utility.PlaceholderUtil;
import com.mycompany.model.Cliente;
import com.mycompany.model.ClienteDAO;
import com.mycompany.model.Pago;
import com.mycompany.model.PagoDAO;
import com.mycompany.vista.FrmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mycompany.model.Venta;
import com.mycompany.model.VentaDAO;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VentaController implements ActionListener {

    private int idVenta;//quedo feo pero no se donde mas meterlo para que quede global
    private boolean metodo;
    private FrmPrincipal frm;
    private List<Cliente> clientes;
    private ClienteDAO clDAO;
    private VentaDAO vtDAO;
    private List<Venta> ventas;
    NumberFormat formatoCOP;

    public VentaController() {
        super();
    }

    public VentaController(FrmPrincipal frm) {
        idVenta = -1;
        this.frm = frm;
        this.clientes = new ArrayList<>();
        this.ventas = new ArrayList<>();
        this.clDAO = new ClienteDAO();
        this.vtDAO = new VentaDAO();
        this.formatoCOP = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
        formatoCOP.setMaximumFractionDigits(0);
        frm.getBtnAddVenta().addActionListener(this);
        frm.getBtnRegistrarVenta().addActionListener(this);
        frm.getCmbRegVentaClient().addActionListener(this);
        frm.getCmbMetodoPago1().addActionListener(this);
        initEventos();
        rellenarcasillas();
        escucharcheck();
        frm.getChbPagoCompleto().setSelected(true);

    }

    public FrmPrincipal getFrm() {
        return frm;
    }

    public void setFrm(FrmPrincipal frm) {
        this.frm = frm;
    }

    private void initEventos() {
        frm.getBtnSdRegVenta().addActionListener(e -> {
            cargarClientes();
            listarComboVentas();
            habilitarBotonRegVenta();
            setFechaHoy();
        });
        frm.getBtnSdVerVentas().addActionListener(e -> {
            cargarVentas();
            listarTablaVentas();
            habilitarBotonRegVenta();
            setFechaHoy();
        });
    }

    private void habilitarBotonRegVenta() {
        if (!clientes.isEmpty() && frm.getCmbRegVentaClient().getSelectedIndex() != 0) {
            frm.getBtnRegistrarVenta().setEnabled(true);
        } else {
            frm.getBtnEditClient().setEnabled(false);
        }
    }

    private void listarComboVentas() {
        DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>();
        if (clientes.isEmpty()) {
            model.addElement("No hay clientes para elegir");
            frm.getCmbRegVentaClient().setEnabled(false);
        } else {
            model.addElement("Seleccione un cliente");
            for (Cliente c : clientes) {
                model.addElement(c);
            }
            frm.getCmbRegVentaClient().setEnabled(true);
        }
        frm.getCmbRegVentaClient().setModel(model);
        frm.getCmbRegVentaClient().setSelectedIndex(0);
        ComboHelper.habilitarFiltradoC(frm.getCmbRegVentaClient(), clientes);
        frm.getCmbRegVentaClient().setEditable(true);
    }

    private void listarTablaVentas() {
        DefaultTableModel model = (DefaultTableModel) frm.getTblVentas().getModel();
        model.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        NumberFormat formatoCOP = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
        formatoCOP.setMaximumFractionDigits(0);
        double totalVentas = 0;
        for (Venta v : ventas) {
            totalVentas += v.getPrecio();
            model.addRow(new Object[]{
                v.getCliente().getNombre(),
                sdf.format(v.getFecha()),
                formatoCOP.format(v.getPrecio()),
                v.getObservacion()
            });
        }
        frm.getLblTotalVentas().setText(formatoCOP.format(totalVentas));
    }

    private void cargarClientes() {
        clientes = clDAO.readAll();
    }

    private void cargarVentas() {
        ventas = vtDAO.readAll();
    }

    private void resetTextFields(Container con) {
        for (Component c : con.getComponents()) {
            if (c instanceof JTextField) {
                ((JTextField) c).setText("");
            } else if (c instanceof JTextArea) {
                ((JTextArea) c).setText("");
            } else if (c instanceof Container) {
                resetTextFields((Container) c);
            }
        }
    }

    private void rellenarcasillas() {
        PlaceholderUtil.placeholder(frm.getTxtObservacionesVenta(), "Digite las observaciones de la venta (Opcional)");
    }

    public void setFechaHoy() {
        frm.getDateFechaVenta().setDate(new Date());
    }

    public void mostrarAlerta(String alerta, String campo) {
        JOptionPane.showMessageDialog(frm, alerta, campo, JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(frm.getCmbRegVentaClient())) {
            Object selected = frm.getCmbRegVentaClient().getSelectedItem();
            if (selected instanceof Cliente) {
                setFechaHoy();
                frm.getBtnRegistrarVenta().setEnabled(true);
            } else {
                setFechaHoy();
                frm.getBtnRegistrarVenta().setEnabled(false);
                return;
            }
        }

        if (e.getSource().equals(frm.getBtnRegistrarVenta())) {
            if (!registrarventa()) {
                System.out.print("Erro en registrar venta");
                return;
            }
            if (metodo) {
                if (!registrarPago()) {
                    System.out.print("Erro en registrar Pago");
                    return;
                }
            }

        }

        if (e.getSource().equals(frm.getBtnAddVenta())) {
            CardLayout card = (CardLayout) frm.getPnlCards().getLayout();
            card.show(frm.getPnlCards(), "REG_CLIENT");
        }
    }

    //modificado por krate
    private void escucharcheck() {
        JRadioButton contado = frm.getChbPagoCompleto();
        JRadioButton credito = frm.getChbPagoCredito();
        contado.addItemListener(e -> {
            metodo = (e.getStateChange() == ItemEvent.SELECTED);//contado true; credito false           
            frm.getCmbMetodoPago1().setEditable(true);
            frm.getCmbMetodoPago1().setVisible(true);
            frm.getLblMetodoPago().setVisible(true);

            frm.getCmbFechaVencimiento().setVisible(false);
            frm.getLblFechaVencimiento().setVisible(false);

        });
        credito.addItemListener(e -> {
            metodo = !(e.getStateChange() == ItemEvent.SELECTED);//contado true; credito false           
            frm.getCmbMetodoPago1().setEditable(false);
            frm.getCmbMetodoPago1().setVisible(false);
            frm.getLblMetodoPago().setVisible(false);

            frm.getCmbFechaVencimiento().setVisible(true);
            frm.getLblFechaVencimiento().setVisible(true);

        });

    }

    private boolean registrarventa() {
        Cliente selected = (Cliente) frm.getCmbRegVentaClient().getSelectedItem();
        Venta venta = new Venta();
        venta.setCliente(selected);
        Date fecha = frm.getDateFechaVenta().getDate();
        if (fecha != null) {
            venta.setFecha(fecha);
        } else {
            mostrarAlerta("Debe ingresar una fecha válida", "Fecha Venta");
            return false;
        }
        double precioVenta = ((Number) frm.getTxtPrecioVenta().getValue()).doubleValue();
        if (precioVenta > 0) {
            venta.setPrecio(precioVenta);
        } else {
            mostrarAlerta("Debe ingresar un precio de venta válido", "Precio Venta");
        }

        if (frm.getTxtObservacionesVenta().getText().equals("Digite las observaciones de la venta (Opcional)")) {
            venta.setObservacion("");
        } else {
            venta.setObservacion(frm.getTxtObservacionesVenta().getText());
        }

        int opcion = JOptionPane.showConfirmDialog(
                frm,
                "¿Está seguro de Registrar la venta por monto: " + formatoCOP.format(venta.getPrecio()) + " ?",
                "Confirmación de registro",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        if (opcion == JOptionPane.YES_OPTION) {
            if (vtDAO.create(venta)) {

                idVenta = venta.getId();
            }
        } else {
            return false;
        }
        return true;
    }

    private boolean registrarPago() {
        PagoDAO pagoDAO = new PagoDAO();
        if (idVenta == -1) {
            return false;
        }
        Venta venta = vtDAO.read2(idVenta);
        ArrayList<Pago> pagos = (ArrayList<Pago>) pagoDAO.readAllByVenta(idVenta);
        System.out.println(idVenta);
        venta.setPagos(pagos);
        double montoPago = ((Number) frm.getTxtPrecioVenta().getValue()).doubleValue();
        if (montoPago <= 0) {
            mostrarAlerta("El monto no puede ser 0", "Monto de pago");
            return false;
        }
        if (montoPago + venta.calcularMontoPagos() > venta.getPrecio()) {
            mostrarAlerta("El monto se excede, el pago maximo es: " + formatoCOP.format(venta.getPrecio() - venta.calcularMontoPagos()), "Monto de Pago");
            return false;
        }
        Pago pago = new Pago();
        Date fechaPago = frm.getDateFechaVenta().getDate();
        if (fechaPago != null) {
            pago.setFechaPago(fechaPago);
        } else {
            mostrarAlerta("Debe ingresar una fecha válida", "Fecha Pago");
            return false;
        }
        pago.setMonto(montoPago);

        if (frm.getTxtObservacionesVenta().getText().equals("Digite las observaciones del pago (Opcional)") || frm.getTxtObservacionesPago().getText().isBlank()) {
            pago.setObservaciones("");
        } else {
            pago.setObservaciones(frm.getTxtObservacionesVenta().getText());
        }
        pago.setVenta(venta);
        int opcion = JOptionPane.showConfirmDialog(
                frm,
                "¿Está seguro de Registrar el pago por monto: " + formatoCOP.format(pago.getMonto()) + " ?",
                "Confirmación de registro",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        if (opcion == JOptionPane.YES_OPTION) {
            if (pagoDAO.create(pago)) {
                listarComboVentas();
            }
        } else {
            return false;
        }
        return true;
    }

}
