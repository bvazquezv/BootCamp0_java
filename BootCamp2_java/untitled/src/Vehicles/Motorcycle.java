package Vehicles;

import java.math.BigDecimal;

public class Motorcycle extends  Vehicle{
    @Override
    BigDecimal calcularCostoTotal(int dias) {
        return  new BigDecimal(String.valueOf(precioPorDia)).
                multiply(BigDecimal.valueOf(dias)).
                multiply(new BigDecimal("0.7"));
    }

}
