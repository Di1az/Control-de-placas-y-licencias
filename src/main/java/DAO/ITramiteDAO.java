/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Entidades.Placa;
import Entidades.Tramite;
import java.util.Date;
import java.util.List;

/**
 * Interfaz a implementar en TramiteDAO con sus metodos
 * @author oscar
 */
public interface ITramiteDAO {
    
    /**
     * Método que genera una lista de los tramites con sus atributos
     * @param licencia booleano que se refiere si el tramite es una licencia o no
     * @param placa booleano que se refiere si el tramite es una placa o no
     * @param fecha_emision fecha en que saco el tramite
     * @param fecha_recepcion fecha en que se vence el documento (placa, licencia)
     * @return lista de tramites
     */
    public List<Tramite> ListaTramite(boolean licencia, boolean placa, Date fecha_emision, Date fecha_recepcion);
    
    
}
