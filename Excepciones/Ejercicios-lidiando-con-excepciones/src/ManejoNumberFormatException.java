import RuntimeExceptionInvalidoException.RuntimeExceptionInvalidoException;
import RuntimeExceptionInvalidoException.DuracionNegativaException;
import RuntimeExceptionInvalidoException.ValornoNumericoException;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Scanner;

public class ManejoNumberFormatException {
    public static void main(String[] args) {

        String jsonSimulado = """
                {
                    "Title": "Inception",
                    "Year": "2010",
                    "Runtime": "N/A"
                }
                """;
        System.out.println("Simulación de JSON recibido:");
        System.out.println(jsonSimulado);

        // Convertir JSON en un objeto Pelicula
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE_WITH_SPACES)
                .create();

        Pelicula pelicula1 = gson.fromJson(jsonSimulado, Pelicula.class);
        System.out.println("\nPelícula convertida desde JSON:");
        System.out.println(pelicula1);

        // Pedir al usuario que ingrese el Runtime
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPor favor, ingrese el Runtime de la película (ejemplo: '120 min' o 'N/A'):");
        String runtimeString = sc.nextLine();

        try {
            int runtime = convertirRuntime(runtimeString);
            System.out.println("\nEl Runtime convertido a minutos es: " + runtime + " min");
        } catch (RuntimeExceptionInvalidoException | DuracionNegativaException | ValornoNumericoException e) {
            System.out.println("\nOcurrio un error al convertir el Runtime: " + e.getMessage());
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }



    // throws NumberFormatException Declara que este métodoexcepción de este tipo si no logra convertir la cadena a un número.
    private static int convertirRuntime(String runtimeString) {
        if (runtimeString == null || runtimeString.equals("N/A")) {
            throw new RuntimeExceptionInvalidoException("\nEl valor Runtime es invalido: " + runtimeString);
        } else if (runtimeString.startsWith("-")) {
            throw new DuracionNegativaException("\nLa duracion no puede ser negativa!");
        } else if (!runtimeString.contains(" ")) {
            throw new IllegalArgumentException("\nEl valor ingresado no cumple con el formato esperado debe tener un ESPACIO: " + runtimeString);
        } else {
            try {
                return Integer.parseInt(runtimeString.split(" ")[0]);//toma la primera parte del arreglo
            } catch (NumberFormatException e) {
                throw new ValornoNumericoException("\nEl valor ingresado no es numérico: " + runtimeString);
            }
        }

    }

}