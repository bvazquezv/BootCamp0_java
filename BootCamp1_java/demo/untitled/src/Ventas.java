public class Ventas {

    final static double[] ventas = {1200, 3450, 2100, 4500, 0, 5600, 3200, 2800, 4100, 1500,
            3800, 2600, 4900, 1100, 9000, 5200, 2900, 4400, 1800, 3600, 2300, 4800,
            1400, 3900, 2500, 5100, 1700, 4200, 8000, 8600};


    public static void main(String[] args) {
        Ventas venas = new Ventas();

        promedio();
        diaConMayorVenta();
        diaConMenorVenta();
        totalAcumulado();
        diasSuperanPromedio( promedio());
        diferenciaMinMax(diaConMayorVenta(),diaConMenorVenta());

    }

    public static  double promedio() {
        double promedio = 0.0;
        double sumaventa = 0;
        int contador = 0;
        for (int i = 0; i < ventas.length; i++) {
            sumaventa += ventas[i];
            contador++;
        }
        promedio = sumaventa / contador;
        System.out.println("Promedio=> "+promedio);
        return promedio;
    }


   public static int  diasSuperanPromedio(double promedio){
        int diasMayorAPromedio=0;
       for (int i = 0; i < ventas.length; i++) {
            if (ventas[i]>promedio)
            {
                diasMayorAPromedio++;
            }
       }
       System.out.println("diasMayores a Promedio=> "+diasMayorAPromedio);
        return diasMayorAPromedio;
   }

    public static double totalAcumulado() {
        double sumaventa = 0;
        for (int i = 0; i < ventas.length; i++) {
            sumaventa += ventas[i];
        }
        System.out.println("Total acumulado=> "+sumaventa);
        return sumaventa;
    }


    public static double diaConMayorVenta() {
        double valorMayor = 0.0;
        int indice=0;
        for (int i = 0; i <= ventas.length-1 ; i++) {
            if (i == 0) {
                valorMayor = ventas[0];
            }
            if (i > 0) {
                if (valorMayor < ventas[i]) {
                    valorMayor = ventas[i];
                    indice=i;
                }
            }


        }
        System.out.println("valor mayor=> "+ valorMayor+ "indice=> "+indice);
        return valorMayor;
    }

    public static double diaConMenorVenta() {
        double valorMayor = 0.0;
        int indice =0;
        for (int i = 0; i < ventas.length ; i++) {
            if (i == 0) {
                valorMayor = ventas[0];
            }
            if (i > 0) {
                if (valorMayor > ventas[i]) {
                    valorMayor = ventas[i];
                    indice=i;
                }
            }
        }
        System.out.println("valor menor=> "+valorMayor +"indice=> "+indice);
        return valorMayor;
    }



    public static double diferenciaMinMax(double max, double min)
    {
        double difenrencia=0.0;
        difenrencia = max-min;
        System.out.println("Diferencias=> "+difenrencia);
        return difenrencia;
    }


}



