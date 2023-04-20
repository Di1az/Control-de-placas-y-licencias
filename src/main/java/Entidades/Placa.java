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
import javax.persistence.DiscriminatorValue;
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
/**
 *
 * Clase que representa un trámite para obtener una placa de vehículo.
 *
 * Extiende de la clase Tramite y utiliza la anotación @DiscriminatorValue para
 * su discriminación en la base de datos.
 *
 * Contiene información sobre el costo, número de placa, estado y vehículo
 * asociado.
 */
@Entity
/**
 * Nombre de la tabla
 */
@Table(name = "Placas")
@DiscriminatorValue(value = "Placa")
public class Placa extends Tramite implements Serializable {

    /**
     *
     * Costo del trámite de obtención de la placa.
     */
    @Column(name = "Costo")
    private float costo;
    /**
     *
     * Número de la placa.
     */
    @Column(name = "Número_placa")
    private String numeroPlaca;
    /**
     *
     * Estado de la placa.
     */
    @Column(name = "Estado")
    private String estado;
    /**
     *
     * Vehículo asociado a la placa.
     */
    @ManyToOne
    @JoinColumn(name = "Id_vehiculo")
    private Vehiculo vehiculo;

    /**
     *
     * Constructor por defecto de la clase Placa.
     */
    public Placa() {
    }

    /**
     *
     * Constructor de la clase Placa que recibe el costo, número de placa y
     * estado de la misma.
     *
     * @param costo Costo del trámite de obtención de la placa.
     * @param numeroPlaca Número de la placa.
     * @param estado Estado de la placa.
     */
    public Placa(float costo, String numeroPlaca, String estado) {

        this.costo = costo;
        this.numeroPlaca = numeroPlaca;
        this.estado = estado;
    }

    /**
     *
     * Constructor de la clase Placa que recibe el costo, número de placa,
     * estado y vehículo asociado a la placa.
     *
     * @param costo Costo del trámite de obtención de la placa.
     * @param numeroPlaca Número de la placa.
     * @param estado Estado de la placa.
     * @param vehiculo Vehículo asociado a la placa.
     * @param fechaRecepcion Fecha de recepción del trámite.
     * @param fechaEmision Fecha de emisión del trámite.
     */
    public Placa(float costo, String numeroPlaca, String estado, Vehiculo vehiculo, Date fechaRecepcion, Date fechaEmision) {
        super(fechaRecepcion, fechaEmision);
        this.costo = costo;
        this.numeroPlaca = numeroPlaca;
        this.estado = estado;
        this.vehiculo = vehiculo;
    }

    /**
     *
     * Constructor de la clase Placa que recibe el costo, número de placa,
     * estado, vehículo asociado a la placa y persona que realizó el trámite.
     *
     * @param costo Costo del trámite de obtención de la placa.
     * @param numeroPlaca Número de la placa.
     * @param estado Estado de la placa.
     * @param vehiculo Vehículo asociado a la placa.
     * @param fechaRecepcion Fecha de recepción del trámite.
     * @param fechaEmision Fecha de emisión del trámite.
     * @param persona Persona que realizó el trámite.
     */
    public Placa(float costo, String numeroPlaca, String estado, Vehiculo vehiculo, Date fechaRecepcion, Date fechaEmision, Persona persona) {
        super(fechaRecepcion, fechaEmision, persona);
        this.costo = costo;
        this.numeroPlaca = numeroPlaca;
        this.estado = estado;
        this.vehiculo = vehiculo;
    }

    /**
     * Metodo que regresa el costo de la placa
     *
     * @return costo
     */
    public float getCosto() {
        return costo;
    }

    /**
     * Metodo que establece el costo de la placa
     *
     * @param costo
     */
    public void setCosto(float costo) {
        this.costo = costo;
    }

    /**
     * Metodo que regresa el numero de la placa
     *
     * @return numeroPlaca
     */
    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    /**
     * Metodo que establece el numero de la placa
     *
     * @param numeroPlaca
     */
    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    /**
     * Metodo que regresa el estado
     *
     * @return estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Metodo que establece el estado
     *
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

}
