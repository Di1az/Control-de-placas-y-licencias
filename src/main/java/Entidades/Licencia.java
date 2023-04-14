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
import javax.persistence.DiscriminatorValue;
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
@DiscriminatorValue(value="Licencia")
public class Licencia extends Tramite implements Serializable {

    
    
    @Column(name="Vigencia")
    private int vigencia;
    
    @Column(name="Costo")
    private float costo;

    public Licencia() {
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
    

   
    
}
