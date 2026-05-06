import Strategy.Product;

import java.math.BigDecimal;

public record ProductResponse(
        Long id,
        String sku,
        String nombre,
        BigDecimal precio,
        int stock,
        String categoria,
        boolean activo
) {


    // Método factory desde entidad
    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getSku(),
                product.getNombre(),
                product.getPrecio(),
                product.getStock(),
                product.getCategoria(),
                product.isActivo()
        );
    }
}
