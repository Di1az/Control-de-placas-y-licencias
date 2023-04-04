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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Dany
 */
@Entity
@Table(name = "Trámites")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Tramite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_trámite")
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name = "Fecha_recepción")
    private Date fechaRecepcion;
   
    @Temporal(TemporalType.DATE)
    @Column(name = "Fecha_emisión")
    private Date fechaEmision;

    public Tramite() {
    }

    public Tramite(Integer id, Date fechaRecepcion, Date fechaEmision) {
        this.id = id;
        this.fechaRecepcion = fechaRecepcion;
        this.fechaEmision = fechaEmision;
    }

    public Tramite(Date fechaRecepcion, Date fechaEmision) {
        this.fechaRecepcion = fechaRecepcion;
        this.fechaEmision = fechaEmision;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
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
        if (!(object instanceof Tramite)) {
            return false;
        }
        Tramite other = (Tramite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Tramite[ id=" + id + " ]";
    }

}
