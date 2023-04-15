/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.ConexionBD;
import DAO.IConexionBD;
import DAO.ILicenciaDAO;
import DAO.IPersonaDAO;
import DAO.IPlacaDAO;
import DAO.IVehiculoDAO;
import DAO.LicenciaDAO;
import DAO.PersonaDAO;
import DAO.PlacaDAO;
import DAO.VehiculoDAO;
import Entidades.Licencia;
import Entidades.Persona;
import Entidades.Vehiculo;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author oscar
 */
public class frmMenuPrincipal extends javax.swing.JFrame {

    /**
     * Objeto de tipo persona
     */
    Persona persona;

    public frmMenuPrincipal() {
        initComponents();
    }

    /**
     * Método constructor utilizado para devolver la rfc de la persona
     * registrada
     *
     * @param persona Persona a la cual se registro
     */
    public frmMenuPrincipal(Persona persona) {
        initComponents();
        txtRFC.setText(persona.getRfc());
    }

    /**
     * Método utilizado para encontrar si una persona encuentra almacenada en la
     * bd mediante el rfc
     *
     * @return falso si no lo encuentra, true de lo contrario
     */
    public boolean encontrarPersona() {
        IConexionBD conexion = new ConexionBD();
        IPersonaDAO personaDAO = new PersonaDAO(conexion);
        persona = personaDAO.buscarPersona(txtRFC.getText());
        if (persona == null) {
            JOptionPane.showMessageDialog(this, "No se pudo encontro la persona");
            return false;
        } else {
            return true;
        }

    }


