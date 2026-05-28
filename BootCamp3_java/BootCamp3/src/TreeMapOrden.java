import java.math.BigDecimal;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapOrden {

    public static void main(String[] args) {

        ProductStats puno= new ProductStats("123","uno","cat1",new Money(new BigDecimal("10"),"MNX"),2,10);
        ProductStats pdos= new ProductStats("123","uno","cat1",new Money(new BigDecimal("20"),"MNX"),1,20);
        ProductStats ptres= new ProductStats("123","uno","cat2",new Money(new BigDecimal("30"),"MNX"),3,30);
        ProductStats pcuatro= new ProductStats("123","uno","cat2",new Money(new BigDecimal("40"),"MNX"),5,40);
        ProductStats pcinco= new ProductStats("123","uno","cat3",new Money(new BigDecimal("50"),"MNX"),5,50);


        TreeMap<Integer, ProductStats> thm = new TreeMap<>(Map.of(
                (Integer)ptres.precio().amount().intValue(),ptres,
                (Integer)pcinco.precio().amount().intValue(),pcinco,
                (Integer)puno.precio().amount().intValue(),puno,
                (Integer)pdos.precio().amount().intValue(),pdos,
                (Integer)pcuatro.precio().amount().intValue(),pcuatro
        )
        );
        /*Treemap lo ordena de foamde descendete por deacuerdo al precio*/
        for (Map.Entry<Integer, ProductStats> entry : thm.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        /*el mas cercano hacia arriba del precio que se da*/
        Integer clave = thm.floorKey((Integer) 20);
        System.out.println("**"+thm.get(clave)); // "Medio"

         /*Desde  10 considerando el 10  hasta 50 */
        SortedMap<Integer, ProductStats> rango = thm.subMap(10, true, 50,true);
        for ( Map.Entry<Integer, ProductStats> entry : rango.entrySet() ) {
            System.out.println("--"+entry.getKey());
        }

    }







}
