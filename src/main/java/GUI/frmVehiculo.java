/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.IVehiculoDAO;
import Entidades.Persona;
import Entidades.Vehiculo;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Frame de registro de vehiculos
 * @author dany
 */
public class frmVehiculo extends javax.swing.JFrame {
    
    /**
     * Objeto de tipo IVehiculoDAO
     */
    private final IVehiculoDAO vehiculoDAO;
    
    /**
     * Objeto de tipo persona
     */
    private Persona persona;

    /**
     * Método constructor que inicializa los atributos
     *
     * @param vehiculoDAO vehiculoDAO
     */
    public frmVehiculo(IVehiculoDAO vehiculoDAO) {
        initComponents();
        this.vehiculoDAO = vehiculoDAO;
    }

    /**
     * Constructor utilizado para devolver el rfc de la persona a la cual se le
     * esta registrando el vehículo
     *
     * @param vehiculoDAO vehículoDAO
     * @param persona persona
     */
    public frmVehiculo(IVehiculoDAO vehiculoDAO, Persona persona) {
        initComponents();
        this.vehiculoDAO = vehiculoDAO;
        this.persona = persona;
        txtDueño.setText(persona.getRfc());
    }

    /**
     * Método que agrega la licencia a la bd
     */
    public void agregar() {
        String tipo = (String) cbTipo.getSelectedItem();
        Vehiculo vehiculo = new Vehiculo(txtNumero.getText(), txtMarca1.getText(), txtModelo.getText(), txtLinea.getText(), txtColor.getText(), tipo, txtEstado.getText(), persona);
        if (vehiculoDAO.agregarVehiculo(vehiculo) == null) {
            JOptionPane.showMessageDialog(this, "No se pudo registrar el vehículo");
        } else {

            JOptionPane.showMessageDialog(this, "Registro exitoso");
            frmMenuPrincipal principal = new frmMenuPrincipal(persona);
            principal.setVisible(true);
            this.dispose();
        }

    }

    /**
     * Método que valida de manera que solo permite letras y espacio
     *
     * @param evento evt
     */
    public void validarMarca(java.awt.event.KeyEvent evento) {
        if (evento.getKeyChar() >= 33 && evento.getKeyChar() <= 64
                || evento.getKeyChar() >= 91 && evento.getKeyChar() <= 96
                || evento.getKeyChar() >= 123 && evento.getKeyChar() <= 127) {

            evento.consume();
        }
    }

    /**
     * Metodo que valida que el numero de serie no se repita con alguno ya registrado
     *
     * @return true o false
     */
    public boolean validarNumero() {
        List<Vehiculo> vehiculoL = vehiculoDAO.listaVehiculo();
        for (Vehiculo vehiculo : vehiculoL) {
            if (txtNumero.getText().equalsIgnoreCase(vehiculo.getNumero())) {
                JOptionPane.showMessageDialog(this, "El numero de serie ya existe");
                return false;
            }
        }
        return true;

    }
    
