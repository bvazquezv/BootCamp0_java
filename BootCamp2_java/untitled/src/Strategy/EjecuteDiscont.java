package Strategy;

import java.math.BigDecimal;

public class EjecuteDiscont {

    public static void main(String[] args) {
        DiscountStrategy objSeason = new SeasonDiscount();
        DiscountStrategy objDiscont = new BulkDiscount();
        DiscountStrategy  objFriendsDiscunt = new  FriendsDiscount();
        DiscountStrategy objDiscChrismas = new ChristmasDiscount();

        PriceCalculator calculator = new PriceCalculator(objDiscont);
        //  Strategy.PriceCalculator  acepta cualquier estrategia de descuento
        Product p = new Product("FFF", "FFF", new BigDecimal(10), 10, "Electronica");

        calculator.discont.calcular(new BigDecimal(10));
    }
}





