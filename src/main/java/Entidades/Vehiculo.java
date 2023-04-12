/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author oscar
 */
@Entity
@Table(name="Vehículos")
public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Vehículo")
    private Integer id;
    
    @Column(name = "Número")
    private String numero;
   
    @Column(name = "Marca")
    private String marca;
    
    @Column(name = "Modelo")
    private String modelo;
   
    @Column(name = "Línea")
    private String linea;
    
    @Column(name = "Color")
    private String color;
    
    @Column(name = "Tipo")
    private String tipo;
   
    @Column(name = "Estado")
    private String estado;
    
    @ManyToOne
    @JoinColumn(name = "Id_Persona")
    private Persona persona;

    public Vehiculo() {
    }

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
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    /*
    @Override
    public String toString() {
        return "Entidades.Vehiculo[ id=" + id + " ]";
    }
    */  
    
    @Override
    public String toString() {
        return marca + " " + linea + " " + modelo;
    }
    
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
