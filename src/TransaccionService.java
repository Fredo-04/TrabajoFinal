
import java.util.List;

public class TransaccionService {
    private TransaccionDAO transaccionDAO = new TransaccionDAO();
    private ClienteDAO clienteDAO = new ClienteDAO();

    public void agregarTransaccion(int clienteId, double monto) {
        Cliente cliente = clienteDAO.obtenerCliente(clienteId);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente no encontrado");
        }

        double igvCausado = monto * 0.18;
        double igvPendienteCausado = igvCausado;
        Transaccion transaccion = new Transaccion(0, clienteId, monto, igvCausado, igvPendienteCausado);

        cliente.setSaldo(cliente.getSaldo() - monto);
        clienteDAO.actualizarCliente(cliente);
        transaccionDAO.agregarTransaccion(transaccion);
    }

    public List<Transaccion> obtenerTodasLasTransacciones() {
        return transaccionDAO.obtenerTodasLasTransacciones();
    }
}
