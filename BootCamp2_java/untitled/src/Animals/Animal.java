package Animals;

import java.util.List;

public class Animal {
    public String hablar() {
        return "...";
    }

    public void presentarse() {
        System.out.println("Soy un " + getClass().getSimpleName() + " y digo: " + hablar());
    }

    public static class Dog extends Animal {
        @Override
        public String hablar() {
            return "¡Guau!";
        }
    }

    public static class Cat extends Animal {
        @Override
        public String hablar() {
            return "¡Miau!";
        }
    }

    public static class Parrot extends Animal {
        private final String palabra;

        public Parrot(String palabra) {
            this.palabra = palabra;
        }

        @Override
        public String hablar() {
            return "¡" + palabra + "!";
        }
    } // En main:

    public static void main(String[] args) {
        List<Animal> animales = List.of( new Dog(), new Cat(), new Parrot("Polly quiere una galleta"), new Animal() );
        animales.forEach(Animal::presentarse);
    }


    // List<Animals.Animal> animales = List.of( new Dog(), new Cat(), new Parrot("Polly quiere una galleta"), new Animals.Animal() ); animales.forEach(Animals.Animal::presentarse);
}





