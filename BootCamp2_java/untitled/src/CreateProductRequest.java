import java.math.BigDecimal;

public record CreateProductRequest(
        String nombre,
        BigDecimal precio,
        int stock,
        Long categoriaId
) {

    // Compact constructor — para validaciones
    public CreateProductRequest {

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre es requerido");
        }

        if (precio == null || precio.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Precio debe ser mayor a 0");
        }

        if (stock < 0) {
            throw new IllegalArgumentException("Stock no puede ser negativo");
        }

        // Normalización de datos (también en compact constructor)
        nombre = nombre.strip();
    }
}