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
 *
 * @author oscar
 */
public interface ITramiteDAO {
    
    /**
     * 
     * @param licencia
     * @param placa
     * @param fecha_emision
     * @param fecha_recepcion
     * @return 
     */
    public List<Tramite> ListaTramite(boolean licencia, boolean placa, Date fecha_emision, Date fecha_recepcion);
    
    
}
