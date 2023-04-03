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
    public List<Persona> listaPersona();
    }
     
