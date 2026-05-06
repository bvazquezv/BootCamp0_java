package Strategy;

import java.math.BigDecimal;

public class ChristmasDiscount implements DiscountStrategy{
    @Override
    public BigDecimal calcular(BigDecimal precioBase) {

        System.out.println("descuento navidad");
        return null;

    }
}
