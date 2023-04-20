/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.IPersonaDAO;
import Entidades.Persona;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author oscar
 */
public class frmPersona extends javax.swing.JFrame {

    /**
     * Objeto de tipo IPersonaDAO
     */
    private final IPersonaDAO personaDAO;

    /**
     * Método constructor que inicializa los atributos
     *
     * @param personaDao personaDao
     */
    public frmPersona(IPersonaDAO personaDao) {
        initComponents();
        this.personaDAO = personaDao;
    }

    /**
     * Método que agrega a una persona
     */
    public void agregar() {
        long fecha = this.txtFechaN.getDate().getTime();
        java.sql.Date inicio = new java.sql.Date(fecha);
        boolean discapacidad = false;
        if (txtDiscapacidad.getText().equalsIgnoreCase("Y")) {
            discapacidad = true;
        }

        Persona persona = new Persona(txtRFC.getText(), txtNombre.getText(), txtApellidoP.getText(), txtApellidoM.getText(), txtTelefono.getText(), inicio, discapacidad);

        if (personaDAO.registrarPersona(persona) == null) {
            JOptionPane.showMessageDialog(this, "No se pudo registrar a la persona");
        } else {

            JOptionPane.showMessageDialog(this, "Registro exitoso");
            frmMenuPrincipal principal = new frmMenuPrincipal(persona);
            principal.setVisible(true);
            this.dispose();
        }

    }

