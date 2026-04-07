import java.util.Arrays;

public class ordenamientos {

    public static void main(String[] args) {


        int [] arregloOrdenar = new int[]{8, 5, 3, 1,2,9};
        System.out.println("Ordenamiento Burbuja=> ");
        System.out.println("Array Desordenado=> "+Arrays.toString(arregloOrdenar));
        int[] arregloOrdenado1= ordenamientoBurbuja(arregloOrdenar);
        System.out.println("Arreglo Ordenado"+ Arrays.toString(arregloOrdenado1));

        System.out.println("\n");

        System.out.println("Ordenamiento Selection Sort=> ");
        int [] arregloOrdenar2 = new int[]{7, 6, 3, 1,2,9};
        System.out.println("Array Desordenado "+Arrays.toString(arregloOrdenar2) );
        int[] arregloOrdenado2= selectionSorth(arregloOrdenar2);
        System.out.println( "Arreglo Ordenado=>"+Arrays.toString(arregloOrdenar2));

        //encuntraPosicionMenor(new int[]
        // {8, 5, 3, 1,2,9},0); 3
        //1, 5, 3, 8,2,9} 4
        //1, 2, 3, 8,5,9} 4
        //1, 2, 3, 5,8,9}4


    }


    //Desde la posición inicial con el resto del arreglo compara con el numero mas pequeno del arreglo si es menor
    //permutan posiciones,
       public static int[] selectionSorth(int[] intArregloOrdenar)
    {
        long valorInicial= System.nanoTime();

        //System.out.println("Array Desordenado=> " +Arrays.toString(intArregloOrdenar));
        int varAux=-1;
        for (int i = 0; i < intArregloOrdenar.length-1; i++) {
            int posicionMenor = encuntraPosicionMenor(intArregloOrdenar,i+1);
            int valorMinimodelArrreglo= intArregloOrdenar[posicionMenor];
            if((intArregloOrdenar[i])> valorMinimodelArrreglo)
            {
               // System.out.println("es mayor ="+arrayaOrdenar[i] +"que este"+arrayaOrdenar[encuntraPosicionMenor(arrayaOrdenar,i+1)]);
                varAux= intArregloOrdenar[posicionMenor];
                intArregloOrdenar[posicionMenor]= intArregloOrdenar[i];
                intArregloOrdenar[i]=varAux;
            }
        }
       // System.out.println("Array Ordenado=> " +Arrays.toString(intArregloOrdenar));
        long valorfinal= System.nanoTime();

        System.out.println("Nano segundos=> "+ (valorfinal-valorInicial));
        return intArregloOrdenar;
    }

    //Encuentra la posición Menor desde una posición dada en un arreglo
    public static int encuntraPosicionMenor(int[] arrayNumeros, int posicion)
    {
        int valorMinimo=arrayNumeros[posicion];
        for (int i = posicion; i <arrayNumeros.length ; i++) {
            if(arrayNumeros[i]<valorMinimo)
            {
                valorMinimo=arrayNumeros[i];
                //System.out.println("Posicion=> "+i);
                posicion=i;
            }
        }

        //System.out.println("posicion"+ posicion);
        return posicion;


    }






    public static int[] ordenamientoBurbuja(int[] str) {
        long valorInicial= System.nanoTime();

        int[] arrayaOrdenar = str;
      //  System.out.println("Array Desordenado=> " +Arrays.toString(arrayaOrdenar));
        int varAux = 0;  // variable auxiliar para permutar valores
        int count=0;    // Bandera que me indica cuantas veces ejecutar el algoritmo de ordenamiento
      while (count<arrayaOrdenar.length) {
          for (int j = 0; j < arrayaOrdenar.length - 1; j++) {
              if (arrayaOrdenar[j] > arrayaOrdenar[j + 1]) {  //Compara el actual con el siguiente (si actual es mayor cambia el orden)
                  varAux = arrayaOrdenar[j + 1];
                  arrayaOrdenar[j + 1] = arrayaOrdenar[j];
                  arrayaOrdenar[j] = varAux;
              }
          }
          count++;
      }
       // System.out.println("ArrayOrdenado  => "+
        //Arrays.toString(arrayaOrdenar)
        //);

        long valorfinal= System.nanoTime();

        System.out.println("Nano Segundos=>" + (valorfinal-valorInicial));

        return arrayaOrdenar;
    }
}
