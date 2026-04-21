import java.math.BigDecimal;

public class ElectronicProduct extends Product {

    private String marca;
    private int mesesGarantia;
    private String voltaje; // "110V", "220V", "Dual"

    public ElectronicProduct(
            String nombre,
            String descripcion,
            BigDecimal precio,
            int stock,
            String marca,
            int mesesGarantia
    ) {

        super(nombre, descripcion, precio, stock, "Electrónica");

        this.marca = marca;
        this.mesesGarantia = mesesGarantia;
        this.voltaje = "Dual"; // valor por defecto
    }


    @Override
    public String toString() {

        return super.toString()
                + " ["
                + marca
                + ", Garantía: "
                + mesesGarantia
                + " meses]";
    }


    public boolean requiereAdaptador(String voltajeDestino) {
        return !this.voltaje.equals("Dual")
                && !this.voltaje.equals(voltajeDestino);
    }
}