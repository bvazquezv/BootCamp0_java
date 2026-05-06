package Strategy;

import java.math.BigDecimal;

public class FriendsDiscount implements DiscountStrategy {
    @Override
    public BigDecimal calcular(BigDecimal precioBase) {

        System.out.println("descuento para amigos");

        return null;
    }
}
