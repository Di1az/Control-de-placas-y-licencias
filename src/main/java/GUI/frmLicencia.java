/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.ILicenciaDAO;
import Entidades.Licencia;
import Entidades.Persona;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author dany
 */
public class frmLicencia extends javax.swing.JFrame {
    
    /**
     * Objeto de tipo persona
     */
    Persona persona;
    
    /**
     * Objeto de tipo ILicenciaDAO
     */
    private ILicenciaDAO licenciaDAO;
    
    /**
     * Atributo de tipo booleano utilizado para desactivar la lista
     */
    private boolean desactivarLic ;

    /**
     * Metodo constructor que inicializa los atributos
     * @param licenciaDAO licenciaDAO 
     */
    public frmLicencia(ILicenciaDAO licenciaDAO) {
        initComponents();
        this.licenciaDAO = licenciaDAO;

    }

    /**
     * Metodo constructor
     * @param persona
     * @param licenciaDAO
     * @param desactivarLic 
     */
    public frmLicencia(Persona persona, ILicenciaDAO licenciaDAO, boolean desactivarLic) {
        initComponents();
        this.persona = persona;
        this.desactivarLic = desactivarLic;
        this.licenciaDAO = licenciaDAO;

    }

    /**
     * Método que agrega el vehículo a la bd
     */
    public void agregar() {
        int año = Integer.parseInt((String) cbAño.getSelectedItem());
        float costo = 0;

        if (año == 1 && persona.getDiscapacidad() == false) {
            costo = 600;
        } else if (año == 2 && persona.getDiscapacidad() == false) {
            costo = 900;
        } else if (año == 3 && persona.getDiscapacidad() == false) {
            costo = 1100;
        } else if (año == 1 && persona.getDiscapacidad() == true) {
            costo = 200;
        } else if (año == 2 && persona.getDiscapacidad() == true) {
            costo = 500;
        } else if (año == 3 && persona.getDiscapacidad() == true) {
            costo = 700;
        }

        Date fechaEmision = new Date();
        Date fechaRecepcion = new Date();

        fechaRecepcion.setYear((fechaRecepcion.getYear() + año));

        String estado = "Activa";
        Licencia lic = new Licencia(año, estado, costo, fechaRecepcion, fechaEmision, persona);
       
        if (desactivarLic) {
           
            licenciaDAO.DesactivarActual(persona.getId());

        }
        if (licenciaDAO.agregarLicencia(lic) == null) {
            JOptionPane.showMessageDialog(this, "No se pudo registrar la licencia");
        } else {

            JOptionPane.showMessageDialog(this, "Registro exitoso");
            frmMenuPrincipal principal = new frmMenuPrincipal(persona);
            principal.setVisible(true);
            this.dispose();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        cbAño = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegresar.setBackground(new java.awt.Color(0, 153, 204));
        btnRegresar.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setOpaque(true);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        btnAceptar.setBackground(new java.awt.Color(0, 153, 204));
        btnAceptar.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.setContentAreaFilled(false);
        btnAceptar.setOpaque(true);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, -1, -1));

        cbAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        cbAño.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204), 2));
        jPanel1.add(cbAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 190, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/city.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, -1, -1));

        jLabel11.setFont(new java.awt.Font("Roboto Medium", 1, 36)); // NOI18N
        jLabel11.setText("TRÁMITE LICENCIA");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/favicon.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel14.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        jLabel14.setText("Vigencia");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Método para regresar al menu principal al dar click en el boton
     * @param evt evt
     */
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        frmMenuPrincipal principal = new frmMenuPrincipal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    /**
     * Boton que agrega la licencia al darle click al boton
     * @param evt evt
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        this.agregar();

    }//GEN-LAST:event_btnAceptarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbAño;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
