public class Modificar
{
    public static void Modificar(int x, StringBuilder sb) {
        x = 999;
        sb.append(" modificado");

    }

    public static void main(String[] args) {
        int numero = 42;
        StringBuilder texto = new StringBuilder("original");
        String str = new String("valor original");
        Modificar(numero, texto);
        System.out.println(numero); // paso por valor no se modifio la varaible orinal
        System.out.println(texto);  // paso por referencia
    }

}