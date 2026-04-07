import java.util.Arrays;

public class InvertirCadena {
    public static void main(String[] args)
    {
        invierteCadena("Java");
        invierteCadena("racecar");
        invierteCadena("Hola Mundo");
        invierteCadena("");
         invierteCadena(null);
    }


    public static String invierteCadena(String str){
        if (str!=null) {
            System.out.println("Cadena a Invertir==>"+str);
            StringBuilder sb = new StringBuilder("\"");
            char[] cadenArray = str.toCharArray();
            for (int i = cadenArray.length - 1; i >= 0; i--) {
                sb.append(cadenArray[i]);
            }
            sb.append("\"");
            System.out.println("Cadena invertida=>" + sb.toString());
            return sb.toString();
        }else
        {
            System.out.println("Cadena invertida=>" + str);
            return null;

        }
    }



}
