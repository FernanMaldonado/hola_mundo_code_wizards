public class Agenda {
    private int codigo;
    private String nombre;
    private String apellido;
    private String telefono;
    private String descripcion;

    public Agenda(int codigo, String nombre, String apellido, String telefono, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.descripcion = descripcion;
    }

    public Agenda(String nombre, String apellido, String telefono, String descripcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.descripcion = descripcion;
    }

    public int getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getTelefono() { return telefono; }
    public String getDescripcion() { return descripcion; }
}
