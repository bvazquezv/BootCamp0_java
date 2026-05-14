import java.math.BigDecimal;
import java.util.Objects;


public record ProductStats( String sku, String nombre, String categoria, Money precio, int stock, int ventas) {

    public ProductStats {
    Objects.requireNonNull(sku, "sku no puede ser null");
    Objects.requireNonNull(nombre,"nombre no puede ser null");
        Objects.requireNonNull(categoria,"Categoria no puede ser null");
        Objects.requireNonNull(precio,"precio no puede ser null");
        Objects.requireNonNull(stock,"stock no puede ser null");
        Objects.requireNonNull(ventas,"Ventas no puede ser null");

}
    }



