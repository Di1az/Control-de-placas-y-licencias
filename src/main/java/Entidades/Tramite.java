/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Dany
 */
@Entity
@Table(name = "Tramite")
@DiscriminatorColumn(name = "Tipo_Tramite")
@Inheritance(strategy = InheritanceType.JOINED)
public class Tramite implements Serializable {

    /**
     * Id del tramite
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Tramite")
    private Integer id;

    /**
     * Fecha de recepcion del tramite
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "Fecha_recepción")
    private Date fechaRecepcion;

    /**
     * Fecha de emision del tramites
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "Fecha_emisión")
    private Date fechaEmision;

    /**
     * Persona asociado al tramites
     */
    @ManyToOne
    @JoinColumn(name = "Id_Persona")
    private Persona persona;

    /**
     * Constructor por defecto
     */
    public Tramite() {
    }

    /**
     * Constructor que recibe todas las variables de la clase
     *
     * @param id id del tramite
     * @param fechaRecepcion fecha de la recepcion
     * @param fechaEmision fecha de emision
     * @param persona persona que hizo el tramite
     */
    public Tramite(Integer id, Date fechaRecepcion, Date fechaEmision, Persona persona) {
        this.id = id;
        this.fechaRecepcion = fechaRecepcion;
        this.fechaEmision = fechaEmision;
        this.persona = persona;
    }

    /**
     * Constructor que recibe todas las variables de la clase excepto el id
     *
     * @param fechaRecepcion fecha de recepcion
     * @param fechaEmision fecha de emision
     * @param persona persona que hizo el tramite
     */
    public Tramite(Date fechaRecepcion, Date fechaEmision, Persona persona) {
        this.fechaRecepcion = fechaRecepcion;
        this.fechaEmision = fechaEmision;
        this.persona = persona;
    }

    /**
     * Contructor que establece las variables fecha recepcion y emision al valor
     * de sus parametros
     *
     * @param fechaRecepcion fecha de recepcion
     * @param fechaEmision fecha de emision
     */
    public Tramite(Date fechaRecepcion, Date fechaEmision) {
        this.fechaRecepcion = fechaRecepcion;
        this.fechaEmision = fechaEmision;
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
     * @param id id del tramite
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Metodo que regresa la fecha de recepcion
     *
     * @return fechaRecepcion
     */
    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    /**
     * Metodo que establece la fecha de recepcion
     *
     * @param fechaRecepcion fecha de la recepcion
     */
    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    /**
     * Metodo que regresa la fecha de emision
     *
     * @return la fecha de emision
     */
    public Date getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Metodo que establece la fecha de emision
     *
     * @param fechaEmision fecha de emision
     */
    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * Metodo HashCode
     *
     * @return hash
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
     * @param object object
     * @return true or false
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tramite)) {
            return false;
        }
        Tramite other = (Tramite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Metodo toString
     *
     * @return el toString con el id"
     */
    @Override
    public String toString() {
        return "Entidades.Tramite[ id=" + id + " ]";
    }

    /**
     * Metodo que regresa la persona
     *
     * @return persona que hizo el tramite
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Metodo que establece la persona
     *
     * @param persona persona qeu hizo el tramite
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
