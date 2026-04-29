import java.math.BigDecimal;

public class CallBuilder {



    public static void main(String[] args) {
        // Demuestra que el Builder produce código más legible que un constructor de 8 parámetros
        Product obj = new ProductBuilder()
        .categoria("categoria")
        .nombre("nombre")
        .precio(new BigDecimal(20.0))
        .build();
    }




}