    /**
     * Metodo que valida que la persona no sea menor a 18 años ni la fecha de
     * nacimiento sea mayor a la actual
     *
     * @param fechaNacimiento
     * @return
     */
    public static boolean validarFecha(Date fechaNacimiento) {
        Date fechaActual = new Date(); // Obtener la fecha actual
        Calendar dob = Calendar.getInstance();
        dob.setTime(fechaNacimiento);
        dob.add(Calendar.YEAR, 18); // Añadir 18 años a la fecha de nacimiento

        if (dob.after(Calendar.getInstance())) { // Si la fecha de nacimiento + 18 años es posterior a la fecha actual
            JOptionPane.showMessageDialog(null, "Debe ser mayor de 18 años para registrarse");
            return false;
        } else if (fechaNacimiento.after(fechaActual)) { // Si la fecha de nacimiento es posterior a la fecha actual
            JOptionPane.showMessageDialog(null, "La fecha no puede ser mayor al día de hoy");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Método de validación que solo permite letras y el espacio
     *
     * @param evento evt
     */
    public void validarNombre(java.awt.event.KeyEvent evento) {
        if (evento.getKeyChar() >= 33 && evento.getKeyChar() <= 64
                || evento.getKeyChar() >= 91 && evento.getKeyChar() <= 96
                || evento.getKeyChar() >= 123 && evento.getKeyChar() <= 127) {

            evento.consume();

        }
    }

    /**
     * Método utilizado para validar la discapacidad
     *
     * @param evento evento
     */
    public void validarDiscapacidad(java.awt.event.KeyEvent evento) {
        if (evento.getKeyChar() >= 32 && evento.getKeyChar() <= 77
                || evento.getKeyChar() >= 79 && evento.getKeyChar() <= 88
                || evento.getKeyChar() >= 90 && evento.getKeyChar() <= 126) {

            evento.consume();

        }
    }

    /**
     * Metodo que valida que el rfc no se repita con alguno ya registrado
     *
     * @return true o false
     */
    public boolean validarRFC() {
        List<Persona> personaL = personaDAO.listaPersona();
        for (Persona persona : personaL) {
            if (txtRFC.getText().equalsIgnoreCase(persona.getRfc())) {
                JOptionPane.showMessageDialog(this, "El RFC ya existe");
                return false;
            }
        }
        return true;

    }

    /**
     * Método que nos ayuda para que no existan vacíos dentro del cuadro de
     * texto.
     *
     * @return regreso
     * @return regreso
     */
    private boolean validarVacios() {
        boolean error = true;

        if (txtApellidoM.getText().equals("")
                || txtApellidoP.getText().equals("")
                || txtNombre.getText().equals("")
                || txtRFC.getText().equals("")
                || txtTelefono.getText().equals("")
                || txtDiscapacidad.getText().equals("")
                || txtFechaN.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Favor de llenar los campos faltantes", "Informacion", JOptionPane.INFORMATION_MESSAGE);

            return false;
        }
        if (txtRFC.getText().length() != 12) {
            JOptionPane.showMessageDialog(this, "El RFC debe de contener un total de 12 caracteres", "Informacion", JOptionPane.INFORMATION_MESSAGE);

            return false;
        }

        return error;
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
        btnVolver = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        txtRFC = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidoP = new javax.swing.JTextField();
        txtApellidoM = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtFechaN = new com.toedter.calendar.JDateChooser();
        txtDiscapacidad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        btnCancelar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setForeground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVolver.setBackground(new java.awt.Color(0, 153, 204));
        btnVolver.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.setContentAreaFilled(false);
        btnVolver.setOpaque(true);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        bg.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, -1, -1));

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
        bg.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, -1, -1));

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
        bg.add(txtRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 260, -1));

        txtNombre.setForeground(new java.awt.Color(204, 204, 204));
        txtNombre.setText("Ingrese su nombre");
        txtNombre.setBorder(null);
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNombreMousePressed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        bg.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 191, -1));

        txtApellidoP.setForeground(new java.awt.Color(204, 204, 204));
        txtApellidoP.setText("Ingrese su apellido Paterno");
        txtApellidoP.setBorder(null);
        txtApellidoP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtApellidoPMousePressed(evt);
            }
        });
        txtApellidoP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoPKeyTyped(evt);
            }
        });
        bg.add(txtApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 191, -1));

        txtApellidoM.setForeground(new java.awt.Color(204, 204, 204));
        txtApellidoM.setText("Ingrese su apellido Materno");
        txtApellidoM.setBorder(null);
        txtApellidoM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtApellidoMMousePressed(evt);
            }
        });
        txtApellidoM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoMKeyTyped(evt);
            }
        });
        bg.add(txtApellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 340, -1));

        txtTelefono.setForeground(new java.awt.Color(204, 204, 204));
        txtTelefono.setText("Ingrese su teléfono");
        txtTelefono.setBorder(null);
        txtTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTelefonoMousePressed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        bg.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 210, -1));

        txtFechaN.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bg.add(txtFechaN, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 200, -1));

        txtDiscapacidad.setForeground(new java.awt.Color(204, 204, 204));
        txtDiscapacidad.setText("Ingrese Y o N");
        txtDiscapacidad.setBorder(null);
        txtDiscapacidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDiscapacidadMousePressed(evt);
            }
        });
        txtDiscapacidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiscapacidadKeyTyped(evt);
            }
        });
        bg.add(txtDiscapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, 90, -1));

        jLabel9.setFont(new java.awt.Font("Roboto Medium", 1, 36)); // NOI18N
        jLabel9.setText("REGISTRO PERSONAS");
        bg.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        jLabel10.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel10.setText("¿Es discapacitado? (Y si lo es, N de lo contrario)");
        bg.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        jLabel11.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel11.setText("RFC");
        bg.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel12.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel12.setText("Nombre");
        bg.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel13.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel13.setText("Apellido Paterno");
        bg.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel14.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel14.setText("Apellido Materno");
        bg.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabel15.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel15.setText("Teléfono");
        bg.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        jLabel16.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel16.setText("Fecha de nacimiento");
        bg.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/city.png"))); // NOI18N
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 290, 500));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/favicon.png"))); // NOI18N
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 50, 50));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, 210, 20));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 260, 20));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 260, 20));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 90, 20));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 260, 20));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 260, 20));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 260, 20));

        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 260, 20));

        btnCancelar1.setBackground(new java.awt.Color(0, 153, 204));
        btnCancelar1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnCancelar1.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar1.setText("Cancelar");
        btnCancelar1.setContentAreaFilled(false);
        btnCancelar1.setOpaque(true);
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });
        bg.add(btnCancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, -1, -1));

        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Método para volver al menu principal al dar click al boton
     *
     * @param evt evt
     */
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        frmMenuPrincipal principal = new frmMenuPrincipal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed
    /**
     * Método que si no hay ningun campo vacio llama al metodo para agregar a la
     * persona
     *
     * @param evt evt
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (validarVacios()) {
            if (validarRFC()) {

            }
            if (validarFecha(txtFechaN.getDate())) {
                this.agregar();
            }

        }

    }//GEN-LAST:event_btnAceptarActionPerformed
    /**
     * Método que validad el campo rfc
     *
     * @param evt evt
     */
    private void txtRFCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRFCKeyTyped
        char c = evt.getKeyChar();

        if ((c < '0' || c > '9') && (c < 'A') | c > 'Z') {
            evt.consume();
        }

        if (txtRFC.getText().length() == 12) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRFCKeyTyped
    /**
     * Método que utiliza el validarNombre para solo permitir letras y espacio
     *
     * @param evt evt
     */
    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        validarNombre(evt);
    }//GEN-LAST:event_txtNombreKeyTyped
    /**
     * Método que utiliza el validarNombre para solo permitir letras y espacio
     *
     * @param evt evt
     */
    private void txtApellidoPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoPKeyTyped
        validarNombre(evt);
    }//GEN-LAST:event_txtApellidoPKeyTyped
    /**
     * Método que utiliza el validarNombre para solo permitir letras y espacio
     *
     * @param evt evt
     */
    private void txtApellidoMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoMKeyTyped
        validarNombre(evt);
    }//GEN-LAST:event_txtApellidoMKeyTyped
    /**
     * Método que valida el telefono
     *
     * @param evt evt
     */
    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char c = evt.getKeyChar();

        if ((c < '0' || c > '9')) {
            evt.consume();
        }

        if (txtTelefono.getText().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped
    /**
     * Método que valida la pregunta de discapacidad
     *
     * @param evt evt
     */
    private void txtDiscapacidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiscapacidadKeyTyped
        validarDiscapacidad(evt);

        if (txtDiscapacidad.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDiscapacidadKeyTyped
    /**
     * Método para aparentar un placeholder
     *
     * @param evt evt
     */
    private void txtRFCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRFCMousePressed
        txtRFC.setText("");
        txtRFC.setForeground(Color.black);
    }//GEN-LAST:event_txtRFCMousePressed
    /**
     * Método para aparentar un placeholder
     *
     * @param evt evt
     */
    private void txtNombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMousePressed
        txtNombre.setText("");
        txtNombre.setForeground(Color.black);
    }//GEN-LAST:event_txtNombreMousePressed
    /**
     * Método para aparentar un placeholder
     *
     * @param evt evt
     */
    private void txtApellidoPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidoPMousePressed
        txtApellidoP.setText("");
        txtApellidoP.setForeground(Color.black);
    }//GEN-LAST:event_txtApellidoPMousePressed
    /**
     * Método para aparentar un placeholder
     *
     * @param evt evt
     */
    private void txtApellidoMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidoMMousePressed
        txtApellidoM.setText("");
        txtApellidoM.setForeground(Color.black);
    }//GEN-LAST:event_txtApellidoMMousePressed
    /**
     * Método para aparentar un placeholder
     *
     * @param evt evt
     */
    private void txtTelefonoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoMousePressed
        txtTelefono.setText("");
        txtTelefono.setForeground(Color.black);
    }//GEN-LAST:event_txtTelefonoMousePressed
    /**
     * Método para aparentar un placeholder
     *
     * @param evt evt
     */
    private void txtDiscapacidadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDiscapacidadMousePressed
        txtDiscapacidad.setText("");
        txtDiscapacidad.setForeground(Color.black);
    }//GEN-LAST:event_txtDiscapacidadMousePressed
    /**
     * Método para limpiar los textfields al dar click en el boton
     *
     * @param evt evt
     */
    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        txtApellidoM.setText("");
        txtApellidoP.setText("");
        txtNombre.setText("");
        txtRFC.setText("");
        txtTelefono.setText("");
    }//GEN-LAST:event_btnCancelar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JTextField txtDiscapacidad;
    private com.toedter.calendar.JDateChooser txtFechaN;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRFC;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
