public class CodigoVivo {
public static void main(String[] args) {
    String a = "Java";
    String b = "Java";
    String c = "Java";
    String d = c.intern();
    System.out.println(a == b); //true
    // toma del String pool y compara siendo la misma referencai dado que no se instancio el objeto
    System.out.println(a == c);  // true
    // toma del String pool y compara siendo la misma referencai dado que no se instancio el objeto
    System.out.println(a == d);  //  true
    //// d se crea de un literal existene en el String pool y apunta a la mima cadena de alli que resulta o mismo
    System.out.println(a.equals(c));
    //Compara el contenido del objeto pese a que aparentemente se comparan los objetos se esta comparando el contenido
    System.out.println("ss");
    Integer x = 127;
    Integer y = 127;
    Integer p = 128;
    Integer q = 128;
    System.out.println(x == y);  //true
    //java crea un cache de objetos integer de -127 a 128
    System.out.println(p == q);
    //
}


}