/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase entidad de Persona
 * @author oscar
 */
@Entity
@Table(name = "Personas")
public class Persona implements Serializable {

    /**
     * Id de la persona
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Persona")
    private Integer id;

    /**
     * RFC de la persona
     */
    @Column(name = "RFC")
    private String rfc;

    /**
     * Nombre de la persona
     */
    @Column(name = "Nombre")
    private String nombre;

    /**
     * Apellido paterno de la persona
     */
    @Column(name = "Apellido_paterno")
    private String apellidoP;

    /**
     * Apellido materno de la persona
     */
    @Column(name = "Apellido_materno")
    private String apellidoM;

    /**
     * Telefono de la persona
     */
    @Column(name = "Telefono")
    private String telefono;

    /**
     * Fecha de nacimiento de la persona
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "Fecha_Nacimiento")
    private Date fechaN;

    /**
     * Metodo que nos regresa verdadero si la persona es discapacitada
     */
    @Column(name = "Discapacidad")
    private boolean discapacidad;

    /**
     * Mapeo de clase persona a vehiculos la cual es de tipo OneToMany
     */
    @OneToMany(mappedBy = "Persona")
    private List<Vehiculo> vehiculos;

    /**
     * Mapeo de clase persona a tramite la cual es de tipo OneToMany
     */
    @OneToMany(mappedBy = "Persona")
    private List<Tramite> tramite;

    /**
     * Constructor por defecto
     */
    public Persona() {
    }

    /**
     * Constructor que guarda todas las variables de la entidad
     *
     * @param id
     * @param rfc
     * @param nombre
     * @param apellidoP
     * @param apellidoM
     * @param telefono
     * @param fechaN
     * @param discapacidad
     * @param vehiculos
     * @param tramite
     */
    public Persona(Integer id, String rfc, String nombre, String apellidoP, String apellidoM, String telefono, Date fechaN, boolean discapacidad, List<Vehiculo> vehiculos, List<Tramite> tramite) {
        this.id = id;
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.telefono = telefono;
        this.fechaN = fechaN;
        this.discapacidad = discapacidad;
        this.vehiculos = vehiculos;
        this.tramite = tramite;
    }

    /**
     * Constructor que guarda todas las variables de la entidad excepto el id
     *
     * @param rfc
     * @param nombre
     * @param apellidoP
     * @param apellidoM
     * @param telefono
     * @param fechaN
     * @param discapacidad
     * @param vehiculos
     * @param tramite
     */
    public Persona(String rfc, String nombre, String apellidoP, String apellidoM, String telefono, Date fechaN, boolean discapacidad, List<Vehiculo> vehiculos, List<Tramite> tramite) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.telefono = telefono;
        this.fechaN = fechaN;
        this.discapacidad = discapacidad;
        this.vehiculos = vehiculos;
        this.tramite = tramite;
    }

    /**
     * Constructor que guarda todas las variables de la entidad excepto el id e
     * incluyendo una lista de tipo tramite y vehiculo
     *
     * @param rfc
     * @param nombre
     * @param apellidoP
     * @param apellidoM
     * @param telefono
     * @param fechaN
     * @param discapacidad
     */
    public Persona(String rfc, String nombre, String apellidoP, String apellidoM, String telefono, Date fechaN, boolean discapacidad) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.telefono = telefono;
        this.fechaN = fechaN;
        this.discapacidad = discapacidad;
        this.vehiculos = new ArrayList<>();
        this.tramite = new ArrayList<>();
    }

    /**
     * Metodo que regresa el id
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Metodo que establece el id
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    
    
    
    
    
    
    
    
    
    /**
     * Hash code clase persona
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Metodo equals
     *
     * @param object
     * @return true or false
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Metodo to string
     *
     * @return id
     */
    @Override
    public String toString() {
        return "Entidades.Persona[ id=" + id + " ]";
    }

    /**
     * Metodo que regresa el rfc
     *
     * @return rfc
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Metodo que establece el rfc
     *
     * @param rfc
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Metodo que regresa el nombre
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que establece el nombre
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que regresa el apellido paterno
     *
     * @return apellidoP
     */
    public String getApellidoP() {
        return apellidoP;
    }

    /**
     * Metodo que establece el apellido paterno
     *
     * @param apellidoP
     */
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    /**
     * Metodo que regresa el apellido materno
     *
     * @return apellidoP
     */
    public String getApellidoM() {
        return apellidoM;
    }

    /**
     * Metodo que establece el apellido materno
     *
     * @param apellidoM
     */
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    /**
     * Metodo que regresa el telefono
     *
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Metodo que establece el telefono
     *
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Metodo que regresa la fecha de nacimiento
     *
     * @return fechaN
     */
    public Date getFechaN() {
        return fechaN;
    }

    /**
     * Metodo que establece la fecha de nacimiento
     *
     * @param fechaN
     */
    public void setFechaN(Date fechaN) {
        this.fechaN = fechaN;
    }

    /**
     * Metodo que regresa la discapacidad
     *
     * @return true or false
     */
    public boolean getDiscapacidad() {
        return discapacidad;
    }

    /**
     * Metodo que establece la discapacidad
     *
     * @param discapacidad
     */
    public void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    /**
     * Metodo que regresa una lista de vehiculos
     *
     * @return vehiculos
     */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Metodo que establece la lista de vehiculos
     *
     * @param vehiculos
     */
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Metodo que regresa una lista con los tramites
     *
     * @return tramite
     */
    public List<Tramite> getTramite() {
        return tramite;
    }

    /**
     * Metodo que establece una lista de tramitess
     *
     * @param tramite
     */
    public void setTramite(List<Tramite> tramite) {
        this.tramite = tramite;
    }

}
