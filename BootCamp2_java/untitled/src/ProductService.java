public class ProductService  {
    private final ProductRepository repository;
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product create(CreateProductDTO dto) throws Exception
    { if (repository.existsByNombre(dto.getNombre()))
            {
        throw new Exception(dto.getNombre());
            }
    return repository.save(new Product(dto));
    }
//Pendiente
 }