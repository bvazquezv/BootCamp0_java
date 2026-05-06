package Pattern;

import java.math.BigDecimal;

public interface ShippingStrategy {

   BigDecimal calcularCosto(double pesoKg, String origen, String destino);
   String getEstimadoDias();
}
