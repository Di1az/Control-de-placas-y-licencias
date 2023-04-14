/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Licencia;
import Entidades.Persona;
import Entidades.Placa;
import Entidades.Tramite;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author oscar
 */
public class TramiteDAO implements ITramiteDAO{

    /**
     * Objeto para la conexion a la BD
     */
    private IConexionBD conexionBD;
    
    /**
     * Método constructor que crea la conexion con la base de datos
     * @param conexionBD objeto para la conexión
     */
    public TramiteDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public List<Tramite> ListaTramite(boolean licencia, boolean placa, Date fecha_inicio, Date fecha_fin) {
        EntityManager entityManager = this.conexionBD.Conexion();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tramite> criteriaQuery = criteriaBuilder.createQuery(Tramite.class);
        Root<Tramite> tramite = criteriaQuery.from(Tramite.class);
        criteriaQuery.select(tramite);

        Join<Tramite, Persona> persona = tramite.join("persona");

        List<Predicate> predicados = new ArrayList<Predicate>();

        if (licencia && !placa) {
            Predicate p1 = criteriaBuilder.equal(criteriaBuilder.literal(Licencia.class), tramite.type());
            predicados.add(p1);
        } else if (placa && !licencia) {
            Predicate p2 = criteriaBuilder.equal(criteriaBuilder.literal(Placa.class), tramite.type());
            predicados.add(p2);
        } else if (licencia && placa) {
            Predicate p1 = criteriaBuilder.equal(criteriaBuilder.literal(Licencia.class), tramite.type());
            Predicate p2 = criteriaBuilder.equal(criteriaBuilder.literal(Placa.class), tramite.type());
            predicados.add(criteriaBuilder.or(p1, p2));
        }
        if (fecha_inicio != null && fecha_fin != null) {
//            java.sql.Date fechaInicioSQL = java.sql.Date.valueOf(fechaInicio);
//            java.sql.Date fechaFinSQL = java.sql.Date.valueOf(fechaFin);
            predicados.add(criteriaBuilder.between(tramite.get("fechaEmision"), fecha_inicio, fecha_fin));
        }

        if (!predicados.isEmpty()) {
            criteriaQuery.where(criteriaBuilder.and(predicados.toArray(new Predicate[predicados.size()])));
        }

        TypedQuery<Tramite> query = entityManager.createQuery(criteriaQuery);
        List<Tramite> listaTramites = query.getResultList();
        entityManager.getTransaction().commit();

        return listaTramites;
    }

    
    
   
    
    
}
