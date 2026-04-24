import java.math.BigDecimal;

public class CreateProductDTO extends  Product{
    public CreateProductDTO(String nombre, String descripcion, BigDecimal precio, int stock, String categoria) {
        super(nombre, descripcion, precio, stock, categoria);
    }
}
