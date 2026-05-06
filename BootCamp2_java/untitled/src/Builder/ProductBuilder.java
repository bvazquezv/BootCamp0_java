package Builder;

import Strategy.Product;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductBuilder {

    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private int stock = 0; // valor por defecto
    private String categoria;
    private boolean activo = true; //
    private String marca;
    private int mesesGarantia = 12; //


    public ProductBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ProductBuilder descripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public ProductBuilder precio(BigDecimal precio) {
        this.precio = precio;
        return this;
    }

    public ProductBuilder precio(String precio) {
        this.precio = new BigDecimal(precio);
        return this;
    }

    public ProductBuilder stock(int stock) {
        this.stock = stock;
        return this;
    }

    public ProductBuilder categoria(String categoria) {
        this.categoria = categoria;
        return this;
    }

    public ProductBuilder inactivo() {
        this.activo = false;
        return this;
    }

    public ProductBuilder marca(String marca) {
        this.marca = marca;
        return this;
    }

    public ProductBuilder garantia(int meses) {
        this.mesesGarantia = meses;
        return this;
    }

    public Product build() {
        // Validaciones antes de crear el objeto

        System.out.println("inicia validaciones");
        Objects.requireNonNull(nombre, "Nombre es obligatorio");
        Objects.requireNonNull(precio, "Precio es obligatorio");
        Objects.requireNonNull(categoria, "Categoría es obligatoria");
        System.out.println("Objeto Creado");
        return new Product(
                nombre,
                descripcion,
                precio,
                stock,
                categoria
        );



    }
}