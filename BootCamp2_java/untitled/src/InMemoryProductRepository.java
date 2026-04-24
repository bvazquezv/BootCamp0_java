import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class InMemoryProductRepository implements ProductRepository{
    @Override
    public Product save(Product product) {
        System.out.println("Guardo Producto");
        return null;
    }


    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public boolean existsByNombre(String nombre) {
        System.out.println("Valido Existencia del producto, se simula que ya hay uno en base datos");
        Product p  = new Product("F","Fondo Inversion",new BigDecimal(20),5,"Electronica");

        if (nombre.equals(p.nombre))
        {
            System.out.println("El producto ya existe");
        }

        return false;
    }
}
