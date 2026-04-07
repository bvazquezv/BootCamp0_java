import java.util.ArrayList;

public class NumerosPrimos {
    public static void main(String[] args) {
        listarNprimos (10);
        int numeroPrimo =7;
        System.out.println("El número primo mas cercano a "+ numeroPrimo+ " Es => " +
        calculaPrimoMasCercano(numeroPrimo)+"\n");
        System.out.println("Encontrar pares de números primos Gemelos \n");
        /*Son los números en dos posiociones adelante del numero primo y qu también es primo*/
        encontrarParGemeloDeNumeroPrimo(100);
    }

public static void listarNprimos (int nPrimos) {
    StringBuilder bf = new StringBuilder("Los primeros "+ nPrimos+" Primos=> ");
    int contFlg = 0;
    int validaNumerPrimo = 0;
    while (contFlg < nPrimos) {
        validaNumerPrimo++;
        if(isNumerPrimo(validaNumerPrimo)) {
            bf.append(validaNumerPrimo + "-");
            contFlg++;
        }
    }
    System.out.println(bf);
}





    public static void encontrarParGemeloDeNumeroPrimo(int intRango)
    {
        ArrayList<ArrayList<Integer>> paresGemerlos= new ArrayList<ArrayList<Integer>>();
            int numposcionadelante=0;
        for (int i = 0; i < intRango; i++)
        {
            numposcionadelante =i+2;
            //System.out.println("Posicion=>"+numposcionadelante);
            if (isNumerPrimo(i) && isNumerPrimo(numposcionadelante) ) {
                System.out.println("Número Primo==>"+ i +" Su Gemelo (el número en dos posiciones adelante y tambien primo)==>"+numposcionadelante );
                System.out.println("("+i +"-"+numposcionadelante+")");
            }
        }

    }



    public static int calculaPrimoMasCercano(int numero)
    {
        int numeroPrimoMasCercano= numero+1;
            // al numero que se paso como parametro le agregamo uno y ese sera nuestro punto de partida en adelante
        for (;;) {  //Bluque infinito hasta encontrar el mas cercano al número dado
            if (isNumerPrimo(numeroPrimoMasCercano))
            {
                break;
            }else {
                numeroPrimoMasCercano++;
            }
        }
        //System.out.println("Numero Primo mas cercano"+numeroPrimoMasCercano);
        return numeroPrimoMasCercano;
    }


    public static  boolean isNumerPrimo(int n)
    {
        boolean isprimo=true;
        if (n==1)
        {
           return false;
        }
        if (n==2)
        {
           return true;
        }
        if (n%2==0)
        {
            return false;
        }

        if (n>2)
        {
            for (int i = 3; i <=Math.sqrt(n) ; i++) {
                if(n%i==0)
                {
                  //  System.out.println(n +" No es numero primo");
                    isprimo=false;
                }
            }
        }
return isprimo;
    }


}
