import java.time.LocalDateTime;

public abstract class InventoryItem {


    protected Long id;
    protected String nombre;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    protected String descripcion;
    protected boolean activo;
    protected LocalDateTime fechaCreacion;


    public InventoryItem(String nombre, String descripcion) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = true;
        this.fechaCreacion = LocalDateTime.now();
    }


    public boolean isActivo() {
        return activo;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{id=" + id +
                ", nombre='" + nombre + '\'' +
                ", activo=" + activo +
                '}';
    }
}