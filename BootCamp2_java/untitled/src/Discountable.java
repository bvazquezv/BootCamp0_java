import java.math.BigDecimal;

public interface Discountable {


    BigDecimal calcularPrecioConDescuento(BigDecimal porcentaje);


    boolean esElegibleParaDescuento(String tipoDescuento);

    default BigDecimal calcularDescuentoMaximo() {
        // 30% máximo
        return calcularPrecioConDescuento(new BigDecimal("0.30"));
    }

    static boolean esDescuentoValido(BigDecimal porcentaje) {
        return porcentaje != null
                && porcentaje.compareTo(BigDecimal.ZERO) > 0
                && porcentaje.compareTo(BigDecimal.ONE) <= 0;
    }
}