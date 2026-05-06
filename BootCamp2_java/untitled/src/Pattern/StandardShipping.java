package Pattern;

import java.math.BigDecimal;

public class StandardShipping implements ShippingStrategy {
    @Override
    public BigDecimal calcularCosto(double pesoKg, String origen, String destino) {
        System.out.println("StandardShipping");
        return  new BigDecimal (50*pesoKg);
    }

    @Override
    public String getEstimadoDias() {
        return "5-7";
    }
}
