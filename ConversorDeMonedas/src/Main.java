import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Buscador persona1 = new Buscador();
        Conversor C1 = new Conversor();
        Scanner sc = new Scanner(System.in);
        int option;
        do{
            System.out.println("***************************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println("***************************************************");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileño");
            System.out.println("4) Real brasileño => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Salir");
            System.out.println("***************************************************");
            System.out.print("Elija una opción válida: ");
            option = sc.nextInt();

            switch (option){
                case 1:
                    C1.convertirMoneda(persona1, "USD", "ARS");
                    break;
                case 2:
                    C1.convertirMoneda(persona1, "ARS", "USD");
                    break;
                case 3:
                    C1.convertirMoneda(persona1, "USD", "BRL");
                    break;
                case 4:
                    C1.convertirMoneda(persona1, "BRL", "USD");
                    break;
                case 5:
                    C1.convertirMoneda(persona1, "USD", "COP");
                    break;
                case 6:
                    C1.convertirMoneda(persona1, "COP", "USD");
                    break;
                case 7:
                    System.out.println("HASTA LUEGO!");
                default:
                    System.out.println("Opción inválida. Por favor elija una opción válida.");
            }
        } while(option !=7);
    }
}
