package Pattern;

import java.math.BigDecimal;

public class ExpressShipping implements ShippingStrategy {
    @Override
    public BigDecimal calcularCosto(double pesoKg, String origen, String destino) {
        System.out.println("ExpressShipping");
        return  new BigDecimal (150*pesoKg);
    }

    @Override
    public String getEstimadoDias() {
        return "1-2";
    }
}
