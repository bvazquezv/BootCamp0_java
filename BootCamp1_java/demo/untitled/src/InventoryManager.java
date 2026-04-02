

public class InventoryManager {

final int tamañoListProdct = 100;
final Producto[] arrProductos = new Producto[tamañoListProdct];

    public static void main(String[] args) {

        InventoryManager inventoryMg = new InventoryManager();
/*
        Producto producto = new Producto ();
        Producto producto2 = new Producto ();
        producto = new Producto (1,"Producto1",20.23,10);
        producto2 = new Producto (2,"Producto1",20.23,10);
        inventoryMg.agregarProducto(producto);
        inventoryMg.agregarProducto(producto2);
        inventoryMg.buscaPorNombre (producto);
*/
            /*
        Producto producto = new Producto ();
        for (int i=0; i<=100;i++)
        {
            producto = new Producto (i,"Producto"+i,20.23,10);
            inventoryMg.agregarProducto(producto);

        }
        */



    }


    public Producto buscaPorNombre(Producto p)
    {
        Producto objP =null;
        int numeroCoincidencias=0;
        for (int i = 0; i <= arrProductos.length - 1; i++) {
            if (arrProductos[i] != null)
            {
                if (p.getNombre().equals(arrProductos[i].getNombre()))
                {
                    objP=arrProductos[i];
                    numeroCoincidencias++;
                }
            }
            }
        System.out.println("Econtrado=>"+p.getNombre() +"  Coincidencias=>"+numeroCoincidencias );
    return p;
    }



    public boolean validaNombreDuplicado(Producto p, Producto p2) {
        boolean duplicado = p.getNombre().equals(p2.getNombre());
        return duplicado;
    }




    public boolean agregarProducto(Producto p) {
        boolean addProduct = false;
        int posicionDisponible = validacapacidadArreglo(p);
        if (posicionDisponible != -1) {
            arrProductos[posicionDisponible] = p;
            addProduct = true;
        } else {
            System.out.println("ya no hay capacidad");
            throw new IllegalStateException("Ya no hay espacio");
        }
        return addProduct;
    }


    public int validacapacidadArreglo(Producto p) {
        int posisionDisponible = -1;
        for (int i = 0; i <= arrProductos.length - 1; i++) {
            if (arrProductos[i] != null) {
                if (validaNombreDuplicado(p, arrProductos[i])) {
                    System.out.println("Nombre duplicado=>"+p.getNombre());
                }
            }

            if (arrProductos[i] == null) {
                posisionDisponible = i;
                break;
            }
        }
        return posisionDisponible;
    }


}
