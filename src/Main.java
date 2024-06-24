
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ClienteService clienteService = new ClienteService();
    private static TransaccionService transaccionService = new TransaccionService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Ver Cliente");
            System.out.println("3. Ver Todos los Clientes");
            System.out.println("4. Actualizar Cliente");
            System.out.println("5. Eliminar Cliente");
            System.out.println("6. Registrar Pago de Cliente");
            System.out.println("7. Ver Todas las Transacciones");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  

            switch (opcion) {
                case 1:
                    agregarCliente(scanner);
                    break;
                case 2:
                    verCliente(scanner);
                    break;
                case 3:
                    verTodosLosClientes();
                    break;
                case 4:
                    actualizarCliente(scanner);
                    break;
                case 5:
                    eliminarCliente(scanner);
                    break;
                case 6:
                    registrarPagoCliente(scanner);
                    break;
                case 7:
                    verTodasLasTransacciones();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private static void agregarCliente(Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Saldo Inicial: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine();  

        Cliente cliente = new Cliente(0, nombre, saldo);
        clienteService.agregarCliente(cliente);
        System.out.println("Cliente agregado con éxito");
    }

    private static void verCliente(Scanner scanner) {
        System.out.print("ID del cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();  

        Cliente cliente = clienteService.obtenerCliente(id);
        if (cliente != null) {
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Saldo: " + cliente.getSaldo());
        } else {
            System.out.println("Cliente no encontrado");
        }
    }

    private static void verTodosLosClientes() {
        List<Cliente> clientes = clienteService.obtenerTodosLosClientes();
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId());
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Saldo: " + cliente.getSaldo());
            System.out.println("-------------------");
        }
    }

    private static void actualizarCliente(Scanner scanner) {
        System.out.print("ID del cliente a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();  

        Cliente clienteExistente = clienteService.obtenerCliente(id);
        if (clienteExistente == null) {
            System.out.println("Cliente no encontrado");
            return;
        }

        System.out.print("Nuevo Nombre (actual: " + clienteExistente.getNombre() + "): ");
        String nombre = scanner.nextLine();
        System.out.print("Nuevo Saldo (actual: " + clienteExistente.getSaldo() + "): ");
        double saldo = scanner.nextDouble();
        scanner.nextLine();  

        clienteExistente.setNombre(nombre);
        clienteExistente.setSaldo(saldo);
        clienteService.actualizarCliente(clienteExistente);
        System.out.println("Cliente actualizado con éxito");
    }

    private static void eliminarCliente(Scanner scanner) {
        System.out.print("ID del cliente a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();  

        clienteService.eliminarCliente(id);
        System.out.println("Cliente eliminado con éxito");
    }

    private static void registrarPagoCliente(Scanner scanner) {
        System.out.print("ID del cliente: ");
        int clienteId = scanner.nextInt();
        scanner.nextLine();  
        System.out.print("Monto del pago: ");
        double monto = scanner.nextDouble();
        scanner.nextLine();  

        try {
            transaccionService.agregarTransaccion(clienteId, monto);
            System.out.println("Pago registrado con éxito");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void verTodasLasTransacciones() {
        List<Transaccion> transacciones = transaccionService.obtenerTodasLasTransacciones();
        for (Transaccion transaccion : transacciones) {
            System.out.println("ID Transacción: " + transaccion.getId());
            System.out.println("ID Cliente: " + transaccion.getClienteId());
            System.out.println("Monto: " + transaccion.getMonto());
            System.out.println("IGV Causado: " + transaccion.getIgvCausado());
            System.out.println("IGV Pendiente Causado: " + transaccion.getIgvPendienteCausado());
            System.out.println("-------------------");
        }
    }
}
