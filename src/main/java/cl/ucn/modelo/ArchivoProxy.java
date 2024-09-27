package cl.ucn.modelo;

public class ArchivoProxy extends RecursosMultimedia {

    private Usuario usuario;
    private RecursosMultimedia recursosMultimedia;

    public ArchivoProxy(Usuario usuario, RecursosMultimedia recursosMultimedia) {
        this.usuario = usuario;
        this.recursosMultimedia = recursosMultimedia;
    }

    @Override
    public void cargar() {
        if (usuario.isTienePermiso()) {
            recursosMultimedia.cargar();
        } else {
            System.out.println("Acceso denegado. El usuario no tiene permiso para cargar este archivo.");
        }
    }

    @Override
    public void mostrar() {
        if (usuario.isTienePermiso()) {
            recursosMultimedia.mostrar();
        } else {
            System.out.println("Acceso denegado. El usuario no tiene permiso para visualizar este archivo.");
        }
    }
}
