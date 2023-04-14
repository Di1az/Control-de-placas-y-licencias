/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.ConexionBD;
import DAO.IConexionBD;
import DAO.TramiteDAO;
import Encriptacion.Encriptar;
import Entidades.Licencia;
import Entidades.Persona;
import Entidades.Placa;
import Entidades.Tramite;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscar
 */
public class frmReporte extends javax.swing.JFrame {

    IConexionBD conexionBD = new ConexionBD();
    TramiteDAO tramiteDAO = new TramiteDAO(conexionBD);

    /**
     * Creates new form Reporte
     */
    public frmReporte() {
        initComponents();
        llenarTramites();
    }

    /**
     * Metodo que se encarga de llenar la tabla de tramite 
     * dependiendo del filtro que el usuario utilice
     */
    public void llenarTramites() {
        System.out.println(cbLicencia.isSelected());
        System.out.println(cbPlaca.isSelected());
        List<Tramite> tramite = tramiteDAO.ListaTramite(cbLicencia.isSelected(), cbPlaca.isSelected(), this.txtFecha_inicio.getDate(), this.txtFecha_fin.getDate());
        tramite = desencriptarListaTramite(tramite);
        if (txtNombre.getText() != null) {
            List<Tramite> Listanombre = new ArrayList<Tramite>();
            for (int i = 0; i < tramite.size(); i++) {
                Persona persona = tramite.get(i).getPersona();
                String nombreCompleto = persona.getNombre() + " " + persona.getApellidoP() + " " + persona.getApellidoM();

                if (nombreCompleto.toLowerCase().contains(txtNombre.getText().toLowerCase())) {
                    Listanombre.add(tramite.get(i));
                }

            }
            tramite = Listanombre;

        }
        DefaultTableModel modelo = (DefaultTableModel) tblReporte.getModel();
        modelo.setRowCount(0);
        for (int i = 0; i < tramite.size(); i++) {
            Object[] datos = new Object[modelo.getColumnCount()];
            if (tramite.get(i) instanceof Placa) {
                datos[0] = "Placas";
                Placa placa = (Placa) tramite.get(i);
                datos[2] = placa.getCosto();
            }
            if (tramite.get(i) instanceof Licencia) {
                datos[0] = "Licencias";
                Licencia licencia = (Licencia) tramite.get(i);
                datos[2] = licencia.getCosto();
            }
            Persona persona = tramite.get(i).getPersona();
            String nombreCompleto = persona.getNombre() + " " + persona.getApellidoP() + " " + persona.getApellidoM();

            datos[1] = nombreCompleto;

            datos[3] = tramite.get(i).getFechaEmision();
            modelo.addRow(datos);
        }
    }

    /**
     * Metodo que se encaega de regresar una lista
     * de tramite con el nombre de la persona
     * desencriptado
     * @param lista
     * @return Lista de tramite con el nombre de la persona
     * desencriptado
     */
    public List<Tramite> desencriptarListaTramite(List<Tramite> lista) {
        Encriptar encriptacion = new Encriptar();
        List<Persona> personasDesencriptadas = new ArrayList<>();
        List<Tramite> lista_tramitePersona = new ArrayList<>();

        for (Tramite tramite : lista) {
            Persona persona = tramite.getPersona();

            if (!personasDesencriptadas.contains(persona)) {
                personasDesencriptadas.add(persona);
                persona.setNombre(encriptacion.desencriptar(persona.getNombre()));
                persona.setApellidoP(encriptacion.desencriptar(persona.getApellidoP()));
                persona.setApellidoM(encriptacion.desencriptar(persona.getApellidoM()));
            }
            lista_tramitePersona.add(tramite);
        }

        return lista_tramitePersona;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnPDF = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporte = new javax.swing.JTable();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbPlaca = new javax.swing.JCheckBox();
        cbLicencia = new javax.swing.JCheckBox();
        txtFecha_inicio = new com.toedter.calendar.JDateChooser();
        txtFecha_fin = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Reporte");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 6, -1, -1));

        jLabel2.setText("Fecha_Inicio:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 70, -1));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, -1));

        btnPDF.setText("Generar PDF");
        getContentPane().add(btnPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, -1, -1));

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 330, 80, -1));

        tblReporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tipo de tramite", "Persona", "Costo", "Fecha de expedición"
            }
        ));
        jScrollPane1.setViewportView(tblReporte);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 330, 203));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 100, -1));

        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, -1, -1));

        jLabel4.setText("Fecha_Fin:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 60, -1));

        jLabel7.setText("Tipo de tramite");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, -1));

        cbPlaca.setText("Placa");
        cbPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPlacaActionPerformed(evt);
            }
        });
        getContentPane().add(cbPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, -1, -1));

        cbLicencia.setText("Licencia");
        cbLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLicenciaActionPerformed(evt);
            }
        });
        getContentPane().add(cbLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, -1, -1));
        getContentPane().add(txtFecha_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 140, -1));
        getContentPane().add(txtFecha_fin, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 130, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo que se encarga de regresar al menu principal
     * @param evt 
     */
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        frmMenuPrincipal principal = new frmMenuPrincipal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    /**
     * Metodo que se encarga de aceptar los filtros
     * que el usuario desea utilizar
     * @param evt 
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        this.llenarTramites();
    }//GEN-LAST:event_btnAceptarActionPerformed

    /**
     * Metodo que se encarga de mostrar la tabla si el
     * check button de placa se encuentra seleccionado
     * @param evt 
     */
    private void cbPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPlacaActionPerformed
        // TODO add your handling code here:
        llenarTramites();
    }//GEN-LAST:event_cbPlacaActionPerformed

     /**
     * Metodo que se encarga de mostrar la tabla si el
     * check button de placa se encuentra seleccionado
     * @param evt 
     */
    private void cbLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLicenciaActionPerformed
        // TODO add your handling code here:
        llenarTramites();
    }//GEN-LAST:event_cbLicenciaActionPerformed

    /**
     * Metodo para que mientras vayas escribiendo en un txt
     * se vaya llenando la tabla
     * @param evt 
     */
    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        // TODO add your handling code here:
        llenarTramites();
    }//GEN-LAST:event_txtNombreKeyReleased

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
            java.util.logging.Logger.getLogger(frmReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmReporte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JCheckBox cbLicencia;
    private javax.swing.JCheckBox cbPlaca;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblReporte;
    private com.toedter.calendar.JDateChooser txtFecha_fin;
    private com.toedter.calendar.JDateChooser txtFecha_inicio;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
