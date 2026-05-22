import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndiceHash {


    public static void main(String[] args) {
        List<Producto> arrayList = List.of(
                new Producto(1L,"sk1","nombre"),
                new Producto(2L,"sk2","nombre"),
                new Producto(3L,"sk3","nombre"),
                new Producto(5L,"sk4","nombre"),
                new Producto(5L,"sk5","nombre")
        );

        Map<String, Producto> hm = new HashMap();
        for (Producto p : arrayList)
        {hm.put(p.getSku(),p);
        }
        Producto penIndice= hm.get("sk5");
        System.out.println(
        penIndice.toString());


    }










}
