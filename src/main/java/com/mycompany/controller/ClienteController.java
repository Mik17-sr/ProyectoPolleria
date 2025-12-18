package com.mycompany.controller;

import com.mycompany.vista.FrmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mycompany.model.Cliente;
import com.mycompany.model.ClienteDAO;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ClienteController implements ActionListener{
    private FrmPrincipal frm;
    private List<Cliente> clientes;
    private ClienteDAO clDAO;

    public ClienteController() {
        super();
    }
    
    public ClienteController(FrmPrincipal frm) {
        this.frm = frm;
        this.clientes = new ArrayList<>();
        this.clDAO = new ClienteDAO();
        frm.getBtnEditClient().setEnabled(false);
        frm.getBtnRegistrarCliente().addActionListener(this);
        frm.getBtnEditClient().addActionListener(this);
        frm.getCmbCliente().addActionListener(this);
        frm.getBtnAddVenta().addActionListener(this);
        frm.getBtnRegistrarVenta().addActionListener(this);
        initEventos();
    }

    public FrmPrincipal getFrm() {
        return frm;
    }

    public void setFrm(FrmPrincipal frm) {
        this.frm = frm;
    }
    
    public void mostrarAlerta(String alerta, String campo){
        JOptionPane.showMessageDialog(frm, alerta, campo, JOptionPane.WARNING_MESSAGE);
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
    
    private void initEventos(){
        frm.getBtnSdEditClient().addActionListener(e -> {
            cargarClientes();
            listarCombo();
            habilitarBotonEdit();
        });
    }
    
    private void cargarClientes(){
        clientes = clDAO.readAll();
    }
    
    private void habilitarBotonEdit(){
        if(!clientes.isEmpty() && frm.getCmbCliente().getSelectedIndex() != 0){
            frm.getBtnEditClient().setEnabled(true);
        }else{
            frm.getBtnEditClient().setEnabled(false);
        }
    }
    
    private void listarCombo(){
        DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>();
        if(clientes.isEmpty()){
            model.addElement("No hay clientes para elegir");
            frm.getCmbCliente().setEnabled(false);
        }else{
            model.addElement("Seleccione un cliente");
            for(Cliente c : clientes){
                model.addElement(c);
            }
            frm.getCmbCliente().setEnabled(true);
        }
        
        frm.getCmbCliente().setModel(model);
        if(!clientes.isEmpty()) {
            frm.getCmbCliente().setSelectedIndex(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(frm.getBtnRegistrarCliente())){
            Cliente client = new Cliente();
            client.setNombre(frm.getTxtNombreCliente().getText());
            String telefono = frm.getTxtTelefonoCliente().getText();
            if(telefono.matches("\\d+")){
                client.setTelefono(telefono);
            }else{
                mostrarAlerta("El teléfono solo debe contener números", "Teléfono");
                return;
            }
            client.setDireccion(frm.getTxtDireccionCliente().getText());
            int opcion = JOptionPane.showConfirmDialog(
                frm, 
                "¿Está seguro de registrar al Cliente: " + client.getNombre() + "?",
                "Confirmación de registro",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );
            System.out.println("Cojone");
            
            if(opcion == JOptionPane.YES_OPTION){
                if(clDAO.create(client)){
                    JOptionPane.showMessageDialog(frm, "Cliente: " + client.getNombre() + "\nRegistrado Correctamente", "Cliente", JOptionPane.INFORMATION_MESSAGE);
                    resetTextFields(frm.getRegistrarCliente());
                }
            }else{
                return;
            }
        }
        
        if(e.getSource().equals(frm.getCmbCliente())){
            Object selected = frm.getCmbCliente().getSelectedItem();
            if(!(selected instanceof Cliente)){
                resetTextFields(frm.getEditarCliente());
                frm.getBtnEditClient().setEnabled(false);
                return;
            }
            Cliente cliente = (Cliente) selected;
            frm.getTxtEditNameCliente().setText(cliente.getNombre());
            frm.getTxtEditTelefonoCliente().setText(cliente.getTelefono());
            frm.getTxtEditDirCliente().setText(cliente.getDireccion());
            frm.getBtnEditClient().setEnabled(true);
        }
        
        if(e.getSource().equals(frm.getBtnEditClient())){
            Cliente selected = (Cliente) frm.getCmbCliente().getSelectedItem();
            Cliente clienteActualizado = new Cliente();
            clienteActualizado.setIdCliente(selected.getIdCliente());
            clienteActualizado.setNombre(frm.getTxtEditNameCliente().getText());
            String telefono = frm.getTxtEditTelefonoCliente().getText();
            if(telefono.matches("\\d+")){
                clienteActualizado.setTelefono(telefono);
            }else{
                mostrarAlerta("El teléfono solo debe contener números", "Teléfono");
                return;
            }
            clienteActualizado.setDireccion(frm.getTxtEditDirCliente().getText());
            int opcion = JOptionPane.showConfirmDialog(
                frm, 
                "¿Está seguro de actualizar al Cliente: " + clienteActualizado.getNombre() + "?",
                "Confirmación de actualización",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );
            
            if(opcion == JOptionPane.YES_OPTION){
                if(clDAO.update(clienteActualizado)){
                    JOptionPane.showMessageDialog(frm, "Cliente: " + clienteActualizado.getNombre() + "\nActualizado Correctamente", "Cliente", JOptionPane.INFORMATION_MESSAGE);
                    frm.getCmbCliente().setSelectedIndex(0);
                    resetTextFields(frm.getEditarCliente());
                    cargarClientes();
                    listarCombo();
                }
            }else{
                return;
            }
        }
        
        if(e.getSource().equals(frm.getBtnRegistrarVenta())){
            
        }
        
        if(e.getSource().equals(frm.getBtnAddVenta())){
            CardLayout card = (CardLayout) frm.getPnlCards().getLayout();
            card.show(frm.getPnlCards(), "REG_CLIENT");
        }
    }
}
