public class Compras {
    private String descripcion;
    private double valor;

    public Compras(String descripcion, double valor) {
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getValor() {
        return valor;
    }


    public String toString() {
        return this.descripcion + "-" + this.valor;
    }
}
