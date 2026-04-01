public class Producto {
    private Long id;
    private String nombre;
    private double precio;
    private int stock;
    private boolean activo;


    // Constructor por defecto (sin parámetros)
    public Producto() {
        this.activo = true; // valor por defecto
    }

    // Constructor con todos los campos obligatorios
    public Producto(long id, String nombre, double precio, int stock) {
        this(); // Llama al constructor por defecto primero
        this.id= id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public static void main(String[] args) {

        Producto objProducto1= new Producto(1,"Producto1",20.23,10);


        objProducto1.tieneStock();  // Ejemplo para producto 1
        if (objProducto1.puedeVender(5))
        {    System.out.println("Puede vender reduce stock" );
             System.out.println("stock Actual"+ objProducto1.stock);
            objProducto1.reducirStock(5);
            System.out.println("stock actulizado"+ objProducto1.stock);
        }
        else
        {
            System.out.println("No Puede vender stock insuficeinte" );
            objProducto1.reducirStock(5); //lanza exepcion

        }
        System.out.println(
        objProducto1.toString());



    }


    public boolean tieneStock() {
        return this.stock > 0;
    }

    public boolean puedeVender(int cantidad) {
        return this.activo && this.stock >= cantidad;
    }

    public void reducirStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva");
        }

        if (this.stock < cantidad) {
            throw new IllegalStateException(
                    "Stock insuficiente: disponible=" + this.stock +
                            ", solicitado=" + cantidad
            );
        }

        this.stock -= cantidad;
    }


    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.precio = precio;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    // ── toString — Representación textual ─────────────────────────────
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", activo=" + activo +
                '}';
    }
}

