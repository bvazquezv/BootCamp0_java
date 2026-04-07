import java.util.ArrayList;
import java.util.List;

public class InventoryManager {

    final int tamañoListProdct = 100;
    final Producto[] arrProductos = new Producto[tamañoListProdct];

    public static void main(String[] args) {
    }


    public  List<Producto>  contarConStockBajo(int umbral)
    {
        List<Producto> listaStockMenorUmbral = new ArrayList<Producto>();
        for (Producto p :arrProductos) {
            if (p!=null && p.getStock()<umbral)
            {
                System.out.println(p.getId() +" Menor al umbral=>"+"("+umbral+")"+ p.getNombre() );
                listaStockMenorUmbral.add(p);

            }
        }
            return listaStockMenorUmbral;
    }



    public double  calcularValorInventario()
    {
        double  sumaStock=0.0;
        for (Producto p :arrProductos) {
            if (p!=null && p.isActivo()) {
                sumaStock = p.getPrecio() * p.getStock();
            }
        }
        return sumaStock;
    }




    public List<Producto>  listarActivos()
    {
    List<Producto> listProducts = new ArrayList<Producto>();
        for (Producto p :arrProductos) {
            if (p!=null && p.isActivo()) {
                //System.out.println(p.getId() +" Producto activo");
                listProducts.add(p);
            }
        }
            return listProducts;
    }






    public Producto buscarPorNombre(String p)
    {
        Producto objP =null;
       // int numeroCoincidencias=0;
        for (int i = 0; i <= arrProductos.length - 1; i++) {
            if (arrProductos[i] != null)
            {
                if (p.equals(arrProductos[i].getNombre()))
                {
                    objP=arrProductos[i];
                }
            }
            }

    return objP;
    }



    public boolean validaNombreDuplicado(Producto p, Producto p2) {
        boolean duplicado = p.getNombre().equals(p2.getNombre());
        return duplicado;
    }

    public boolean agregarProducto(Producto p) {
        boolean addProduct = false;
        int posisionDisponible = -1;
        boolean validaDuplicado= false;
        for (int i = 0; i <= arrProductos.length - 1; i++) {
            if (arrProductos[i] != null) {
                if (validaNombreDuplicado(p, arrProductos[i])) {
                    validaDuplicado=true;
                }
            }

            if (arrProductos[i] == null) {
                posisionDisponible = i;
                break;
            }
        }


        if (posisionDisponible != -1 ) {

            if (!validaDuplicado) {
                arrProductos[posisionDisponible] = p;
                addProduct = true;
            }

        } else {
            System.out.println("ya no hay capacidad lanza Excepcion");
            throw new IllegalStateException("Ya no hay espacio");
        }
        return addProduct;
    }





}
