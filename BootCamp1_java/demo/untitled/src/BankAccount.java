import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class BankAccount {
    String id;
    String titular;
      BigDecimal saldo;
     boolean activa;
    int numberMovimientos;

    public static void main(String[] args) throws IllegalAccessException {
        BankAccount cuentaBank1 = new BankAccount("001","Bernardo",new BigDecimal(50),true,0);
        BankAccount cuentaBank2 = new BankAccount("002","Juanito Perez",new BigDecimal(50),true,0);
        double cantidadDepositar = 10.0;
        double cantidadDepositar2 = 20.0;
        double cantidadretiro = 40.0;
        double cantidadtrasnferir = 20.0;

        System.out.println("----Estado Inicial de las cuentas----");
        cuentaBank1.getResumen();
        cuentaBank2.getResumen();
        System.out.println("Cantidad a depositar Cuenta1=>"+cantidadDepositar);
        cuentaBank1.depositar(new BigDecimal(cantidadDepositar));
        System.out.println("Cantidad a depositar Cuenta1=>"+cantidadDepositar2);
        cuentaBank1.depositar(new BigDecimal(cantidadDepositar2));
        System.out.println("Saldo Cuenta1=>"+ cuentaBank1.saldo);
        System.out.println("Retiro Cuenta1=>"+cantidadretiro);
        cuentaBank1.retirar(new BigDecimal(cantidadretiro));
        System.out.println("Saldo Cuenta1=>"+ cuentaBank1.saldo);
        System.out.println("transferir=> "+cantidadtrasnferir+" de cuenta1 a cuenta 2");
        cuentaBank1.tranferir(cuentaBank2,new BigDecimal(cantidadtrasnferir));

        System.out.println("-----Estado Final de las cuentas----");
        cuentaBank1.getResumen();
        cuentaBank2.getResumen();

    }

        BankAccount(String id,String titular,BigDecimal saldo,boolean activa,int numberMovimientos) {
        this.id=id;
        this.titular=titular;
        this.saldo=saldo;
        this.activa=activa;
        this.numberMovimientos=numberMovimientos;

        Timestamp ts = new Timestamp(new Date().getTime());
      //  System.out.println("ACC" + ts);
        this.id = "ACC" + ts;
        }


    public void  getResumen()
    {
        System.out.printf( "Estado de la cuenta %-30s  %-20s  %.2f activa:%b Movimientos:%d %n", this.id, this.titular, this.saldo  , this.activa, this.numberMovimientos);



    }

    public void tranferir (BankAccount destino, BigDecimal monto) throws IllegalAccessException {
        this.retirar(monto);
        this.numberMovimientos+=1;
        destino.depositar(monto);
        destino.numberMovimientos+=1;
    }

    public void   retirar(BigDecimal bd) throws IllegalAccessException {

        if (bd.compareTo(new BigDecimal(0.0))<=0)
        {
            throw new IllegalAccessException("Menor de Cero no permitido");


        }
        if(bd.compareTo(this.saldo)>0)
        {
            throw new IllegalAccessException("Saldo insuficiente");

        }

        this.saldo= this.saldo.subtract(bd);
        numberMovimientos++;



    }



    public void   depositar(BigDecimal bd){
        boolean depositoRealizado = false;

        if(bd.compareTo(new BigDecimal(0.0))>0)
        {
            //System.out.println(bd +" es mayor que cero");
            this.saldo= this.saldo.add(bd);
            numberMovimientos++;

        } else if (bd.compareTo(new BigDecimal(0.0))<=0) {
            System.out.println("El deposito debe ser mayor a cero");
        }
    }


}




