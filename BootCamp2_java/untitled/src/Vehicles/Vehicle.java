package Vehicles;

import java.math.BigDecimal;

public abstract class Vehicle {

   String placa;
   String  marca;
   String modelo;
   int año;
   BigDecimal precioPorDia;
   abstract  BigDecimal calcularCostoTotal(int dias);

}
