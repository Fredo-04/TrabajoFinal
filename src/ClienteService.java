
import java.util.List;

public class ClienteService {
    private ClienteDAO clienteDAO = new ClienteDAO();

    public void agregarCliente(Cliente cliente) {
        clienteDAO.agregarCliente(cliente);
    }

    public Cliente obtenerCliente(int id) {
        return clienteDAO.obtenerCliente(id);
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteDAO.obtenerTodosLosClientes();
    }

    public void actualizarCliente(Cliente cliente) {
        clienteDAO.actualizarCliente(cliente);
    }

    public void eliminarCliente(int id) {
        clienteDAO.eliminarCliente(id);
    }
}
