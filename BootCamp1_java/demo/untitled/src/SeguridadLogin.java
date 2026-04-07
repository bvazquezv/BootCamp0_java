public class SeguridadLogin {

    public static void main(String[] args)
    {
        SeguridadLogin objSecurity = new SeguridadLogin();
        String password= "passv3wersss";
        System.out.println(password);
        System.out.println(objSecurity.validaPasswordSeguro(password)+"\n");
        password="passv$3wersss";
        System.out.println(password);
        System.out.println(objSecurity.validaPasswordSeguro(password)+"\n");
        password="passv$3  wersss";
        System.out.println(password);
        System.out.println(objSecurity.validaPasswordSeguro(password)+"\n");

    }

    public  boolean  validaPasswordSeguro(String password)
    {
        boolean isSecure =false;
        if (contieneNumeros(password) && contieneTexto(password) && contienecaraterEspecial(password) && !contieneEspacios(password))
        {
            isSecure = true;
            System.out.println("Nivel de seguridad=>"+validaLevelOfPws(password));
        }
        return isSecure;
    }

    public boolean contieneTexto (String password)
    {    boolean haveText=false;
        // Se valida una expresion regular de texto

        if ( password.matches(".*[a-zA-ZáéíóúÁÉÍÓÚñÑ].*"))
        {
            haveText=true;
        }else
        { System.out.println("No contiene texto");}
        return haveText;
    }

    public boolean contieneNumeros (String password)
    {   boolean haveNumbers=false;
        // Se valida una expresion regular par ver si la cadena contiene un dígito númerico

        if  (password.matches(".*\\d.*"))
        {
            haveNumbers=true;
        }else {
            System.out.println("No contiene números");

        }
        return haveNumbers;
    }

    public boolean contienecaraterEspecial (String password)
    {     boolean haveSpecialChars=false;
        // Se valida una expresion regular de texto

        if ( password.matches(".*[!@#$%^&*].*"))
        {haveSpecialChars=true;
        }else {

            System.out.println("No contine caracteres especiales !@#$%^&*");
        }
        return haveSpecialChars;
    }

    public boolean contieneEspacios (String password)
    {    boolean withespace=false;
        // Se valida una expresion regular de texto

       if ( password.matches(".*[\\s].*"))
       {
           withespace=true;
           System.out.println("Contiene espacios");
       }
       return withespace;
    }



    public String validaLevelOfPws(String password)
    {
        String strLevelSecurity="";
        if  (password.length()<8)
        {
            strLevelSecurity= "Longuitud no permitida";
        }
        if  (password.length()==8)
        {
            strLevelSecurity= "Seguridad Baja";
        }
        if  (password.length()>8 && password.length()<12 )
        {
            strLevelSecurity= "Seguridad Media";
        }
        if  (password.length()>=12 &&password.length()<25 )
        {
            strLevelSecurity= "Seguridad Alta";
        }
        if  (password.length()>=25  )
        {
            strLevelSecurity= "Excede Longuitud permitida";
        }
        return strLevelSecurity;
    }

}
