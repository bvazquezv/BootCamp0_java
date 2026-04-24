import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class PaymentResult {

    private final boolean successful;
    private final String transactionId;
    private final String errorMessage;


    private PaymentResult(boolean successful, String transactionId, String errorMessage) {
        this.successful = successful;
        this.transactionId = transactionId;
        this.errorMessage = errorMessage;
    }



    public static PaymentResult success(String transactionId) {
        return new PaymentResult(true, transactionId, null);
    }

    public static PaymentResult failure(String errorMessage) {
        return new PaymentResult(false, null, errorMessage);

    }

        public static PaymentResult pending(String transactionId) {
        try {
            TimeUnit.SECONDS.sleep(5); // Simula Espera que se de el resultado de la Banca
        }catch (Exception e)
        {

        }
            System.out.println("pago exitoso");


        return new PaymentResult(true, transactionId, null);
    }


    public boolean isSuccessful() {
        return successful;
    }

    public Optional<String> getTransactionId() {
        return Optional.ofNullable(transactionId);
    }

    public Optional<String> getErrorMessage() {
        return Optional.ofNullable(errorMessage);
    }
}
