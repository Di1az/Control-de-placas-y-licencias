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
 * Clase entidad de Licencia
 * @author Daniel y oscar
 */
@Entity
@Table(name="Licencias")
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
     * @param Vigencia vigencia de la licencia
     * @param estado estado de la licencia
     * @param costo costo de la licencia
     */
    public Licencia(int Vigencia, String estado, float costo) {
        this.vigencia = Vigencia;
        this.estado=estado;
        this.costo = costo;
    }

    /**
     * Constructor que regresa las variables vigencia, estado 
     * costo, fechaRecepcion, fechaEmision y persona
     * @param vigencia vigencia de la licencia
     * @param estado estado de la licencia
     * @param costo costo de la licencia
     * @param fechaRecepcion fecha de entrega de la licencia
     * @param fechaEmision fecha de vencimiento de la licencia
     * @param persona persona que saco la licencia
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
     * @param Vigencia vigencia de la licencia
     */
    public void setVigencia(int Vigencia) {
        this.vigencia = Vigencia;
    }

    /**
     * Metodo que regresa el costo de la licencia
     * @return costo de la licencia
     */
    public float getCosto() {
        return costo;
    }

    /**
     * Metodo que establece el costo de la licencia
     * @param costo costo de la licencia
     */
    public void setCosto(float costo) {
        this.costo = costo;
    }

    /**
     * Metodo que regresa el estado de la
     * licencia
     * @return estado de la licencia
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Metodo que establece el estado de la
     * licencia
     * @param estado estado de licencia
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    

   
    
}
