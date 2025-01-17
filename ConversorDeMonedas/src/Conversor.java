import java.util.Scanner;

public class Conversor {
    public void convertirMoneda(Buscador persona1, String paisOrigen, String paisDestino){
        // Obtener las tasas de cambio para la moneda origen
        Moneda moneda = persona1.obtenertasasdecambio(paisOrigen);
        Scanner sc = new Scanner(System.in);

        //verificamos que el pais se encuentre
        if(moneda.conversion_rates().containsKey(paisOrigen)){
            double tasa = moneda.conversion_rates().get(paisDestino);
            System.out.println("La tasa de cambio de " + paisOrigen + " a " + paisDestino + " es: " + tasa);
            System.out.println("Ingrese la cantidad de dinero a convertir en [" + paisOrigen + "]: ");
            double cantidad = sc.nextDouble();
            double resultado = cantidad * tasa;
            System.out.println(cantidad + "[" + paisOrigen + "]" + " son: " + resultado + "[" + paisDestino + "]");
        } else {
            System.out.println("No se pudo encontrar la tasa de cambio para " + paisDestino);
        }
    }
}
