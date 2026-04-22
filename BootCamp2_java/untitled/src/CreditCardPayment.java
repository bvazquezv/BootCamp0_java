import java.math.BigDecimal;

public class CreditCardPayment extends Payment {

    private String ultimosCuatroDigitos;
    private String titular;
    private int numeroCuotas;
    private String tokenTarjeta;
    // Token de la pasarela (nunca el número real)

    public CreditCardPayment(
            BigDecimal monto,
            String moneda,
            String token,
            String titular,
            int cuotas
    ) {
        super(monto, moneda);
        this.tokenTarjeta = token;
        this.titular = titular;
        this.numeroCuotas = cuotas;
        this.ultimosCuatroDigitos = token.substring(token.length() - 4);
    }

    @Override
    public PaymentResult procesar() {

        this.estado = PaymentStatus.PROCESSING;


        try {

            //StripeResponse response = StripeGateway.charge(tokenTarjeta, monto, moneda);

            this.estado = PaymentStatus.COMPLETED;
            //return PaymentResult.success(response.getTransactionId());
            System.out.println("Pago exitoso");
            return PaymentResult.success(Double.toString(Math.random()));

        //} catch (GatewayException e) {
        } catch (Exception e) {
            this.estado = PaymentStatus.FAILED;
            return PaymentResult.failure(e.getMessage());
        }
    }

    @Override
    public String obtenerResumenParaUsuario() {
        return String.format(
                "Tarjeta terminada en %s — %d cuota(s) de $%.2f %s",
                ultimosCuatroDigitos,
                numeroCuotas,
                monto.doubleValue() / numeroCuotas,
                moneda
        );
    }

    @Override
    protected void onCancelacion() {
        // Notificar a Stripe del void/reverso
       // StripeGateway.voidCharge(paymentId);
        System.out.println("Genera la cancelación del Movimento");

    }
}