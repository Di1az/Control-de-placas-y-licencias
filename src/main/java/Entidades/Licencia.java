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
import javax.persistence.Table;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name="Licencias")
public class Licencia extends Tramite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_licencia")
    private Integer id;
    
    @Column(name="Vigencia")
    private int vigencia;
    
    @Column(name="Costo")
    private float costo;

    public Licencia() {
    }

    public Licencia(Integer id, int Vigencia, float costo) {
        this.id = id;
        this.vigencia = Vigencia;
        this.costo = costo;
    }

    public Licencia(int Vigencia, float costo) {
        this.vigencia = Vigencia;
        this.costo = costo;
    }

    public Licencia(int vigencia, float costo, Date fechaRecepcion, Date fechaEmision, Persona persona) {
        super(fechaRecepcion, fechaEmision, persona);
        this.vigencia = vigencia;
        this.costo = costo;
    }
   
   
    public int getVigencia() {
        return vigencia;
    }

    public void setVigencia(int Vigencia) {
        this.vigencia = Vigencia;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
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
        if (!(object instanceof Licencia)) {
            return false;
        }
        Licencia other = (Licencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Licencia[ id=" + id + " ]";
    }
    
}
