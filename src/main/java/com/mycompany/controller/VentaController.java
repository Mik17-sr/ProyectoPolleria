package com.mycompany.controller;

import com.mycompany.Utility.PlaceholderUtil;
import com.mycompany.model.Cliente;
import com.mycompany.model.ClienteDAO;
import com.mycompany.vista.FrmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mycompany.model.Venta;
import com.mycompany.model.VentaDAO;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VentaController implements ActionListener {
    private FrmPrincipal frm;
    private List<Cliente> clientes;
    private ClienteDAO clDAO;
    private VentaDAO vtDAO;

    public VentaController() {
        super();
    }
    
    public VentaController(FrmPrincipal frm) {
        this.frm = frm;
        this.clientes = new ArrayList<>();
        this.clDAO = new ClienteDAO();
        this.vtDAO = new VentaDAO();
        frm.getBtnAddVenta().addActionListener(this);
        frm.getBtnRegistrarVenta().addActionListener(this);
        frm.getCmbRegVentaClient().addActionListener(this);
        initEventos();
        rellenarcasillas();
    }

    public FrmPrincipal getFrm() {
        return frm;
    }

    public void setFrm(FrmPrincipal frm) {
        this.frm = frm;
    }
    
    private void initEventos(){
        frm.getBtnSdRegVenta().addActionListener(e -> {
            cargarClientes();
            listarComboVentas();
            habilitarBotonRegVenta();
            setFechaHoy();
        });
    }
    
    private void habilitarBotonRegVenta(){
        if(!clientes.isEmpty() && frm.getCmbRegVentaClient().getSelectedIndex() != 0){
            frm.getBtnRegistrarVenta().setEnabled(true);
        }else{
            frm.getBtnEditClient().setEnabled(false);
        }
    }
    
    private void listarComboVentas(){
        DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>();
        if(clientes.isEmpty()){
            model.addElement("No hay clientes para elegir");
            frm.getCmbRegVentaClient().setEnabled(false);
        }else{
            model.addElement("Seleccione un cliente");
            for(Cliente c : clientes){
                model.addElement(c);
            }
            frm.getCmbRegVentaClient().setEnabled(true);
        }
        frm.getCmbRegVentaClient().setModel(model);
        frm.getCmbRegVentaClient().setSelectedIndex(0);
    }
    
    private void cargarClientes(){
        clientes = clDAO.readAll();
    }
    
    private void resetTextFields(Container con){
        for(Component c : con.getComponents()){
            if(c instanceof JTextField){
                ((JTextField) c).setText("");
            }else if(c instanceof Container){
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
    
    public void mostrarAlerta(String alerta, String campo){
        JOptionPane.showMessageDialog(frm, alerta, campo, JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(frm.getCmbRegVentaClient())){
            Object selected = frm.getCmbRegVentaClient().getSelectedItem();
            if(selected instanceof Cliente){
                setFechaHoy();
                frm.getBtnRegistrarVenta().setEnabled(true);
            }else{
                setFechaHoy();
                frm.getBtnRegistrarVenta().setEnabled(false);
                return;
            }
        }
        
        if(e.getSource().equals(frm.getBtnRegistrarVenta())){
            Cliente selected = (Cliente) frm.getCmbRegVentaClient().getSelectedItem();
            Venta venta = new Venta();   
            System.out.println(selected);
            venta.setCliente(selected);
            Date fecha = frm.getDateFechaVenta().getDate();
            if(fecha != null){
                venta.setFecha(fecha);
            }else{
                mostrarAlerta("Debe ingresar una fecha válida", "Fecha Venta");
                return;
            }
            double precioVenta = ((Number) frm.getTxtPrecioVenta().getValue()).doubleValue();
            if(precioVenta > 0){
                venta.setPrecio(precioVenta);
            }else{
                mostrarAlerta("Debe ingresar un precio de venta válido", "Precio Venta");
            }
            
            if(frm.getTxtObservacionesVenta().getText().equals("Digite las observaciones de la venta (Opcional)")){
                venta.setObservacion("");
            }else{
                venta.setObservacion(frm.getTxtObservacionesVenta().getText());
            }
            
            int opcion = JOptionPane.showConfirmDialog(
                frm, 
                "¿Está seguro de Registrar la venta ?",
                "Confirmación de registro",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );
            if(opcion == JOptionPane.YES_OPTION){
                if(vtDAO.create(venta)){
                    JOptionPane.showMessageDialog(frm, "Venta por: " + venta.getPrecio() + "\nRegistrada Correctamente", "Venta", JOptionPane.INFORMATION_MESSAGE);
                    frm.getCmbRegVentaClient().setSelectedIndex(0);
                    resetTextFields(frm.getRegistrarVenta());
                }
            }else{
                return;
            }
            
        }
        
        if(e.getSource().equals(frm.getBtnAddVenta())){
            CardLayout card = (CardLayout) frm.getPnlCards().getLayout();
            card.show(frm.getPnlCards(), "REG_CLIENT");
        }
    }
    
    
}
