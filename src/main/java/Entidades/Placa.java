/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Dany
 */
@Entity 
@Table(name="Placas")
public class Placa extends Tramite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_placa")
    private Integer id;
    
    @Column(name="Costo")
    private float costo;
    
    @Column(name="Número_placa")
    private String numeroPlaca;
    
    @Column(name="Estado")
    private String estado;
   
    @ManyToOne
    @JoinColumn(name="Id_vehiculo")
    private Vehiculo vehiculo;

    public Placa() {
    }

    public Placa(Integer id, float costo, String numeroPlaca, String estado) {
        this.id = id;
        this.costo = costo;
        this.numeroPlaca = numeroPlaca;
        this.estado = estado;
    }
    
    
    
    /*
    public Placa(float costo, String numeroPlaca, String estado, Date fechaRecepcion, Date fechaEmision) {
        this.costo = costo;
        this.numeroPlaca = numeroPlaca;
        this.estado = estado;
      
    }
    */

    public Placa(float costo, String numeroPlaca, String estado, Vehiculo vehiculo, Date fechaRecepcion, Date fechaEmision) {
        super(fechaRecepcion, fechaEmision);
        this.costo = costo;
        this.numeroPlaca = numeroPlaca;
        this.estado = estado;
        this.vehiculo = vehiculo;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        if (!(object instanceof Placa)) {
            return false;
        }
        Placa other = (Placa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Placa[ id=" + id + " ]";
    }
    
}
