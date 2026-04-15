public class Persona {

    int edad ;
    String docmicilio;
    boolean hijos ;


    public Persona()
    {
        System.out.println("Inica el objeto");

    }

    public  Persona (int edad, String domicilio)
    {
        this.edad= edad;
        this.docmicilio= domicilio;
    }



    public static void main(String[] args) {
        Persona p = new Persona();
        Persona p2 = new Persona(5, "Domiciio");

    }


}
