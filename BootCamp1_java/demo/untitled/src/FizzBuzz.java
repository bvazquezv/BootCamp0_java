public class FizzBuzz {

    public static void main(String[] args) {
        validaMultimpos();
    }

   public static  void  validaMultimpos()
    {
        int Fizz = 0;
        int Buzz = 0;
        int FizzBuzz = 0;
        int Jazz = 0;
        int FizzJazz = 0;
        int BuzzJazz = 0;
        int FizzBuzzJazz = 0;
        for (int i=1 ;i<=200;i++ )
        {
            if (i % 3 == 0) { Fizz++;}
            if (i % 5 == 0) {Buzz++;}
            if (i % 15 == 0) {FizzBuzz++;}
            if (i % 7 == 0) {Jazz++;}
            if (i % 21 == 0) {FizzJazz++;}
            if (i % 35 == 0) {BuzzJazz++;}
            if (i % 105 == 0) {FizzBuzzJazz++;}
        }
            System.out.println(
                             "Fizz==>"+ Fizz + "\n"+
                            "Buzz==>"+Buzz+ "\n"+
                            "FizzBuzz==>"+Jazz+ "\n"+
                            "Jazz==>"+Jazz+ "\n"+
                            "FizzJazz==>"+FizzJazz+ "\n"+
                            "BuzzJazz==>"+BuzzJazz+ "\n"+
                            "FizzBuzzJazz==>"+FizzBuzzJazz+ "\n"
            );






    }






}
