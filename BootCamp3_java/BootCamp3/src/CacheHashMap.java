import java.util.LinkedHashMap;
import java.util.Map;

public class CacheHashMap {

    public static void main(String[] args) {
        
        Producto p1=  new Producto(1L,"sk1","nombre1");
        Producto p2=          new Producto(2L,"sk2","nombre2");
        Producto p3=          new Producto(3L,"sk3","nombre3");
        Producto p4=          new Producto(4L,"sk4","nombre4");
        Producto p5=          new Producto(5L,"sk5","nombre5");
        Producto p6=          new Producto(6L,"sk6","nombre6");
        Producto p7=          new Producto(7L,"sk7","nombre7");
        Producto p8=          new Producto(8L,"sk8","nombre8");
        Producto p9=          new Producto(9L,"sk9","nombre9");
        Producto p10=         new Producto(10L,"sk10","nombre10");
        Producto p11=         new Producto(11L,"sk11","nombre11");
        Producto p12=         new Producto(12L,"sk12","nombre12");
        Producto p13=         new Producto(13L,"sk13","nombre13");

        Map<String, Producto> cache = new LinkedHashMap<>(5, 0.75f, true) {
            private static final int MAX_SIZE = 10;
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Producto> eldest) {
                return size() > MAX_SIZE; // Elimina el más antiguo cuando llega al límite } };
            }
        };

        cache.put(p1.getSku(), p1);
        cache.put(p2.getSku(), p2);
        cache.put(p3.getSku(), p3);
        cache.put(p4.getSku(), p4);
        cache.put(p5.getSku(), p5);
        cache.put(p6.getSku(), p6);
        cache.put(p7.getSku(), p7);
        cache.put(p8.getSku(), p8);
        cache.put(p9.getSku(), p9);
        cache.put(p10.getSku(), p10);

        for (Map.Entry<String, Producto> map : cache.entrySet())
        {
            System.out.println(
            map.getValue().getSku()
            );
        }

        System.out.println( "*****Cache solo 10 ********* regresa los utimos 10 items ingresados y/o modificados");
        cache.put(p11.getSku(), p11);
        cache.put(p12.getSku(), p12);
        cache.put(p13.getSku(), p13);

        for (Map.Entry<String, Producto> map : cache.entrySet())
        {
            System.out.println(
                    map.getValue().getSku()
            );
        }

    }

}





