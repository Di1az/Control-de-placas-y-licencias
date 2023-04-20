/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 * Clase utilizada para la generación del reporte en PDF
 * @author dany
 */
public class Reporte {
    
    /**
     * Atributo de tipo String que se refiere al tipo de tramite (licencia o placa)
     */
    private String tipoTramite;
    
    /**
     * Atributo de tipo String que se refiere al nombre de la persona que hizo
     * el tramite
     */
    private String nombre;
    
    /**
     * Atributo de tipo String que se refiere al costo del tramite
     */
    private String costo;
    
    /**
     * Atributo de tipo String que se refiere a la fecha en que se saco el tramite
     */
    private String fecha;
    
    /**
     * Método constructor que inicializa los atributos
     * @param tipoTramite placa o licencia
     * @param nombre nombre del que tramito
     * @param costo costo del tramite
     * @param fecha fecha en que se hizo el tramite
     */
    public Reporte(String tipoTramite, String nombre, String costo, String fecha) {
        this.tipoTramite = tipoTramite;
        this.nombre = nombre;
        this.costo = costo;
        this.fecha = fecha;
    }
    
    /**
     * Método constructor por omisión
     */
    public Reporte() {
    }
    
    /**
     * Método getter para el tipo de tramite
     * @return licencia o placa
     */
    public String getTipoTramite() {
        return tipoTramite;
    }
    
    /**
     * Método setter para setearle la informacion al tipo de tramite
     * @param tipoTramite licencia o placa
     */
    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }
    
    /**
     * Método getter para obtener el nombre
     * @return nombre nombre de la persona que tramito
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Método setter para setearle el nombre
     * @param nombre nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Método getter para obtener el costo del tramite
     * @return el costo del tramite
     */
    public String getCosto() {
        return costo;
    }
    
    /**
     * Método setter para setear el costo
     * @param costo costo del tramite
     */
    public void setCosto(String costo) {
        this.costo = costo;
    }
    
    /**
     * Método getter para obtener la fecha del tramite
     * @return fecha del tramite
     */
    public String getFecha() {
        return fecha;
    }
    
    /**
     * Método setter para setear la fecha
     * @param fecha fecha del tramite
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
