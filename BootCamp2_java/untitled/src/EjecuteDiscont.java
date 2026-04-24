import java.math.BigDecimal;

public class EjecuteDiscont {

    public static void main(String[] args) {
        DiscountStrategy objSeason = new SeasonDiscount();
        DiscountStrategy objDiscont = new BulkDiscount();
        PriceCalculator calculator = new PriceCalculator(objDiscont);
        //  PriceCalculator  acepta cualquier estrategia de descuento


        Product p = new Product("Laptop", "computadira personal", new BigDecimal(10), 10, "Electronica");
        calculator.discont.calcular(new BigDecimal(10));
    }
}
