package cl.ucn.main;

import cl.ucn.modelo.Usuario;
import jakarta.persistence.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("multimediaApp");
        EntityManager em = emf.createEntityManager();

        int rut = 89830291;
        Usuario usuario = BuscadorUsuarioFactory.buscarUsuario(rut, em);

        if (usuario != null) {
            System.out.println("El usuario " + usuario.getRut() + " existe!");
        } else {
            System.out.println("El usuario no existe!");
        }


        /*jpql = "SELECT u from Usuario u";
        TypedQuery<Usuario> query1 = em.createQuery(jpql, Usuario.class);
        List<Usuario> usuarios = query1.getResultList();
        for (Usuario usuario : usuarios){

            System.out.println("Rut: " + usuario.getRut() + " Permiso: " + usuario.isTienePermiso() + " Archivo: " +
                    usuario.getRecursosMultimedia().getNombre() + " Protegido: " + usuario.getRecursosMultimedia().isProtegido());

        }*/

        em.close();

    }
}
