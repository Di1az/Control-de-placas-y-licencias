package Entidades;

import Entidades.Persona;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-04-12T17:11:47")
@StaticMetamodel(Tramite.class)
public abstract class Tramite_ { 

    public static volatile SingularAttribute<Tramite, Persona> persona;
    public static volatile SingularAttribute<Tramite, Date> fechaEmision;
    public static volatile SingularAttribute<Tramite, Integer> id;
    public static volatile SingularAttribute<Tramite, Date> fechaRecepcion;

}