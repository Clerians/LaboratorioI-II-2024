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

    }

    @Override
    public void mostrar() {

    }
}