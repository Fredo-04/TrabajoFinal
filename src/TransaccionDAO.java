
import java.util.ArrayList;
import java.util.List;

public class TransaccionDAO {
    private List<Transaccion> transacciones = new ArrayList<>();
    private int nextId = 1;

    public void agregarTransaccion(Transaccion transaccion) {
        transaccion.setId(nextId++);
        transacciones.add(transaccion);
    }

    public List<Transaccion> obtenerTodasLasTransacciones() {
        return new ArrayList<>(transacciones);
    }
}

