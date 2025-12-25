package com.mycompany.controller;

import com.mycompany.Utility.PlaceholderUtil;
import com.mycompany.vista.FrmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import com.mycompany.model.Venta;
import com.mycompany.model.VentaDAO;
import com.mycompany.model.Pago;
import com.mycompany.model.PagoDAO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PagoController implements ActionListener {
    private FrmPrincipal frm;
    private List<Venta> ventas;
    private VentaDAO vtDAO;
    PagoDAO pagoDAO;
    NumberFormat formatoCOP;
    
    public PagoController(FrmPrincipal frm){
        this.frm = frm;
        this.ventas = new ArrayList();
        this.vtDAO = new VentaDAO();
        this.pagoDAO = new PagoDAO();
        this.formatoCOP = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
        formatoCOP.setMaximumFractionDigits(0);
        frm.getCmbVentaPago().addActionListener(this);
        frm.getBtnRegistrarPago().addActionListener(this);
        initEventos();
        rellenarcasillas();
    }
    
    private void initEventos(){
        frm.getBtnSdInsertarPago().addActionListener(e -> {
            cargarVentas();
            listarComboVentas();
            setFechaHoy();
            habilitarInsVenta();
        });
    }
    
    private void cargarVentas(){
        ventas = vtDAO.readAll();
    }
    
    private void listarComboVentas(){
        DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>();
        if(ventas.isEmpty()){
            model.addElement("No hay ventas para elegir");
            frm.getCmbVentaPago().setEnabled(false);
        }else{
            model.addElement("Seleccione una venta");
            for(Venta v : ventas){
                v.setPagos((ArrayList<Pago>) pagoDAO.readAllByVenta(v.getId()));
                if(!v.validarMontoPago()){
                    model.addElement(v);
                }
            }
            frm.getCmbVentaPago().setEnabled(true);
        }
        frm.getCmbVentaPago().setModel(model);
        frm.getCmbVentaPago().setSelectedIndex(0);
    }
    
    private void habilitarInsVenta(){
        if(!ventas.isEmpty() && frm.getCmbVentaPago().getSelectedIndex() != 0){
            frm.getInsPago().setEnabled(true);
        }else{
            frm.getBtnEditClient().setEnabled(false);
        }
    }
    
    
    private void resetTextFields(Container con){
        for(Component c : con.getComponents()){
            if(c instanceof JTextField){
                ((JTextField) c).setText("");
            }else if(c instanceof JTextArea){
                ((JTextArea) c).setText("");
            }else if(c instanceof Container){
                resetTextFields((Container) c);
            }
        }
    }
    
     public void cambiarFuenteGrisClaro(){
        frm.getLblTotalVenta().setForeground(Color.decode("#757575"));
        frm.getLblTotalPagado().setForeground(Color.decode("#757575"));
        frm.getLblSaldoPendiente().setForeground(Color.decode("#757575"));  
        frm.getLblTotalVenta().setText("$--.--");
        frm.getLblTotalPagado().setText("$--.--");
        frm.getLblSaldoPendiente().setText("$--.--");
    }
    
    public void cambiarFuenteOscura(){
        frm.getLblTotalVenta().setForeground(Color.decode("#4F4F4F"));
        frm.getLblTotalPagado().setForeground(Color.decode("#4F4F4F"));
        frm.getLblSaldoPendiente().setForeground(Color.decode("#f57900"));   
    }
    
    public void setFechaHoy() {
        frm.getDateFechaPago().setDate(new Date());
    }
    
    public void mostrarAlerta(String alerta, String campo){
        JOptionPane.showMessageDialog(frm, alerta, campo, JOptionPane.WARNING_MESSAGE);
    }
    
    private void rellenarcasillas() {
        PlaceholderUtil.placeholder(frm.getTxtObservacionesPago(), "Digite las observaciones del pago (Opcional)");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(frm.getCmbVentaPago())){
            Object selected = frm.getCmbVentaPago().getSelectedItem();
            if(!(selected instanceof Venta)){
                cambiarFuenteGrisClaro();
                frm.getBtnRegistrarPago().setEnabled(false);
                setFechaHoy();
                return;
            }
            setFechaHoy();
            frm.getBtnRegistrarPago().setEnabled(true);
            cambiarFuenteOscura();
            Venta venta = (Venta) selected;
            frm.getLblTotalVenta().setText("" + formatoCOP.format(venta.getPrecio()));
            ArrayList<Pago> pagos = (ArrayList<Pago>) pagoDAO.readAllByVenta(venta.getId());
            venta.setPagos(pagos);
            double pagoVenta = venta.calcularMontoPagos();
            frm.getLblTotalPagado().setText("" + formatoCOP.format(pagoVenta));
            double saldoPendiente = venta.getPrecio() - pagoVenta;
            frm.getLblSaldoPendiente().setText("" + formatoCOP.format(saldoPendiente));
        }
        if(e.getSource().equals(frm.getBtnRegistrarPago())){
            Venta venta = (Venta) frm.getCmbVentaPago().getSelectedItem();
            ArrayList<Pago> pagos = (ArrayList<Pago>) pagoDAO.readAllByVenta(venta.getId());
            System.out.println(venta.getId());
            venta.setPagos(pagos);
            double montoPago = ((Number) frm.getTxtMontoPago().getValue()).doubleValue();
            if(montoPago <= 0){
                mostrarAlerta("El monto no puede ser 0", "Monto de pago");
                return;
            }
            if(montoPago + venta.calcularMontoPagos() > venta.getPrecio()){
                mostrarAlerta("El monto se excede, el pago maximo es: " + formatoCOP.format(venta.getPrecio() - venta.calcularMontoPagos()), "Monto de Pago");
                return;
            }
            Pago pago = new Pago();
            Date fechaPago = frm.getDateFechaPago().getDate();
            if(fechaPago != null){
                pago.setFechaPago(fechaPago);
            }else{
                mostrarAlerta("Debe ingresar una fecha válida", "Fecha Pago");
                return;
            }
            pago.setMonto(montoPago);
            if(frm.getCmbMetodoPago().getSelectedIndex() == 0){
                mostrarAlerta("Debe escoger un metodo de pago válido", "Metodo de Pago");
                return;
            }else{
                String metodoPago = frm.getCmbMetodoPago().getSelectedItem().toString();
                pago.setMetodoPago(metodoPago);
            }
            
            if(frm.getTxtObservacionesPago().getText().equals("Digite las observaciones del pago (Opcional)") || frm.getTxtObservacionesPago().getText().isBlank()){
                pago.setObservaciones("");
            }else{
                pago.setObservaciones(frm.getTxtObservacionesPago().getText());
            }
            pago.setVenta(venta);
            int opcion = JOptionPane.showConfirmDialog(
                frm, 
                "¿Está seguro de Registrar el pago por monto: " + formatoCOP.format(pago.getMonto()) + " ?",
                "Confirmación de registro",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );
            if(opcion == JOptionPane.YES_OPTION){
                if(pagoDAO.create(pago)){
                    JOptionPane.showMessageDialog(frm, "Pago por: " + formatoCOP.format(pago.getMonto()) + "\nRegistrado Correctamente", "Pago", JOptionPane.INFORMATION_MESSAGE);
                    frm.getCmbVentaPago().setSelectedIndex(0);
                    frm.getCmbMetodoPago().setSelectedIndex(0);
                    resetTextFields(frm.getInsPago());
                    frm.getTxtMontoPago().setText("0");
                    listarComboVentas();
                }
            }else{
                return;
            } 
        }       
    }
}
