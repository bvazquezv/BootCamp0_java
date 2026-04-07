public class MainInventory {

    public static void main(String[] args) {

        InventoryManager inventario = new InventoryManager();


        inventario.agregarProducto(new Producto(1,"Laptop Dell XPS", 45999.99, 10,true));
        inventario.agregarProducto(new Producto(2,"Mouse Logitech MX", 599.99, 50, true));
        inventario.agregarProducto(new Producto(3,"Monitor LG 27'", 8999.99, 15, true));
        inventario.agregarProducto(new Producto(4, "Teclado Mecánico", 1899.99, 25, true));

        System.out.println("=== INVENTARIO INICIAL ===");
        System.out.printf("Valor total del inventario: $%.2f%n",
                inventario.calcularValorInventario());
        System.out.println("Productos bajo Umbral: " +
                inventario.contarConStockBajo(15));

        // Simular ventas
         Producto laptop = inventario.buscarPorNombre("Laptop Dell XPS");
         if (laptop != null && laptop.puedeVender(3)) {
         laptop.reducirStock(3);
         System.out.println("Venta: 3x Laptop → Stock restante: " + laptop.getStock());
         }

        // Agregar stock
         Producto audifonos = inventario.buscarPorNombre("Laptop Dell XPS");
         if (audifonos != null) {
             int agregarUnidadesStock=20;
             audifonos.agregarStock(agregarUnidadesStock);
         System.out.println("Aumenta stock:Laptop Dell XPS → aumenta Uidades=> "+agregarUnidadesStock+" Stock : " + audifonos.getStock());
         }

        // Listar activos
         System.out.println("\n=== PRODUCTOS ACTIVOS ===");
        for (Producto p : inventario.listarActivos()) {
         System.out.printf("  %-25s  $%8.2f  Stock: %3d%n",
        p.getNombre(), p.getPrecio(), p.getStock());
        }



        Producto producto = new Producto ();
        for (int i=0; i<=100;i++)
        {
            producto = new Producto (i,"Producto"+i,20.23,10,true);
            inventario.agregarProducto(producto);

        }


    }








}
