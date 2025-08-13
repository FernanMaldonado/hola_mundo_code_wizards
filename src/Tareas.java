public class Tareas {
    private static int contador = 1;
    private int codigoTarea;
    private String nombreTarea;
    private String descripcion;

    public Tareas(String nombreTarea, String descripcion) {
        this.codigoTarea = contador++;
        this.nombreTarea = nombreTarea;
        this.descripcion = descripcion;
    }

    public int getCodigoTarea() {
        return codigoTarea;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Código: " + codigoTarea +
                ", Nombre: " + nombreTarea +
                ", Descripción: " + descripcion;
    }
}
