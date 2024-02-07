package lesson2.t1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

class Main {

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, 
                                                    IllegalAccessException, InvocationTargetException {

        
        Animal[] animals = {new Dog(1, "Bob", "gav"), 
                            new Dog(2, "Alex", "wuf"),
                            new Dog(3, "Eshli", "auuuf"),
                            new Cat(1, "Murzik", 11),
                            new Cat(2, "Pusya", 22),
                            new Cat(3, "Murka", 33)
                            };

        for (Animal animal : animals) {
            System.out.println(animal);
            if (Arrays.asList(animal.getClass().getDeclaredMethods()).stream().anyMatch(x -> x.getName().equals("makeSound"))) {
                System.out.println(animal.getClass().getMethod("makeSound").invoke(animal));
            }
        }

    }
    
} 