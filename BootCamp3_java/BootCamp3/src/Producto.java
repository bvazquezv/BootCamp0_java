public class Producto { private Long id; private String sku; private String nombre;




    public Producto( Long id, String sku,  String nombre)
    {
        this.id=id;
        this.sku=sku;
        this.nombre=nombre;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", sku='" + sku + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}