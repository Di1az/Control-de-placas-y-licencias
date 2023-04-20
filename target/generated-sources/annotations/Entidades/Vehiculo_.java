package Entidades;

import Entidades.Persona;
import Entidades.Placa;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-04-19T23:19:32")
@StaticMetamodel(Vehiculo.class)
public class Vehiculo_ { 

    public static volatile SingularAttribute<Vehiculo, String> marca;
    public static volatile SingularAttribute<Vehiculo, String> tipo;
    public static volatile SingularAttribute<Vehiculo, String> estado;
    public static volatile SingularAttribute<Vehiculo, Persona> persona;
    public static volatile SingularAttribute<Vehiculo, String> numero;
    public static volatile SingularAttribute<Vehiculo, String> color;
    public static volatile SingularAttribute<Vehiculo, Integer> id;
    public static volatile SingularAttribute<Vehiculo, String> modelo;
    public static volatile SingularAttribute<Vehiculo, String> linea;
    public static volatile ListAttribute<Vehiculo, Placa> placas;

}