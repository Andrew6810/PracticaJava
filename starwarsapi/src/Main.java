import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        ConsultaPelicula consulta = new ConsultaPelicula();
        List<Pelicula> peliculas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba un número de una pelicula de Starwars: ");

        try{
            var respuesta = Integer.valueOf(sc.nextLine());
            Pelicula pelicula = consulta.buscaPelicula(respuesta);
            System.out.println(pelicula);
            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(pelicula);
        }catch (NumberFormatException e){
            System.out.println("Número no encontrado" + e.getMessage());
        }catch(RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación.");
        }
    }
}