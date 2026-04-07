import java.util.Arrays;

public class BuscarPatronDeTexto {

    public static void main(String[] args)
    {
        System.out.println("Primer Indice=> "+  buscarTexto("Hello World", "World") );
        System.out.println( "Primer Indice=> "+  buscarTexto("abcdef", "cde"));
        System.out.println( "Primer Indice=> "+ buscarTexto("abcdef", "xyz") );
        System.out.println( "Primer Indice=> "+ buscarTexto("aaaa", "aaa") );
    }



    public static int buscarTexto(String cadena, String patron) {
        System.out.println("Busca=>" +patron+ " En=> " +cadena );
        //El ejercicio pide "No usar" contains ni regex (Epxresiones regulares)
        char[] strCadena = cadena.toCharArray();
        char[] strPatron = patron.toCharArray();
        int banderaComienzaCohincidencia = -1;
        int pimerIndice = -1;
        for (int i = 0; i < strPatron.length; i++) {
            for (int j = 0; j < strCadena.length; j++) {
             //   System.out.println(strPatron[i] + " con" + strCadena[j]);
                if (strPatron[i] == strCadena[j]) {
                    banderaComienzaCohincidencia += 1;
                    if (banderaComienzaCohincidencia == 0) // Una vez que comieza la primer cohincidencia guardo el indice
                    {
                        pimerIndice = j;
                    }
                    i += 1;
                    if (banderaComienzaCohincidencia == strPatron.length - 1) {
                        break;
                    }
                } else {
                    banderaComienzaCohincidencia = -1;
                    pimerIndice = -1;
                }
            }
        }
        return pimerIndice;
    }


}
