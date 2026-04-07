import java.util.*;

public class AgruparAnagrama {
    public static ArrayList<ArrayList<String>> agruparAnagramas(String[] palabras) {
        System.out.println(  Arrays.toString(palabras));
    List<String> copyListtoReview = Arrays.asList(palabras);
        ArrayList<ArrayList<String>> gruposEneagram = new ArrayList<ArrayList<String>> ();
        List<Integer> lista = new ArrayList<Integer>();
        for (int i = 0; i < copyListtoReview.size(); i++) {
            if (lista.contains(i))
            {
                continue;

            }
            ArrayList <String> grupo=new ArrayList<String>();
            for (int j = 0; j < copyListtoReview.size(); j++) {
                boolean isEneagram =false;
                isEneagram=comparaEneagram(copyListtoReview.get(i),copyListtoReview.get(j));
                if (isEneagram)
                {
                    grupo.add(copyListtoReview.get(j));
                    lista.add(j);
                }
            }
       //     System.out.println("Agrega al grupo");
            gruposEneagram.add(grupo);


        }


return gruposEneagram;

    }


    public static  boolean comparaEneagram(String s1, String s2)
    {
        boolean iseneagram=false;
//System.out.println(s1+ " con "+ s2);
         char[] s1CharArray=s1.toCharArray();
         char[] s2CharArray=s2.toCharArray();

        Arrays.sort(s1CharArray);
        Arrays.sort(s2CharArray);

        if (Arrays.equals(s1CharArray,s2CharArray))
        {
            iseneagram=true;
            //System.out.println("Son eneagram");
        }
return iseneagram;
    }

    public static void main(String[] args) {
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        ArrayList<ArrayList<String>> salida = agruparAnagramas(input);
        System.out.println("Agrupamiento de Eneagramas");
        System.out.println(salida);
    }
}