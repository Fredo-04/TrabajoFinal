
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private List<Cliente> clientes = new ArrayList<>();
    private int nextId = 1;

    public void agregarCliente(Cliente cliente) {
        cliente.setId(nextId++);
        clientes.add(cliente);
    }

    public Cliente obtenerCliente(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return new ArrayList<>(clientes);
    }

    public void actualizarCliente(Cliente clienteActualizado) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == clienteActualizado.getId()) {
                cliente.setNombre(clienteActualizado.getNombre());
                cliente.setSaldo(clienteActualizado.getSaldo());
                return;
            }
        }
    }

    public void eliminarCliente(int id) {
        clientes.removeIf(cliente -> cliente.getId() == id);
    }
}

