/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Basic;
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
 *
 * @author oscar
 */
@Entity
@Table(name = "Personas")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Persona")
    private Integer id;

    @Column(name = "RFC")
    private String rfc;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellido_paterno")
    private String apellidoP;

    @Column(name = "Apellido_materno")
    private String apellidoM;

    @Column(name = "Telefono")
    private String telefono;

    @Temporal(TemporalType.DATE)
    @Column(name = "Fecha_Nacimiento")
    private Date fechaN;

    @Column(name = "Discapacidad")
    private boolean discapacidad;

    @OneToMany(mappedBy = "Persona")
    private List<Vehiculo> vehiculos;

    @OneToMany(mappedBy = "Persona")
    private List<Tramite> tramite;

    public Persona() {
    }

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

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

    @Override
    public String toString() {
        return "Entidades.Persona[ id=" + id + " ]";
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaN() {
        return fechaN;
    }

    public void setFechaN(Date fechaN) {
        this.fechaN = fechaN;
    }

    public boolean getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<Tramite> getTramite() {
        return tramite;
    }

    public void setTramite(List<Tramite> tramite) {
        this.tramite = tramite;
    }

}
