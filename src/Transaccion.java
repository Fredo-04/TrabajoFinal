
public class Transaccion {
    private int id;
    private int clienteId;
    private double monto;
    private double igvCausado;
    private double igvPendienteCausado;

    public Transaccion(int id, int clienteId, double monto, double igvCausado, double igvPendienteCausado) {
        this.id = id;
        this.clienteId = clienteId;
        this.monto = monto;
        this.igvCausado = igvCausado;
        this.igvPendienteCausado = igvPendienteCausado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getIgvCausado() {
        return igvCausado;
    }

    public void setIgvCausado(double igvCausado) {
        this.igvCausado = igvCausado;
    }

    public double getIgvPendienteCausado() {
        return igvPendienteCausado;
    }

    public void setIgvPendienteCausado(double igvPendienteCausado) {
        this.igvPendienteCausado = igvPendienteCausado;
    }
}
