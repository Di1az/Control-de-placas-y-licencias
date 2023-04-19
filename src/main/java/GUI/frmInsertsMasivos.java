/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.IPersonaDAO;
import Encriptacion.Encriptar;
import Entidades.Persona;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Clase para realizar insertes masivos de personas
 * @author dany
 */
public class frmInsertsMasivos extends javax.swing.JFrame {
    
    /**
     * Objeto de tipo IPersonaDAO
     */
    private final IPersonaDAO personaDAO;
    
    /**
     * Método constructor que inicializa los atributos
     */
    public frmInsertsMasivos(IPersonaDAO personaDAO) {
        initComponents();
        this.personaDAO = personaDAO;
    }
    
    
    /**
     * Metodo para agregar varias personas a la tabla
     */
    public void agregarVariasPersonas() {
        boolean dis = true;

        for (int i = 0; i < TblInserts.getRowCount(); i++) {
            for (int j = 0; j < TblInserts.getColumnCount(); j++) {
                if (TblInserts.getValueAt(i, j) == null) {
                    JOptionPane.showMessageDialog(null, "Falta una casilla");
                    return;
                }
            }
        }

        int rowCount = TblInserts.getRowCount();
        int colCount = TblInserts.getColumnCount();

        for (int i = 0; i < rowCount; i++) {
            String nombre = (String) TblInserts.getValueAt(i, 0);
            String apellidoPaterno = (String) TblInserts.getValueAt(i, 1);
            String apellidoMaterno = (String) TblInserts.getValueAt(i, 2);
            String rfc = (String) TblInserts.getValueAt(i, 3);
            String telefono = (String) TblInserts.getValueAt(i, 4);
            String fechaNacimiento = (String) TblInserts.getValueAt(i, 5);

            if ("Si".equalsIgnoreCase((String) TblInserts.getValueAt(i, 6))) {
                dis = true;
            } else if (TblInserts.getValueAt(i, 6) == null) {
                dis = false;
            }

            // Expresiones regulares
            String regexRfc = "[a-zA-Z0-9]+";
            String regexTexto = "[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+";
            String regexTelefono = "\\d{10}";

            // Validar que no se pueda agregar números y caracteres especiales a apellidoMaterno, apellidoPaterno y Nombre
            if (!apellidoMaterno.matches(regexTexto) || !apellidoPaterno.matches(regexTexto) || !nombre.matches(regexTexto)) {
                JOptionPane.showMessageDialog(null, "Apellido materno, apellido paterno y nombre solo pueden contener letras");
                continue; // Salir de la iteración actual y pasar a la siguiente persona
            }

            // Validar que no se pueda agregar texto y caracteres especiales a Telefono
            if (!telefono.matches(regexTelefono)) {
                JOptionPane.showMessageDialog(null, "Teléfono solo puede contener números de 10 dígitos");
                continue; // Salir de la iteración actual y pasar a la siguiente persona
            }

            // Validar que no se pueda agregar caracteres especiales a RFC
            if (!rfc.matches(regexRfc)) {
                JOptionPane.showMessageDialog(null, "RFC solo puede contener letras y números");
                continue; // Salir de la iteración actual y pasar a la siguiente persona
            }
            
            Encriptar encriptador = new Encriptar();
            String nombreEncriptado = encriptador.encriptar(nombre);
            String aPEncriptado = encriptador.encriptar(apellidoPaterno);
            String aMEncriptado = encriptador.encriptar(apellidoMaterno);
            

            Persona nuevaPersona = new Persona();
            nuevaPersona.setRfc(rfc);
            nuevaPersona.setNombre(nombreEncriptado);
            nuevaPersona.setApellidoP(aPEncriptado);
            nuevaPersona.setApellidoM(aMEncriptado);
            nuevaPersona.setTelefono(telefono);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = null;
            try {
                fecha = dateFormat.parse(fechaNacimiento);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Fecha incorrecta para el usuario: " + nuevaPersona.getNombre());
                return;
            }

            nuevaPersona.setFechaN(fecha);
            nuevaPersona.setDiscapacidad(dis);

            // Validar que la persona no tenga el mismo rfc
            List<Persona> personasConMismoRfc = (List<Persona>) personaDAO.buscarPersona(rfc);
            if (!personasConMismoRfc.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La persona con RFC " + rfc + " ya ha sido registrada anteriormente");
                continue; // Salir de la iteración actual y pasar a la siguiente persona
            }
            
            Persona personaGuardada = personaDAO.registrarPersona(nuevaPersona);

            if (personaGuardada == null) {
                JOptionPane.showMessageDialog(null, "Datos vacíos");
            } else {
                JOptionPane.showMessageDialog(null, "Se ha registrado una persona");
            }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblInserts = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/city.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 250, -1));

        jLabel11.setFont(new java.awt.Font("Roboto Medium", 1, 36)); // NOI18N
        jLabel11.setText("INSERTS MASIVOS ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/favicon.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

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
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, -1, -1));

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
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, -1, -1));

        TblInserts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "AP", "AM", "RFC", "Teléfono", "Birthday", "Discapacidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TblInserts);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 600, 120));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Método que al dar click al boton realiza el metodo agregar
     * @param evt evt
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        
        this.agregarVariasPersonas();
    }//GEN-LAST:event_btnAceptarActionPerformed
    /**
     * Método que al darle click al boton regresa al menu princial
     * @param evt 
     */
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        frmMenuPrincipal principal = new frmMenuPrincipal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblInserts;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
