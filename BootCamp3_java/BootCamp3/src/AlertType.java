public enum AlertType {


    STOCK_CRITICO(3),
    STOCK_BAJO(2),
    SIN_MOVIMIENTO(1);

    private final int priority;

    AlertType(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }



}
