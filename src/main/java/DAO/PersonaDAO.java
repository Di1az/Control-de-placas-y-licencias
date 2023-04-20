
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Encriptacion.Encriptar;
import Entidades.Persona;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * Clase que implementa la interfaz IPersonaDAO
 * @author oscar
 */
public class PersonaDAO implements IPersonaDAO {

    //Variable de conexion a la BD
    private IConexionBD conexionBD;

    /**
     * Metodo constructor que se encarga de obtener la conexion a la BD
     *
     * @param conexionBD conexionBD
     */
    public PersonaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     *
     * Método que permite registrar una nueva persona en la base de datos.
     * @param persona objeto de tipo Persona que se va a registrar en la base de
     * datos.
     * @return retorna el objeto Persona que se ha registrado en la base de
     * datos.
*
     */
    @Override
    public Persona registrarPersona(Persona persona) {
        EntityManager em = conexionBD.Conexion();
        Encriptar en = new Encriptar();
        String nombre = en.encriptar(persona.getNombre());
        String apellidoP = en.encriptar(persona.getApellidoP());
        String apellidoM = en.encriptar(persona.getApellidoM());
        persona.setNombre(nombre);
        persona.setApellidoP(apellidoP);
        persona.setApellidoM(apellidoM);
        try {
            em.getTransaction().begin();
            em.persist(persona); //Agrega la nueva persona en la base de datos
            em.getTransaction().commit();
            return persona;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    /**
     * Método que devuelve la lista de personas
     *
     * @return lista de personas
     */
    @Override
    public List<Persona> listaPersona() {
        EntityManager em = conexionBD.Conexion();
        try {
            em.getTransaction().begin();
            String jpql = "SELECT p FROM Persona p ";
            TypedQuery<Persona> query = em.createQuery(jpql, Persona.class);
            List<Persona> listaPersonas = query.getResultList();
            em.getTransaction().commit();

            for (Persona persona : listaPersonas) {
                
                
                
             persona=desencriptarPersona(persona);
             System.out.println(persona.getNombre());
                

            }
            return listaPersonas;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Método que por medio del rfc busca si una persona esta registrada en la
     * bd
     *
     * @param RFC rfc de la persona
     * @return la persona, null de lo contrario
     */
    @Override
    public Persona buscarPersona(String RFC) {
        EntityManager em = conexionBD.Conexion();
        try {
            em.getTransaction().begin();
            String jpql = "SELECT p FROM Persona p WHERE p.rfc = :rfc ";
            TypedQuery<Persona> query = em.createQuery(jpql, Persona.class);
            query.setParameter("rfc", RFC);
            Persona persona = query.getSingleResult();
            em.getTransaction().commit();
            return persona;
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * Metodo que se encarga de regresar una lista de persona dependiendo de la
     * RFC recibido en el parametro
     *
     * @param rfc RFC
     * @return persona
     */
    @Override
    public List<Persona> listaPersonasRFC(String rfc) {
        EntityManager em = conexionBD.Conexion();
        try {
            List<Persona> personaRFC = em.createQuery("SELECT p FROM Persona p WHERE p.rfc LIKE :rfc")
                    .setParameter("rfc", "%" + rfc + "%")
                    .getResultList();
            em.close();
            for (Persona persona : personaRFC) {
                desencriptarPersona(persona);
            }
            return personaRFC;
        } catch (Exception e) {
            if (em != null) {
                em.close();
            }
            return null;
        }
    }

    /**
     * Metodo que se encarga de regresar una lista de persona dependiendo de la
     * fecha de nacimientos recibida en el parametro
     *
     * @param fechaN fecha de nacimiento
     * @return persona
     */
    @Override
    public List<Persona> listaPersonasFechaN(Date fechaN) {
        EntityManager em = conexionBD.Conexion();
        try {
            List<Persona> personaFechaN = em.createQuery("SELECT p FROM Persona p WHERE p.fechaN = :fechaN")
                    .setParameter("fechaN", fechaN)
                    .getResultList();
            em.close();
            for (Persona persona : personaFechaN) {
                desencriptarPersona(persona);
            }
            return personaFechaN;
        } catch (Exception e) {

            if (em != null) {
                em.close();
            }
            return null;
        }
    }

    /**
     * Metodo que se encarga de desencriptar el nombre de la persona
     *
     * @param persona persona a desencriptar
     */
    public Persona desencriptarPersona(Persona persona) {
        Encriptar en = new Encriptar();
        String nombre = en.desencriptar(persona.getNombre());
        String apellidoP = en.desencriptar(persona.getApellidoP());
        String apellidoM = en.desencriptar(persona.getApellidoM());
        persona.setNombre(nombre);
        persona.setApellidoP(apellidoP);
        persona.setApellidoM(apellidoM);
        return persona;
    }
}
