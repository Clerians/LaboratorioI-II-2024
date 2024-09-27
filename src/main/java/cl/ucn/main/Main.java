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


        if (usuario != null && usuario.getRecursosMultimedia() != null) {
            RecursosMultimedia recurso = usuario.getRecursosMultimedia();

            ArchivoProxy archivoProxy = new ArchivoProxy(usuario, recurso);
            archivoProxy.cargar(); // Intenta cargar el archivo
            archivoProxy.mostrar(); // Intenta mostrar el archivo
        }

        em.close();

    }
}