    /**
     * Metodo que se encarga de validar que todos los campos esten
     * llenos
     * @return true or false 
     */
   private boolean validarVacios() {
    if (txtColor.getText().equals("")
                || txtDueño.getText().equals("")
                || txtNumero.getText().equals("")
                || txtLinea.getText().equals("")
                || txtModelo.getText().equals("")
                || txtMarca1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Favor de llenar los campos faltantes", "Informacion", JOptionPane.INFORMATION_MESSAGE);

            return false;
        }
    return true;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        cbTipo = new javax.swing.JComboBox<>();
        txtNumero = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtLinea = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        txtEstado = new javax.swing.JTextField();
        txtDueño = new javax.swing.JTextField();
        txtMarca1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Automovil" }));
        cbTipo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204), 2));
        jPanel1.add(cbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 210, -1));

        txtNumero.setForeground(new java.awt.Color(204, 204, 204));
        txtNumero.setText("Ingrese el número de serie");
        txtNumero.setBorder(null);
        txtNumero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNumeroMousePressed(evt);
            }
        });
        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroKeyTyped(evt);
            }
        });
        jPanel1.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 170, -1));

        txtModelo.setForeground(new java.awt.Color(204, 204, 204));
        txtModelo.setText("Ingrese el modelo");
        txtModelo.setBorder(null);
        txtModelo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtModeloMousePressed(evt);
            }
        });
        txtModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtModeloKeyTyped(evt);
            }
        });
        jPanel1.add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 140, -1));

        txtLinea.setForeground(new java.awt.Color(204, 204, 204));
        txtLinea.setText("Ingrese la línea");
        txtLinea.setBorder(null);
        txtLinea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtLineaMousePressed(evt);
            }
        });
        txtLinea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLineaKeyTyped(evt);
            }
        });
        jPanel1.add(txtLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 90, -1));

        txtColor.setForeground(new java.awt.Color(204, 204, 204));
        txtColor.setText("Ingrese el color");
        txtColor.setBorder(null);
        txtColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtColorMousePressed(evt);
            }
        });
        txtColor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtColorKeyTyped(evt);
            }
        });
        jPanel1.add(txtColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 150, -1));

        btnRegresar.setBackground(new java.awt.Color(0, 153, 204));
        btnRegresar.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setOpaque(true);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(0, 153, 204));
        btnCancelar.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setOpaque(true);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, -1, -1));

        btnAceptar.setBackground(new java.awt.Color(0, 153, 204));
        btnAceptar.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.setContentAreaFilled(false);
        btnAceptar.setOpaque(true);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, -1, -1));

        txtEstado.setEditable(false);
        txtEstado.setText("Nuevo");
        txtEstado.setBorder(null);
        jPanel1.add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 230, -1));

        txtDueño.setEditable(false);
        txtDueño.setBorder(null);
        jPanel1.add(txtDueño, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 230, -1));

        txtMarca1.setForeground(new java.awt.Color(204, 204, 204));
        txtMarca1.setText("Ingrese la marca");
        txtMarca1.setBorder(null);
        txtMarca1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtMarca1MousePressed(evt);
            }
        });
        txtMarca1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMarca1KeyTyped(evt);
            }
        });
        jPanel1.add(txtMarca1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 130, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/city.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, -1, -1));

        jLabel11.setFont(new java.awt.Font("Roboto Medium", 1, 36)); // NOI18N
        jLabel11.setText("REGISTRO VEHÍCULOS");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/favicon.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel13.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel13.setText("Dueño");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, -1, -1));

        jLabel14.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel14.setText("Tipo de vehículo");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        jLabel15.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel15.setText("Número de serie");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        jLabel16.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel16.setText("Marca");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        jLabel17.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel17.setText("Modelo");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        jLabel18.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel18.setText("Línea");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));

        jLabel19.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel19.setText("Color");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, -1, -1));

        jLabel20.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel20.setText("Estado");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 230, 20));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 210, 20));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 240, 20));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 230, 20));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 230, 20));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 230, 20));

        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 230, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Método para regresar al menu principal al dar click en el boton 
     * @param evt evt
     */
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed

        frmMenuPrincipal principal = new frmMenuPrincipal(persona);
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed
    /**
     * Método para limpiar todos lod textfields
     * @param evt evt
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        txtColor.setText("");
        txtDueño.setText("");
        txtEstado.setText("");
        txtLinea.setText("");
        txtNumero.setText("");
        txtModelo.setText("");
        txtMarca1.setText("");

    }//GEN-LAST:event_btnCancelarActionPerformed
    /**
     * Método que al dar click en el boton hace la acción de agregar el vehículo
     * a la bd
     *
     * @param evt evt
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here
        if (validarVacios()){
            if(validarNumero()){
                this.agregar();
            }
        }
        
    }//GEN-LAST:event_btnAceptarActionPerformed
    /**
     * Método que valida el campo de numero de serie
     *
     * @param evt evt
     */
    private void txtNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyTyped
        
        char c = evt.getKeyChar();

        if ((c < '0' || c > '9') && (c < 'A') | c > 'Z') {
            evt.consume();
        }
        
        if(txtNumero.getText().length()==12){
            evt.consume();
        }
    }//GEN-LAST:event_txtNumeroKeyTyped
    /**
     * Método que llama al metodo validarMarca para realizar obvios trabajos 
     * @param evt evt
     */
    private void txtMarca1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarca1KeyTyped
        validarMarca(evt);
    }//GEN-LAST:event_txtMarca1KeyTyped
    /**
     * Método utilizado para validar el txt de modelo (solo números) 
     * @param evt evt
     */
    private void txtModeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloKeyTyped
        char c = evt.getKeyChar();
        
        if((c<'0' || c>'9'))evt.consume();
        
        if (txtModelo.getText().length() == 4) {
            evt.consume();
        }
    }//GEN-LAST:event_txtModeloKeyTyped
    /**
     * Método utilizado para validar el txt de Linea 
     * @param evt evt
     */
    private void txtLineaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLineaKeyTyped

        validarMarca(evt);
    }//GEN-LAST:event_txtLineaKeyTyped
    /**
     * Método utilizado para validar el txt de color 
     * @param evt evt
     */
    private void txtColorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColorKeyTyped
        validarMarca(evt);
    }//GEN-LAST:event_txtColorKeyTyped
    /**
     * Método para aparentar un placeholder
     * @param evt evt
     */
    private void txtNumeroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNumeroMousePressed
        txtNumero.setText("");
        txtNumero.setForeground(Color.black);
    }//GEN-LAST:event_txtNumeroMousePressed
    /**
     * Método para aparentar un placeholder
     * @param evt evt
     */
    private void txtMarca1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMarca1MousePressed
       txtMarca1.setText("");
       txtMarca1.setForeground(Color.black);
    }//GEN-LAST:event_txtMarca1MousePressed
    /**
     * Método para aparentar un placeholder
     * @param evt evt
     */
    private void txtModeloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtModeloMousePressed
       txtModelo.setText("");
       txtModelo.setForeground(Color.black);
    }//GEN-LAST:event_txtModeloMousePressed
    /**
     * Método para aparentar un placeholder
     * @param evt evt
     */
    private void txtLineaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLineaMousePressed
       txtLinea.setText("");
       txtLinea.setForeground(Color.black);
    }//GEN-LAST:event_txtLineaMousePressed
    /**
     * Método para aparentar un placeholder
     * @param evt evt
     */
    private void txtColorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtColorMousePressed
       txtColor.setText("");
       txtColor.setForeground(Color.black);
    }//GEN-LAST:event_txtColorMousePressed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtDueño;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtMarca1;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
