import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjerciciosLambdasStreams {
    public static void main(String[] args) {
        System.out.println("Ejercicio 1: Filtrar números mayores a 10");
        List<Integer> listaNumeros = new ArrayList<>();
        listaNumeros.add(5);
        listaNumeros.add(15);
        listaNumeros.add(8);
        listaNumeros.add(12);
        listaNumeros.add(3);

        listaNumeros.stream()
                .filter(n ->  n > 10) // Filtrar números mayores a 10
                .forEach(System.out::println);// Imprimir cada número que pase el filtro

        //Ejercicio 2: Sumar elementos de una lista
        System.out.println("\nEjercicio 2: Sumar elementos de una lista");
        int suma = listaNumeros.stream()
                .mapToInt(Integer::intValue)// Convertir Integer a int
                .sum();//sumar todos los valores
        System.out.println("Suma: " + suma);

        // Ejercicio 3: Convertir nombres a mayúsculas
        System.out.println("\nEjercicio 3: Nombres en mayúsculas");
        List<String> nombres = Arrays.asList("andrey" , "snaider" , "dolfin");
        nombres.stream()
                .map(String::toUpperCase)// Convertir cada nombre a mayúscula
                .forEach(System.out::println);
        System.out.println("\nPrimera letra en mayuscula en la lista: ");
        nombres.stream()
                .map(n -> Character.toUpperCase(n.charAt(0)) + n.substring(1).toLowerCase())
                .forEach(System.out::println);
        System.out.println();

        // Ejercicio 4: Ordenar una lista alfabéticamente
        System.out.println("Ejercicio 4: Ordenar una lista alfabéticamente");
        List<String> animales = Arrays.asList("zorro" , "ave" , "perro" , "gato");
        animales.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        // Ejercicio 5: Contar elementos mayores a 50
        System.out.println("Ejercicio 5: Contar números mayores a 50");
        List<Integer> numeros = Arrays.asList(10, 20, 30, 40, 50, 60, 70);
        numeros.stream()
                .filter(n -> n > 50)
                .forEach(System.out::println);
    }
}