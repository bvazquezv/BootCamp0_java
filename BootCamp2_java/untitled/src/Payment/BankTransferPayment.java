package Payment;

import java.math.BigDecimal;

public class BankTransferPayment extends Payment {

    private String cuentaOrigen;
    private String cuentaDestino;
    private String referencia;

    public BankTransferPayment(
            BigDecimal monto,
            String moneda,
            String cuentaOrigen,
            String cuentaDestino
    ) {
        super(monto, moneda);
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.referencia = "TRF" + System.currentTimeMillis();


    }

    @Override
    public PaymentResult procesar() {

        this.estado = PaymentStatus.PROCESSING;
        System.out.println("Pago spei ..espera");
        // En SPEI el resultado suele ser asíncrono
        return PaymentResult.pending(referencia);
    }

    @Override
    public String obtenerResumenParaUsuario() {
        return String.format(
                "Transferencia SPEI — Referencia: %s — $%.2f %s",
                referencia,
                monto.doubleValue(),
                moneda
        );
    }
}


