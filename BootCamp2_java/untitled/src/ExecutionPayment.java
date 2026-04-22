import java.math.BigDecimal;
import java.util.ArrayList;

public class ExecutionPayment {

    public static void main(String[] args) {

        Payment pago1= new CreditCardPayment(new BigDecimal("200.00"),"Pesos","abc13213213213","Bernardo",5);
        Payment pago2= new BankTransferPayment(new BigDecimal("200.00"),"Pesos","123","234");
        Payment pago3= new CreditCardPayment(new BigDecimal("200.00"),"Pesos","abc213213213","Bernardo",5);
        Payment pago4= new BankTransferPayment(new BigDecimal("200.00"),"Pesos","123","234");
        ArrayList<Payment> list = new ArrayList<Payment>();

        list.add(pago1);
        list.add(pago2);
        list.add(pago3);
        list.add(pago4);


        Payment pago;
        for (int i = 0; i < list.size(); i++) {
            pago = list.get(i);
            pago.procesar();

        }



    }

}
