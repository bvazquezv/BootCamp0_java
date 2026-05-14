import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public record Money(BigDecimal amount, String currency) {


    public Money {
        Objects.requireNonNull(amount, "Amount no puede ser null");
        Objects.requireNonNull(currency, "Currency no puede ser null");

        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount no puede ser negativo");
        }

        if (currency.length() != 3) {
            throw new IllegalArgumentException("Currency debe ser código ISO 4217 (3 chars)");
        }

        currency = currency.toUpperCase();
        amount = amount.setScale(2, RoundingMode.HALF_UP); // 2 decimales siempre
    }

    public Money add(Money other) {
        requireSameCurrency(other);
        return new Money(amount.add(other.amount), currency);
    }

    public Money subtract(Money other) {
        requireSameCurrency(other);
        return new Money(amount.subtract(other.amount), currency);
    }

    public Money multiply(BigDecimal factor) {
        return new Money(amount.multiply(factor), currency);
    }

    public boolean isGreaterThan(Money other) {
        requireSameCurrency(other);
        return amount.compareTo(other.amount) > 0;
    }

    public boolean isZero() {
        return amount.compareTo(BigDecimal.ZERO) == 0;
    }

    // Factory methods semánticos
    public static Money of(String amount, String currency) {
        return new Money(new BigDecimal(amount), currency);
    }

    public static Money zero(String currency) {
        return new Money(BigDecimal.ZERO, currency);
    }

    public static Money mxn(String amount) {
        return new Money(new BigDecimal(amount), "MXN");
    }

    @Override
    public String toString() {
        return String.format("%,.2f %s", amount, currency);
    }

    private void requireSameCurrency(Money other) {
        if (!currency.equals(other.currency)) {
            throw new IllegalArgumentException(
                    "No se pueden operar monedas distintas: " +
                            currency + " vs " + other.currency
            );
        }
    }
}