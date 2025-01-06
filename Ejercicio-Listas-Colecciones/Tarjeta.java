import java.util.ArrayList;
import java.util.List;

public class Tarjeta {
    private double limite;
    private double saldoDisponible;
    private List<Compras> compras;

    public Tarjeta (double limite){
        this.limite=limite;
        this.saldoDisponible=limite;
        this.compras = new ArrayList<>();
    }

    public boolean realizarCompra (Compras compra){
        if (compra.getValor() <= limite){
            compras.add(compra);
            saldoDisponible -= compra.getValor();
            System.out.println("Compra Realizada!");
            return true;
        } else {
            System.out.println("Fondos insuficientes. Compra no realizada.");
            return false;
        }
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public List<Compras> getCompras() {
        return compras;
    }
}