    /**
     * 
     * @return 
     */
    public boolean verificarLista() {
        IConexionBD conexion = new ConexionBD();
        ILicenciaDAO lic = new LicenciaDAO(conexion);
        List<Licencia> licencia = lic.listarLicenciaVigentesPersona(persona.getRfc());

        if (licencia.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La persona no cuenta con una licencia vigente");
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

        bg = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnVehiculo = new javax.swing.JButton();
        btnPlacas = new javax.swing.JButton();
        btnLicencia = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnPersona = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        txtRFC = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 1, 36)); // NOI18N
        jLabel1.setText("MENU PRINCIPAL");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        btnVehiculo.setBackground(new java.awt.Color(0, 153, 204));
        btnVehiculo.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnVehiculo.setForeground(new java.awt.Color(255, 255, 255));
        btnVehiculo.setText("Registrar vehiculo");
        btnVehiculo.setContentAreaFilled(false);
        btnVehiculo.setOpaque(true);
        btnVehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVehiculoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVehiculoMouseExited(evt);
            }
        });
        btnVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVehiculoActionPerformed(evt);
            }
        });
        bg.add(btnVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        btnPlacas.setBackground(new java.awt.Color(0, 153, 204));
        btnPlacas.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnPlacas.setForeground(new java.awt.Color(255, 255, 255));
        btnPlacas.setText("Solicitar placas");
        btnPlacas.setContentAreaFilled(false);
        btnPlacas.setOpaque(true);
        btnPlacas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlacasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPlacasMouseExited(evt);
            }
        });
        btnPlacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlacasActionPerformed(evt);
            }
        });
        bg.add(btnPlacas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 160, -1));

        btnLicencia.setBackground(new java.awt.Color(0, 153, 204));
        btnLicencia.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnLicencia.setForeground(new java.awt.Color(255, 255, 255));
        btnLicencia.setText("Solicitar licencia");
        btnLicencia.setContentAreaFilled(false);
        btnLicencia.setOpaque(true);
        btnLicencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLicenciaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLicenciaMouseExited(evt);
            }
        });
        btnLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLicenciaActionPerformed(evt);
            }
        });
        bg.add(btnLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 160, -1));

        btnReporte.setBackground(new java.awt.Color(0, 153, 204));
        btnReporte.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnReporte.setForeground(new java.awt.Color(255, 255, 255));
        btnReporte.setText("Mostrar reporte");
        btnReporte.setContentAreaFilled(false);
        btnReporte.setOpaque(true);
        btnReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReporteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReporteMouseExited(evt);
            }
        });
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        bg.add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 160, -1));

        jLabel2.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel2.setText("Persona interesada (RFC)");
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        btnPersona.setBackground(new java.awt.Color(0, 153, 204));
        btnPersona.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnPersona.setForeground(new java.awt.Color(255, 255, 255));
        btnPersona.setText("Registrar cliente");
        btnPersona.setContentAreaFilled(false);
        btnPersona.setOpaque(true);
        btnPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPersonaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPersonaMouseExited(evt);
            }
        });
        btnPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonaActionPerformed(evt);
            }
        });
        bg.add(btnPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 160, -1));

        btnHistorial.setBackground(new java.awt.Color(0, 153, 204));
        btnHistorial.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnHistorial.setForeground(new java.awt.Color(255, 255, 255));
        btnHistorial.setText("Mostrar historial");
        btnHistorial.setContentAreaFilled(false);
        btnHistorial.setOpaque(true);
        btnHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHistorialMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHistorialMouseExited(evt);
            }
        });
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });
        bg.add(btnHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 160, -1));

        txtRFC.setForeground(new java.awt.Color(204, 204, 204));
        txtRFC.setText("Ingrese su RFC");
        txtRFC.setBorder(null);
        txtRFC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtRFCMousePressed(evt);
            }
        });
        txtRFC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRFCKeyTyped(evt);
            }
        });
        bg.add(txtRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 350, 30));

        jLabel5.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Control de placas y Licencias");
        bg.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/logo.png"))); // NOI18N
        bg.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 150, 150));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/city.png"))); // NOI18N
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 290, 500));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 350, 20));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/favicon.png"))); // NOI18N
        bg.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 50, 50));

        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Boton que accede al registro persona
     * @param evt 
     */
    private void btnPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonaActionPerformed
        // TODO add your handling code here:
        IConexionBD conexion = new ConexionBD();
        IPersonaDAO personaDAO = new PersonaDAO(conexion);
        frmPersona persona = new frmPersona(personaDAO);
        persona.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPersonaActionPerformed
    /**
     * Método que al dar click en el boton si se encuentra a la persona nos
     * manda al frame de registro de vehículo
     *
     * @param evt evt
     */
    private void btnVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVehiculoActionPerformed

        if (encontrarPersona()) {
            IConexionBD conexion = new ConexionBD();
            IVehiculoDAO vehiculoDAO = new VehiculoDAO(conexion);
            frmVehiculo vehiculo = new frmVehiculo(vehiculoDAO, persona);
            vehiculo.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_btnVehiculoActionPerformed

    /**
     * Método que si se encuntra a la persona la manda a la pantalla de Placas
     *
     * @param evt evt
     */
    private void btnPlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlacasActionPerformed
        if (encontrarPersona()) {
            if (!verificarLista()) {
                return;
            }
            IConexionBD conexion = new ConexionBD();
            IPlacaDAO placaDAO = new PlacaDAO(conexion);
            IVehiculoDAO vehiculoDAO = new VehiculoDAO(conexion);
            frmPlacas placas = new frmPlacas(placaDAO, vehiculoDAO, persona);
            placas.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_btnPlacasActionPerformed

    /**
     * Boton que accede al menu licencia
     * @param evt 
     */
    private void btnLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLicenciaActionPerformed
        if (encontrarPersona()) {
            IConexionBD conexion = new ConexionBD();
            ILicenciaDAO lcd = new LicenciaDAO(conexion);

            if (lcd.LicenciaActiva(persona.getId()) != null) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de ejecutar este comando?", "Confirmar", JOptionPane.YES_NO_OPTION);

                if (opcion == JOptionPane.YES_OPTION) {
                    frmLicencia licencia = new frmLicencia(persona, lcd, true);
                    licencia.setVisible(true);
                    this.dispose();
                } else {
                    return;
                }
            }
            else{
               frmLicencia licencia = new frmLicencia(persona, lcd, false);
            licencia.setVisible(true);
            this.dispose(); 
            }
            
        }
    }//GEN-LAST:event_btnLicenciaActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
        frmReporte reporte = new frmReporte();
        reporte.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        // TODO add your handling code here:
        IConexionBD conexion = new ConexionBD();
        IPersonaDAO personaDAO = new PersonaDAO(conexion);
        frmHistorial historial = new frmHistorial(personaDAO);
        historial.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHistorialActionPerformed
    /**
     * Método que valida el campo de rfc
     *
     * @param evt evt
     */
    private void txtRFCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRFCKeyTyped
        char c = evt.getKeyChar();

        if ((c < '0' || c > '9') && (c < 'A') | c > 'Z') {
            evt.consume();
        }

        if (txtRFC.getText().length() == 13) {
            evt.consume();
        }


    }//GEN-LAST:event_txtRFCKeyTyped

    private void txtRFCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRFCMousePressed
        txtRFC.setText("");
        txtRFC.setForeground(Color.black);
    }//GEN-LAST:event_txtRFCMousePressed

    private void btnPersonaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPersonaMouseEntered
        btnPersona.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_btnPersonaMouseEntered

    private void btnPersonaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPersonaMouseExited
        btnPersona.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_btnPersonaMouseExited

    private void btnVehiculoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVehiculoMouseEntered
        btnVehiculo.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_btnVehiculoMouseEntered

    private void btnVehiculoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVehiculoMouseExited
        btnVehiculo.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_btnVehiculoMouseExited

    private void btnPlacasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlacasMouseEntered
        btnPlacas.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_btnPlacasMouseEntered

    private void btnPlacasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlacasMouseExited
        btnPlacas.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_btnPlacasMouseExited

    private void btnLicenciaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLicenciaMouseEntered
        btnLicencia.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_btnLicenciaMouseEntered

    private void btnLicenciaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLicenciaMouseExited
        btnLicencia.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_btnLicenciaMouseExited

    private void btnReporteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporteMouseEntered
        btnReporte.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_btnReporteMouseEntered

    private void btnReporteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporteMouseExited
        btnReporte.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_btnReporteMouseExited

    private void btnHistorialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistorialMouseEntered
        btnHistorial.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_btnHistorialMouseEntered

    private void btnHistorialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistorialMouseExited
        btnHistorial.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_btnHistorialMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnLicencia;
    private javax.swing.JButton btnPersona;
    private javax.swing.JButton btnPlacas;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnVehiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtRFC;
    // End of variables declaration//GEN-END:variables
}
