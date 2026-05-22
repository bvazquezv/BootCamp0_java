// InventoryAnalyzer.java — implementa estos métodos usando Streams

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class InventoryAnalyzer {

    public static void main(String[] args) {


        ProductStats puno= new ProductStats("123","uno","cat1",new Money(new BigDecimal("12.3"),"MNX"),2,10);
        ProductStats pdos= new ProductStats("123","uno","cat1",new Money(new BigDecimal("12.3"),"MNX"),1,20);
        ProductStats ptres= new ProductStats("123","uno","cat2",new Money(new BigDecimal("12.3"),"MNX"),3,30);
        ProductStats pcuatro= new ProductStats("123","uno","cat2",new Money(new BigDecimal("12.3"),"MNX"),5,40);
        ProductStats pcinco= new ProductStats("123","uno","cat3",new Money(new BigDecimal("12.3"),"MNX"),5,50);


        ArrayList<ProductStats> listOfproductStats = new ArrayList<ProductStats>();
        listOfproductStats.add(puno);
        listOfproductStats.add(pdos);
        listOfproductStats.add(ptres);
        listOfproductStats.add(pcuatro);
        listOfproductStats.add(pcinco);

        System.out.println("Ejericio 1");
        InventoryAnalyzer inventoryAnalyzer = new InventoryAnalyzer(listOfproductStats);
        List<ProductStats> listTop= inventoryAnalyzer.top10MasVendidos();

        for(ProductStats objTop :listTop)
        {
            System.out.println(
            objTop.ventas())
            ;
        }
        System.out.println("Ejericio 2");
        Map<String, List<ProductStats>>  stockCriticoPorCategoria = inventoryAnalyzer.stockCriticoPorCategoria();
        for (Map.Entry<String, List<ProductStats>> entry : stockCriticoPorCategoria.entrySet()) {
            String categoria = entry.getKey();
            List<ProductStats> productos = entry.getValue();
            System.out.println("Categoría: " + categoria);
            for (ProductStats producto : productos) {
                System.out.println("   Producto: " + producto);
            }
        }

        System.out.println("Ejericio 3");
        List<CategoryReport> categoryReports = inventoryAnalyzer.reportePorCategoria();
        for (CategoryReport repproducto : categoryReports) {
            System.out.println("   categoria : " + repproducto.categoria());
            System.out.println("   reporte Producto: " + repproducto.totalProductos());
        }

     }


    private  final List<ProductStats> catalogo;

    public InventoryAnalyzer(List<ProductStats> catalogo) {
        this.catalogo = List.copyOf(catalogo); // Inmutable
    }

    // 1. Top 10 productos más vendidos
    public List<ProductStats> top10MasVendidos() {
        List<ProductStats> to10 = catalogo.stream()
                    .sorted(Comparator.comparing(ProductStats::ventas).reversed())
                .limit(4)
                .collect(Collectors.toList());
        return to10;
    }

    // 2. Productos con stock crítico (< 5 unidades) agrupados por categoría
    public Map<String, List<ProductStats>> stockCriticoPorCategoria() {
       // Map<String, List<ProductStats>> porCategoria = catalogo.str
        Map<String, List<ProductStats>> porCategoria = catalogo.stream()
                .filter(p -> p.stock() < 5)
                .collect(Collectors.groupingBy(ProductStats::categoria));
        return porCategoria;
    }

    // 3. Reporte por categoría con estadísticas
    public List<CategoryReport> reportePorCategoria() {

        return catalogo.stream()
                .collect(Collectors.groupingBy(ProductStats::categoria))
                .entrySet()
                .stream()
                .map(entry -> {
                    String categoria = entry.getKey();
                    List<ProductStats> productos = entry.getValue();

                    long totalProductos = productos.size();

                    long productosConStock = productos.stream()
                            .filter(p -> p.stock() > 0)
                            .count();

                    // ✅ Suma del valor total (precio * stock)
                    Money valorTotal = productos.stream()
                            .map(p -> p.precio().multiply( new BigDecimal(p.stock()))) // <-- importante
                            .reduce((a, b) -> a.add(b))
                            .orElse(null);


                    double promedioVentas = productos.stream()
                            .mapToInt(ProductStats::ventas)
                            .average()
                            .orElse(0.0);

                    return new CategoryReport(
                            categoria,
                            totalProductos,
                            productosConStock,
                            valorTotal,
                            promedioVentas
                    );
                })
                .toList();
    }
    // 4. Valor total del inventario activo
    public Money valorTotalInventario() {
        Money valorTotal = catalogo.stream()
                .map(p -> p.precio().multiply( new BigDecimal(p.stock()))) // <-- importante
                .reduce((a, b) -> a.add(b))
                .orElse(null);
        return valorTotal;
    }

    // 5. Distribución de precios (rangos)
    // < $500, $500-$2000, $2001-$10000, > $10000
    public Map<String, Long> distribucionPrecios() {

        Map<String, Long> disCost= catalogo.stream()
                .collect(Collectors.groupingBy(
                p -> {
                    BigDecimal precio = p.precio().amount();
                    if (precio.compareTo(BigDecimal.valueOf(500)) < 0) {
                        return "BAJO";
                    } else if (precio.compareTo(BigDecimal.valueOf(500)) < 0){
                        return "MEDIO";
                     } else if (precio.compareTo(BigDecimal.valueOf(1000)) < 0){
                      return "Alto";
                     }
                     else {
                        return "RANGO NO DEFINIDO";
                    }
                },
                Collectors.counting()
        ));
        return  disCost;

    }

    // 6. Top 5 categorías con mayor valor de inventario
    public List<String> top5CategoriasPorValor() {
        List<String> categoryTop =
         catalogo .stream()
                .collect(Collectors.groupingBy(
                        ProductStats::categoria,
                        Collectors.mapping(
                                p -> p.precio().amount().multiply(BigDecimal.valueOf(p.stock())),
                                Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                        )
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, BigDecimal>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();

        return categoryTop;

}

    // 7. Generar alertas de reposición
    public List<InventoryAlert> generarAlertas(int stockMinimoCritico, int stockMinimoAlerta) {
        return catalogo.stream()

                .filter(p -> p.stock() <= stockMinimoAlerta)
                .map(p -> {
                    boolean esCritico = p.stock() <= stockMinimoCritico;

                    AlertType tipo = esCritico
                            ? AlertType.STOCK_CRITICO
                            : AlertType.STOCK_BAJO;

                    int stockMinimo = esCritico
                            ? stockMinimoCritico
                            : stockMinimoAlerta;

                    String mensaje = String.format(
                            "Reposición necesaria para %s (%s): stock actual %d, mínimo requerido %d",
                            p.nombre(),
                            p.sku(),
                            p.stock(),
                            stockMinimo
                    );

                    return new InventoryAlert(
                            tipo,
                            p.sku(),
                            mensaje,
                            p.stock(),
                            stockMinimo
                    );
                })
                .sorted(Comparator.comparing(InventoryAlert::tipo).reversed())
                .toList();

    }

    // 8. Estadísticas generales

        public Map<String, Object> estadisticasGenerales() {

            int totalProductos = catalogo.size();

            long totalConStock = catalogo.stream()
                    .filter(p -> p.stock() > 0)
                    .count();

            BigDecimal valorTotal = catalogo.stream()
                    .map(p -> p.precio().amount().multiply(BigDecimal.valueOf(p.stock())))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            double promedioStock = catalogo.stream()
                    .mapToInt(ProductStats::stock)
                    .average()
                    .orElse(0.0);

            int maxStock = catalogo.stream()
                    .mapToInt(ProductStats::stock)
                    .max()
                    .orElse(0);

            int minStock = catalogo.stream()
                    .mapToInt(ProductStats::stock)
                    .min()
                    .orElse(0);

            int totalVentas = catalogo.stream()
                    .mapToInt(ProductStats::ventas)
                    .sum();
            Map<String, Object> resultado = new HashMap<>();
            resultado.put("totalProductos", totalProductos);
            resultado.put("totalConStock", totalConStock);
            resultado.put("valorTotal", valorTotal);
            resultado.put("promedioStock", promedioStock);
            resultado.put("maxStock", maxStock);
            resultado.put("minStock", minStock);
            resultado.put("totalVentas", totalVentas);
            return resultado;
        }
}