package Vehicles;

import java.math.BigDecimal;

public class ElectricCar extends Car{

    @Override
    BigDecimal calcularCostoTotal(int dias) {
        return super.calcularCostoTotal(dias).add(new BigDecimal(50));
    }
}
