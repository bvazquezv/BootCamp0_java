import java.math.BigDecimal;

@FunctionalInterface
public interface DiscountStrategy {

    BigDecimal calcular(BigDecimal precioBase);
}
