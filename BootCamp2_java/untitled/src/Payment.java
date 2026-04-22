import java.math.BigDecimal;
import java.time.LocalDateTime;

// Clase abstracta — define el contrato y comportamiento parcial
public abstract class Payment {

    protected String paymentId;
    protected BigDecimal monto;
    protected String moneda;
    protected LocalDateTime fechaCreacion;
    protected PaymentStatus estado;


    protected Payment(BigDecimal monto, String moneda) {
        validateMonto(monto);
        this.monto = monto;
        this.moneda = moneda;
        this.paymentId = Double.toString(Math.random());
        this.fechaCreacion = LocalDateTime.now();
        this.estado = PaymentStatus.PENDING;
    }


    public String getPaymentId() {
        return paymentId;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public PaymentStatus getEstado() {
        return estado;
    }

    public void cancelar() {
        if (estado == PaymentStatus.COMPLETED) {
            throw new IllegalStateException(
                    "No se puede cancelar un pago completado"
            );
        }
        this.estado = PaymentStatus.CANCELLED;
        onCancelacion(); // Hook para subclases
    }


    public abstract  PaymentResult procesar();


    public abstract String obtenerResumenParaUsuario();


    protected void onCancelacion() {

    }

    private void validateMonto(BigDecimal monto) {
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "El monto debe ser mayor a cero"
            );
        }
    }
}
