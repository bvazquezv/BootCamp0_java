package Pattern;

public class ShippingStrategyFactory {

    static ShippingStrategy getStrategy(TipoEnvio tipo)
    {
        switch (tipo)
        {
            case EXPRESS_SHIPPING:
               return  new ExpressShipping();

            case INTERNATIONAL_SHIPPING:
                return  new InternationalShipping();
            case SAMEDAY_SHIPPING:
                return  new SameDayShipping();
            case STANDAR_SHIPPING:
                return  new StandardShipping();

            default:
                throw new IllegalArgumentException("Tipo no soportado");

        }



    }

}
