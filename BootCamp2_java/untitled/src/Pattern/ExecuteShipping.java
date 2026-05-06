package Pattern;

import java.math.BigDecimal;

public class ExecuteShipping {

    public static void main(String[] args) {

        ShippingStrategy  strategy=  ShippingStrategyFactory.getStrategy(TipoEnvio.SAMEDAY_SHIPPING);
        Order order = new Order();
        BigDecimal costShipping= order.calcularEnvío(strategy).calcularCosto(20,"Origen","Destino");
        System.out.println(costShipping.toString());
    }
}
