package Pattern;

import java.math.BigDecimal;

public class Order {
    public  ShippingStrategy  spStrategy;
    ShippingStrategy calcularEnvío(ShippingStrategy vspStrategy)
    {
        spStrategy=vspStrategy;
return spStrategy;
    }

}
