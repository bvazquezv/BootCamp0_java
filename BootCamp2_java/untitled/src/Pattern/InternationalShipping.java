package Pattern;

import java.math.BigDecimal;

public class InternationalShipping implements ShippingStrategy {
    @Override
    public BigDecimal calcularCosto(double pesoKg, String origen, String destino) {
        System.out.println("InternationalShipping");
        return  new BigDecimal (300*pesoKg).add(new BigDecimal("500").add(new BigDecimal(800*.20)));
    }

    @Override
    public String getEstimadoDias() {
        return "No definido";
    }
}
