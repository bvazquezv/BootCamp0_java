import Strategy.CreateProductDTO;
import Strategy.Product;

import java.math.BigDecimal;

public class CallService {

    public static void main(String[] args) {
        InMemoryProductRepository objRepository = new InMemoryProductRepository();
        ProductService service = new ProductService(objRepository);
        CreateProductDTO objProduct = new CreateProductDTO("FFF","SSS", new BigDecimal("10.3"),10,"Electronica");

        try {
            service.create(objProduct);
        } catch (Exception e)
        {
            System.out.println("No se guardo el producto");
        }

    }

}
