package Vehicles;

import java.math.BigDecimal;

public class Truck extends  Vehicle{
    boolean capacidadToneladass;
        @Override
                BigDecimal calcularCostoTotal(int dias) {
            return  new BigDecimal(String.valueOf(precioPorDia)).
                    multiply(BigDecimal.valueOf(dias)).
                    multiply(new BigDecimal("1.3"));
        }


}
