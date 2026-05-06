package Pattern;

import java.math.BigDecimal;

public class SameDayShipping implements ShippingStrategy {
    @Override
    public BigDecimal calcularCosto(double pesoKg, String origen, String destino) {
        System.out.println("SameDayShipping");
        return  new BigDecimal (50*pesoKg).add(new BigDecimal("300"));
    }

    @Override
    public String getEstimadoDias() {
        return "1";
    }
}
