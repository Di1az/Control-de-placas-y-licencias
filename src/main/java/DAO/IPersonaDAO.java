/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Entidades.Persona;
import java.util.List;

/**
 *
 * @author oscar
 */
public interface IPersonaDAO {
    public Persona registrarPersona(Persona persona);
    
    /**
     * Método que devuelve una lista de todas las personas
     * @return lista de personas
     */
    public List<Persona> listaPersona();
    
    /**
     * Método que comprueba si la rfc introducida existe
     * @param RFC rfc de la persona
     * @return persona encontrada, null de lo contrario
     */
    public Persona buscarPersona(String RFC);
    }
     
