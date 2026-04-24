import java.math.BigDecimal;

public class BulkDiscount implements DiscountStrategy{
    @Override
    public BigDecimal calcular(BigDecimal precioBase) {
        System.out.println("descuent por volumen");
        return null;
    }
}
