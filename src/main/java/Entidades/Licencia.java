/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Daniel y oscar
 */
@Entity
/**
 * Nombre de la tabla
 */
@Table(name="Licencias")
/**
 * Valor que se le da al valor
 * discriminante
 */
@DiscriminatorValue(value="Licencia")
public class Licencia extends Tramite implements Serializable {

    
    /**
     * Vigencia de la licencia
     */
    @Column(name="Vigencia")
    private int vigencia;
    
    /**
     *
     * Estado de la licencia.
     */
    @Column(name = "Estado")
    private String estado;
    
    /**
     * Costo de la licencia
     */
    @Column(name="Costo")
    private float costo;

    /**
     * Constructor por defecto
     */
    public Licencia() {
    }

   
    /**
     * Constructor que regresa las variables vigencia estado 
     * y costo
     * @param Vigencia
     * @param estado
     * @param costo 
     */
    public Licencia(int Vigencia, String estado, float costo) {
        this.vigencia = Vigencia;
        this.estado=estado;
        this.costo = costo;
    }

    /**
     * Constructor que regresa las variables vigencia, estado 
     * costo, fechaRecepcion, fechaEmision y persona
     * @param vigencia
     * @param estado
     * @param costo
     * @param fechaRecepcion
     * @param fechaEmision
     * @param persona 
     */
    public Licencia(int vigencia,String estado, float costo, Date fechaRecepcion, Date fechaEmision, Persona persona) {
        super(fechaRecepcion, fechaEmision, persona);
        this.vigencia = vigencia;
        this.estado=estado;
        this.costo = costo;
    }
   
   
    /**
     * Metodo que obtiene la vigencia de la licencia
     * @return vigencia
     */
    public int getVigencia() {
        return vigencia;
    }

    /**
     * Metodo que establece la vigencia de
     * la licencia
     * @param Vigencia 
     */
    public void setVigencia(int Vigencia) {
        this.vigencia = Vigencia;
    }

    /**
     * Metodo que regresa el costo de la licencia
     * @return costo
     */
    public float getCosto() {
        return costo;
    }

    /**
     * Metodo que establece el costo de la licencia
     * @param costo
     */
    public void setCosto(float costo) {
        this.costo = costo;
    }

    /**
     * Metodo que regresa el estado de la
     * licencia
     * @return estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Metodo que establece el estado de la
     * licencia
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    

   
    
}
