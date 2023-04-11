/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Licencia;
import java.util.List;

/**
 * Interfaz de LicenciaDAO
 * @author Dany
 */
public interface ILicenciaDAO {
    
    /**
     * Método que agrega a la bd una licencia
     * @param licencia licencia a agregar
     * @return una licencia si se agrega, null de lo contrario
     */
    public Licencia agregarLicencia (Licencia licencia);
    
    /**
     * Método que regresa la lista de las licencias
     * @return lista de licencias
     */
    public List <Licencia> listaLicencia();
}