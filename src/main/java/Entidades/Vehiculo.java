/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author oscar
 */
@Entity
/**
 * Nombre de la tabla
 */
@Table(name = "Vehículos")
public class Vehiculo implements Serializable {

    /**
     * Id del vehiculo
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Vehículo")
    private Integer id;

    /**
     * Numero del vehiculo
     */
    @Column(name = "Número")
    private String numero;

    /**
     * Marca del vehiculo
     */
    @Column(name = "Marca")
    private String marca;

    /**
     * Modelo del vehiculo
     */
    @Column(name = "Modelo")
    private String modelo;

    /**
     * Linea del vehiculo
     */
    @Column(name = "Línea")
    private String linea;

    /**
     * color del vehiculo
     */
    @Column(name = "Color")
    private String color;

    /**
     * Tipo del vehiculo
     */
    @Column(name = "Tipo")
    private String tipo;

    /**
     * Estado del vehiculo
     */
    @Column(name = "Estado")
    private String estado;

    /**
     * Persona asociada a vehiculo
     */
    @ManyToOne
    @JoinColumn(name = "Id_Persona")
    private Persona persona;

    /**
     * Placas asociadas al vehiculo
     */
    @OneToMany(mappedBy = "Vehiculo", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Placa> placas;

    /**
     * Constructor por defecto
     */
    public Vehiculo() {
    }

    /**
     * Metodo constructor que establece todas las variables al valor de sus
     * parametros
     *
     * @param id
     * @param numero
     * @param marca
     * @param modelo
     * @param linea
     * @param color
     * @param tipo
     * @param estado
     * @param persona
     */
    public Vehiculo(Integer id, String numero, String marca, String modelo, String linea, String color, String tipo, String estado, Persona persona) {
        this.id = id;
        this.numero = numero;
        this.marca = marca;
        this.modelo = modelo;
        this.linea = linea;
        this.color = color;
        this.tipo = tipo;
        this.estado = estado;
        this.persona = persona;
    }

    /**
     * Metodo constructor que establece todas las variables al valor de sus
     * parametros excepto el id
     *
     * @param numero
     * @param marca
     * @param modelo
     * @param linea
     * @param color
     * @param tipo
     * @param estado
     * @param persona
     */
    public Vehiculo(String numero, String marca, String modelo, String linea, String color, String tipo, String estado, Persona persona) {
        this.numero = numero;
        this.marca = marca;
        this.modelo = modelo;
        this.linea = linea;
        this.color = color;
        this.tipo = tipo;
        this.estado = estado;
        this.persona = persona;
    }

    /**
     * Metodo constructor que establece todas las variables al valor de sus
     * parametros
     *
     * @param numero
     * @param marca
     * @param modelo
     * @param linea
     * @param color
     * @param tipo
     * @param estado
     * @param persona
     * @param placas
     */
    public Vehiculo(String numero, String marca, String modelo, String linea, String color, String tipo, String estado, Persona persona, List<Placa> placas) {
        this.numero = numero;
        this.marca = marca;
        this.modelo = modelo;
        this.linea = linea;
        this.color = color;
        this.tipo = tipo;
        this.estado = estado;
        this.persona = persona;
        this.placas = placas;
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
     * Hash code
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
     * Metodo equal
     *
     * @param object
     * @return true or false
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Metodo to string
     *
     * @return marca + " " + linea + " " + modelo
     */
    @Override
    public String toString() {
        return marca + " " + linea + " " + modelo;
    }

    /**
     * Metodo que regresa la persona
     * @return persona
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Metodo que establece la persona
     * @param persona 
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Metodo que regresa el numero
     * @return numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Metodo que establece el numero
     * @param numero 
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Metodo que regresa la marca
     * @return marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Metodo que establece la marca
     * @param marca 
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Metodo que regresa el modelo
     * @return modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Metodo que establece el modelo
     * @param modelo 
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Metodo que regresa la linea
     * @return 
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Metodo que establece la linea
     * @param linea 
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Metodo que regresa el color
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * Metodo que establece el color
     * @param color 
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Metodo que regresa el tipo
     * @return 
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Metodo que establece el tipo
     * @param tipo 
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo que regresa el estado
     * @return 
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Metodo que establece el estado
     * @param estado 
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

}
