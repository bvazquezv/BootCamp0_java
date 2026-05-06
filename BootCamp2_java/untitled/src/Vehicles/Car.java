package Vehicles;

import java.math.BigDecimal;

public class Car extends Vehicle{

    int numPasajeros;

    @Override
    BigDecimal calcularCostoTotal(int dias) {
        return  new BigDecimal(String.valueOf(precioPorDia)).multiply(BigDecimal.valueOf(dias));
    }
}
