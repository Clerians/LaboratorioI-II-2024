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
        String jpql = "SELECT u from Usuario u WHERE u.rut = :rut";
        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
        query.setParameter("rut", rut);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Usuario no encontrado en la base de datos.");
            return null;
        }
    }

    private static Usuario buscarEnCSV(int rut) {
        List<Usuario> usuariosCSV = util.loadCsv();
        for (Usuario usuario : usuariosCSV) {
            if (usuario.getRut() == rut) {
                System.out.println("Usuario encontrado en archivo CSV.");
                return usuario;
            }
        }
        System.out.println("Usuario no encontrado en el archivo CSV.");
        return null;
    }
}
