import java.math.BigDecimal;

public class DigitalProduct extends Product {


    private String urlDescarga;
    private String licencia; // "SINGLE", "MULTI", "ENTERPRISE"
    private int maxDescargas;

    public DigitalProduct(
            String nombre,
            String descripcion,
            BigDecimal precio,
            String licencia
    ) {
        // Hereda de Product — stock es siempre ilimitado para digitales
        super(nombre, descripcion, precio, Integer.MAX_VALUE, "Digital");

        this.licencia = licencia;
        this.maxDescargas = licencia.equals("SINGLE")
                ? 3
                : Integer.MAX_VALUE;
    }



    @Override
    public boolean puedeVender(int cantidad) {
        return activo; // No depende del stock
    }

    @Override
    public void reducirStock(int cantidad) {
        // No reducir stock para productos digitales — sobreescribir para no-op
        // Solo registrar la descarga
    }
}