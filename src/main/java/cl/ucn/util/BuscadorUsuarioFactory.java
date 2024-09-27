package cl.ucn.util;

import cl.ucn.modelo.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class BuscadorUsuarioFactory {

    private static Util util = new Util();

    public static Usuario buscarUsuario(int rut, EntityManager em) {
        Usuario usuario = buscarEnBD(rut, em);
        if (usuario == null) {
            System.out.println("Buscando en archivo CSV...");
            usuario = buscarEnCSV(rut);
        }
        return usuario;
    }

    private static Usuario buscarEnBD(int rut, EntityManager em) {

    }

    private static Usuario buscarEnCSV(int rut) {

        return null;
    }
}
