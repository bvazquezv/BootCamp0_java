
public class CalculardoraNomina {
final double C_rateExtra = 1.5;
final int  C_jornada_Horas=160;
final double C_rateBonoSupervisor =0.2;
final double ISR =0.15;

 public static void main  (String args[])
 {
     CalculardoraNomina calculadoraNom = new CalculardoraNomina();
     double salarioNeto=0.0;
     salarioNeto=calculadoraNom.calcularNomina(500,10,false);
     System.out.println("valor devuelto (SalarioNeto)=>"+salarioNeto);
 }


    public  double calcularNomina(double salarioBase, int horasExtra, boolean esSupervisor)
    {
        double costoHorasExtra=0.0;
        double bonoSupervisor=0.0;
        double salarioBruto =0.0;
        double salarioNeto= 0.0;
        double isrRetenido=0.0;


        if (salarioBase<=0)
        {
            System.out.println("El salario debe ser mayor a 0");
            return  0;
        }

        if (horasExtra<0 && horasExtra>=40  )
        {
            System.out.println("El las hora extra solo pueden  ser mayor a 0");
            return  0;
        }

        costoHorasExtra= calculaCostohorasExtra(salarioBase,horasExtra );
        if (esSupervisor)
        {
            bonoSupervisor = bonoSupervisor(salarioBase);
        }

        salarioBruto = salarioBase+costoHorasExtra+ bonoSupervisor;
        isrRetenido=calculaISRRetenido(salarioBruto);
        salarioNeto = salarioBruto - isrRetenido;
        System.out.println(
                         "Horas_Extra=>" + horasExtra + '\n' +
                         "Salario_Base=>" + salarioBase + '\n' +
                         "Costo_Extra=>" + costoHorasExtra + '\n' +
                         "Bono_Supervisor=>" + bonoSupervisor + '\n' +
                         "Salario_Bruto=>"+salarioBruto  + '\n' +
                         "ISR_Retenido=>" +isrRetenido  + '\n' +
                         "Salario_Neto=>"+salarioNeto

        );


        return  salarioNeto;
    }

    public  double  calculaCostohorasExtra (double salario,int horasExtra)
    {
        double costhorasExtra= ((this.C_rateExtra * (salario / this.C_jornada_Horas))*horasExtra);
        return  costhorasExtra;
    }

    public double bonoSupervisor (double salario)
    {
        double totalBonoSupervisor = salario * C_rateBonoSupervisor;
        return   totalBonoSupervisor ;
    }
    public double calculaISRRetenido(double montoantesImpuesto)
    {
        return montoantesImpuesto* ISR;
    }

}
