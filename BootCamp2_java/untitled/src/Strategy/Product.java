package Strategy;

import java.math.BigDecimal;

public class Product extends InventoryItem {





    // Campos propios de Strategy.Product (además de los heredados)
    private BigDecimal precio;
    private int stock;

    public String getCategoria() {
        return categoria;
    }

    private String categoria;
    private String sku; // Stock Keeping Unit

    public Product(
            String nombre,
            String descripcion,
            BigDecimal precio,
            int stock,
            String categoria
    ) {
        // OBLIGATORIO: primero llamar al padre
        super(nombre, descripcion);
        setPrecio(precio);
        setStock(stock);
        this.categoria = categoria;
        this.sku = generarSKU(categoria, nombre);
    }


    public Product(
           CreateProductDTO dto
    ) {
        // OBLIGATORIO: primero llamar al padre
        super(dto.getNombre(), dto.getDescripcion());
        setPrecio(dto.getPrecio());
        setStock(dto.getStock());
        //Categoria
        //sku
    }



    // Comportamiento específico de Strategy.Product
    public boolean puedeVender(int cantidad) {
        return activo && this.stock >= cantidad;
    }

    public void reducirStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad debe ser > 0");
        }

        if (this.stock < cantidad) {
          throw  new IllegalArgumentException("La cantidad no puede ser mayor al stock");
        }

        this.stock -= cantidad;
    }

    // @Override: sobreescribe toString del padre con más información
    @Override
    public String toString() {
        return "Strategy.Product{"
                + "sku='" + sku + '\''
                + ", nombre='" + nombre + '\''
                + ", precio=" + precio
                + ", stock=" + stock
                + '}';
    }


    // Getters y setters con validación
    public BigDecimal getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getSku() {
        return sku;
    }

    public void setPrecio(BigDecimal precio) {
        if (precio == null || precio.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Precio no puede ser negativo");
        }
        this.precio = precio;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("Stock no puede ser negativo");
        }
        this.stock = stock;
    }

    private String generarSKU(String categoria, String nombre) {
        return categoria.substring(0, 3).toUpperCase()
                + "-"
                + nombre.replaceAll("\\s+", "")
                .substring(0, 3)
                .toUpperCase()
                + "-"
                + System.currentTimeMillis() % 10000;
    }
}