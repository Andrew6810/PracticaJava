import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe el limite de tu tarjeta: ");
        double limiteTarjeta = sc.nextDouble();
        Tarjeta tarjeta1 = new Tarjeta(limiteTarjeta);

        int opcion = 1;

        while(opcion != 0) {
            System.out.println("Escriba la descripcion de la compra: ");
            sc.nextLine();
            String descripcion = sc.nextLine();

            System.out.println("Escriba el valor de la compra: ");
            double valor = sc.nextDouble();

            Compras compra1 = new Compras(descripcion, valor);
            tarjeta1.realizarCompra(compra1);

            System.out.println("Escriba 0 para salir o 1 para continuar: ");
            opcion = sc.nextInt();
        }
        Collections.sort(tarjeta1.getCompras(),Comparator.comparingDouble(Compras::getValor));
        System.out.println("\n****************");

        System.out.println("\nResumen de las compras que haz hecho con tu tarjeta:");
        for (Compras c : tarjeta1.getCompras()){
            System.out.println(c.getDescripcion()+ " - " + c.getValor());
        }
        System.out.println("\n*******************");

        System.out.println("\nSu saldo actual es: " + tarjeta1.getSaldoDisponible());
    }
}
