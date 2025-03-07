import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Trabajador> trabajadores = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int contadorId = 1;
    private static String tipoUsuario; // Variable para almacenar el tipo de usuario
    private static List<Vehiculo> vehiculos = new ArrayList<>();
    private static List<Base> bases = new ArrayList<>();
    private static List<Viaje> viajes = new ArrayList<>();

    public static void main(String[] args) {
        inicializarVariables();
        identificarTipoUsuario(); // Identifica si es Admin, Usuario, Mecánico o Mantenimiento

        switch (tipoUsuario.toLowerCase()) {
            case "administrador" -> menuAdministrador();
            case "usuario" -> menuUsuario();
            case "mecanico" -> menuMecanico();
            case "mantenimiento" -> menuMantenimiento();
            default -> System.out.println("Tipo de usuario desconocido.");
        }
    }

    private static void menuAdministrador() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ ADMINISTRADOR ===");
            System.out.println("1. Gestión de Usuarios");
            System.out.println("2. Gestión de Trabajadores");
            System.out.println("3. Estado de batería de todos los vehículos");
            System.out.println("4. Avisos de problemas mecánicos en los vehículos");
            System.out.println("5. Estado de las bases de bicicletas y patinetes");
            System.out.println("6. Asignación de vehículos a mecánicos y mantenimiento");
            System.out.println("7. Datos de todas las personas registradas");
            System.out.println("8. Utilización de vehículos e importes asociados");
            System.out.println("9. Listado de vehículos en uso en un momento/período determinado");
            System.out.println("10. Actualización de la flota de vehículos");
            System.out.println("11. Estadísticas sobre estaciones con mayor/menor demanda");
            System.out.println("12. Promoción de usuarios a premium");
            System.out.println("13. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> menuGestionUsuarios();
                case 2 -> menuGestionTrabajadores();
                case 3 -> mostrarBateria();
                case 4 -> mostrarProblemas();
                case 5 -> mostrarBases();
                case 6 -> asignar();
                case 7 -> mostrarDatosUsuarios();
                case 8 -> mostrarDatosUsoVehiculos();
                case 9 -> System.out.println("Listado de vehículos en uso... (TODO)");
                case 10 -> System.out.println("Actualización de flota... (TODO)");
                case 11 -> System.out.println("Generando estadísticas... (TODO)");
                case 12 -> System.out.println("Promoción de usuarios a premium... (TODO)");
                case 13 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 13);
    }

    private static void menuUsuario() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ USUARIO ===");
            System.out.println("1. Consultar historial de viajes");
            System.out.println("2. Consultar saldo");
            System.out.println("3. Recargar saldo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> System.out.println("Mostrando historial de viajes... (TODO)");
                case 2 -> System.out.println("Mostrando saldo... (TODO)");
                case 3 -> System.out.println("Recargando saldo... (TODO)");
                case 4 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    private static void menuMecanico() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ MECÁNICO ===");
            System.out.println("1. Consultar vehículos asignados");
            System.out.println("2. Reportar reparación completada");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> System.out.println("Mostrando vehículos asignados... (TODO)");
                case 2 -> System.out.println("Reportando reparación completada... (TODO)");
                case 3 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 3);
    }

    private static void menuMantenimiento() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ MANTENIMIENTO ===");
            System.out.println("1. Consultar estaciones asignadas");
            System.out.println("2. Reportar estación revisada");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> System.out.println("Mostrando estaciones asignadas... (TODO)");
                case 2 -> System.out.println("Reportando estación revisada... (TODO)");
                case 3 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 3);
    }

    private static void inicializarVariables() {
        // Coordenadas de ejemplo
        Coordenada coord1 = new Coordenada(40.4168, -3.7038); // Madrid
        Coordenada coord2 = new Coordenada(41.3879, 2.1699); // Barcelona
        Coordenada coord3 = new Coordenada(39.4699, -0.3763); // Valencia
        Coordenada coord4 = new Coordenada(37.7749, -122.4194); // San Francisco

        // Añadir dos motos
        vehiculos.add(new Moto(1, "Moto", "Disponible", coord1, 85.0f, 125, "125cc"));
        vehiculos.add(new Moto(2, "Moto", "En mantenimiento", coord2, 40.0f, 250, "250cc"));

        Base base1 = new Base(1, "Base Este", coord3, 25);
        Base base2 = new Base(2, "Base Oeste", coord4, 40);

        // Añadir dos patinetes
        vehiculos.add(new Patinete(3, "Patinete", "Disponible", coord1, 90.0f, 0, base1));
        vehiculos.add(new Patinete(4, "Patinete", "En uso", coord2, 30.0f, 0, base2));
        base1.addVehiculo(vehiculos.get(2));
        base2.addVehiculo(vehiculos.get(3));

        // Añadir dos bicicletas
        vehiculos.add(new Bicicleta(5, "Bicicleta", "Disponible", coord1, 100.0f, base1));
        vehiculos.add(new Bicicleta(6, "Bicicleta", "Averiada", coord2, 50.0f, base2));

        base1.addVehiculo(vehiculos.get(4));
        base2.addVehiculo(vehiculos.get(5));

        bases.add(base1);
        bases.add(base2);

        Usuario usuario1 = new Usuario(1, "Juan", "Pérez", "12345678L", "Estándar");
        Usuario usuario2 = new Usuario(2, "María", "López", "87654321M", "Premium");
        
        Viaje viaje = new Viaje(1,usuario1,vehiculos.get(0),coord1,coord2,250);
        usuario1.realizarViaje(viaje);

        usuarios.add(usuario1);
        usuarios.add(usuario2);

        trabajadores.add(new Mecanico(contadorId, "Hugo", "Iglesias", "56"));
        contadorId++;
        trabajadores.add(new Mantenimiento(contadorId, "Juan", "Villa", "09"));
        contadorId++;
        trabajadores.add(new Administrador(contadorId, "Jose", "Bermudez", "82"));
        contadorId++;
    }

    // ==============================
    // MÉTODO PARA IDENTIFICAR EL TIPO DE USUARIO
    // ==============================
    private static void identificarTipoUsuario() {
        System.out.println("Seleccione su tipo de usuario:");
        System.out.println("1. Usuario");
        System.out.println("2. Administrador");
        System.out.println("3. Mecánico");
        System.out.println("4. Encargado de Mantenimiento");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        tipoUsuario = switch (opcion) {
            case 1 -> "Usuario";
            case 2 -> "Administrador";
            case 3 -> "Mecánico";
            case 4 -> "Encargado de Mantenimiento";
            default -> {
                System.out.println("Tipo de usuario inválido. Se establecerá como Usuario por defecto.");
                yield "Usuario";
            }
        };

        System.out.println("Tipo de usuario seleccionado: " + tipoUsuario);
    }

    // ==============================
    // SUBMENÚ DE GESTIÓN DE USUARIOS
    // ==============================
    private static void menuGestionUsuarios() {
        int opcion;
        do {
            System.out.println("\n=== Gestión de Usuarios ===");
            System.out.println("1. Alta de usuario");
            System.out.println("2. Baja de usuario");
            System.out.println("3. Modificación de usuario");
            System.out.println("4. Listar usuarios");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> altaUsuario();
                case 2 -> bajaUsuario();
                case 3 -> modificarUsuario();
                case 4 -> listarUsuarios();
                case 5 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    // ==============================
    // SUBMENÚ DE GESTIÓN DE TRABAJADORES
    // ==============================
    private static void menuGestionTrabajadores() {
        int opcion;
        do {
            System.out.println("\n=== Gestión de Trabajadores ===");
            System.out.println("1. Alta de trabajador");
            System.out.println("2. Baja de trabajador");
            System.out.println("3. Modificación de trabajador");
            System.out.println("4. Listar trabajadores");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> altaTrabajador();
                case 2 -> bajaTrabajador();
                case 3 -> modificarTrabajador();
                case 4 -> listarTrabajadores();
                case 5 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    // ==============================
    // MÉTODO PARA DAR DE ALTA UN USUARIO
    // ==============================
    private static void altaUsuario() {
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("Ingrese DNI: ");
        String dni = scanner.nextLine();

        System.out.println("Seleccione el tipo de usuario:");
        System.out.println("1. Estándar");
        System.out.println("2. Premium");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        String tipoUsuario = switch (tipo) {
            case 1 -> "Estándar";
            case 2 -> "Premium";
            default -> {
                System.out.println("Tipo de usuario inválido.");
                yield null;
            }
        };

        if (tipoUsuario != null) {
            Usuario nuevoUsuario = new Usuario(contadorId, nombre, apellidos, dni, tipoUsuario);
            usuarios.add(nuevoUsuario);
            System.out.println("Usuario agregado correctamente.");
            contadorId++;
        }
    }

    // ==============================
    // MÉTODO PARA DAR DE BAJA UN USUARIO
    // ==============================
    private static void bajaUsuario() {
        System.out.print("Ingrese el DNI del usuario a eliminar: ");
        String dni = scanner.nextLine();

        Usuario usuarioEliminar = buscarUsuarioPorDni(dni);
        if (usuarioEliminar != null) {
            usuarios.remove(usuarioEliminar);
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    // ==============================
    // MÉTODO PARA MODIFICAR UN USUARIO
    // ==============================
    private static void modificarUsuario() {
        System.out.print("Ingrese el DNI del usuario a modificar: ");
        String dni = scanner.nextLine();

        Usuario usuarioModificar = buscarUsuarioPorDni(dni);
        if (usuarioModificar != null) {
            System.out.println("Usuario encontrado. Seleccione el nuevo tipo de usuario:");
            System.out.println("1. Estándar");
            System.out.println("2. Premium");

            int tipo = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            String nuevoTipoUsuario = switch (tipo) {
                case 1 -> "Estándar";
                case 2 -> "Premium";
                default -> {
                    System.out.println("Tipo de usuario inválido.");
                    yield null;
                }
            };

            if (nuevoTipoUsuario != null) {
                usuarioModificar.setTipoUsuario(nuevoTipoUsuario);
                System.out.println("Tipo de usuario modificado correctamente a " + nuevoTipoUsuario + ".");
            }
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    // ==============================
    // MÉTODO PARA LISTAR LOS USUARIOS
    // ==============================
    private static void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("\n=== Lista de Usuarios ===");
            for (Usuario u : usuarios) {
                u.mostrarInfo();
            }
        }
    }

    // ==============================
    // MÉTODO PARA BUSCAR USUARIO POR DNI
    // ==============================
    private static Usuario buscarUsuarioPorDni(String dni) {
        for (Usuario u : usuarios) {
            if (u.getDni().equalsIgnoreCase(dni)) {
                return u;
            }
        }
        return null;
    }

    // ==============================
    // MÉTODO PARA DAR DE ALTA UN TRABAJADOR
    // ==============================
    private static void altaTrabajador() {
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("Ingrese DNI: ");
        String dni = scanner.nextLine();

        System.out.println("Seleccione el rol del trabajador:");
        System.out.println("1. Mecánico");
        System.out.println("2. Mantenimiento");
        System.out.println("3. Administrador");

        int rol = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        switch (rol) {
            case 1 -> {
                Mecanico nuevoTrabajador = new Mecanico(contadorId, nombre, apellidos, dni);
                trabajadores.add(nuevoTrabajador);
            }
            case 2 -> {
                Mantenimiento nuevoTrabajador = new Mantenimiento(contadorId, nombre, apellidos, dni);
                trabajadores.add(nuevoTrabajador);
            }
            case 3 -> {
                Administrador nuevoTrabajador = new Administrador(contadorId, nombre, apellidos, dni);
                trabajadores.add(nuevoTrabajador);
            }
            default -> {
                System.out.println("Rol de trabajador inválido.");
                return; // Salimos del método si el rol es inválido
            }
        }

        System.out.println("Trabajador agregado correctamente.");
        contadorId++;
    }

    // ==============================
    // MÉTODO PARA DAR DE BAJA UN TRABAJADOR
    // ==============================
    private static void bajaTrabajador() {
        System.out.print("Ingrese el DNI del trabajador a eliminar: ");
        String dni = scanner.nextLine();

        Trabajador trabajadorEliminar = buscarTrabajadorPorDni(dni);
        if (trabajadorEliminar != null) {
            trabajadores.remove(trabajadorEliminar);
            System.out.println("Trabajador eliminado correctamente.");
        } else {
            System.out.println("Trabajador no encontrado.");
        }
    }

    // ==============================
    // MÉTODO PARA MODIFICAR UN TRABAJADOR
    // ==============================
    private static void modificarTrabajador() {
        System.out.print("Ingrese el DNI del trabajador a modificar: ");
        String dni = scanner.nextLine();

        Trabajador trabajadorModificar = buscarTrabajadorPorDni(dni);
        if (trabajadorModificar != null) {
            System.out.println("Trabajador encontrado. Seleccione el nuevo rol:");
            System.out.println("1. Mecánico");
            System.out.println("2. Mantenimiento");
            System.out.println("3. Administrador");

            int rol = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            Trabajador nuevoTrabajador = null;

            switch (rol) {
                case 1 -> nuevoTrabajador = new Mecanico(trabajadorModificar);
                case 2 -> nuevoTrabajador = new Mantenimiento(trabajadorModificar);
                case 3 -> {
                    nuevoTrabajador = new Administrador(trabajadorModificar);
                }
            }

            // Si se creó un nuevo trabajador, reemplazamos en la lista
            if (nuevoTrabajador != null) {
                trabajadores.remove(trabajadorModificar); // Eliminar el anterior
                trabajadores.add(nuevoTrabajador); // Agregar el nuevo
                Collections.sort(trabajadores);
                System.out.println(
                        "Trabajador modificado correctamente a " + nuevoTrabajador.getClass().getSimpleName() + ".");
            }
        } else {
            System.out.println("Trabajador no encontrado.");
        }
    }

    // ==============================
    // MÉTODO PARA LISTAR LOS TRABAJADORES
    // ==============================
    private static void listarTrabajadores() {
        if (trabajadores.isEmpty()) {
            System.out.println("No hay trabajadores registrados.");
        } else {
            System.out.println("\n=== Lista de Trabajadores ===");
            for (Trabajador t : trabajadores) {
                t.mostrarInfo();
            }
        }
    }

    // ==============================
    // MÉTODO PARA BUSCAR TRABAJADOR POR DNI
    // ==============================
    private static Trabajador buscarTrabajadorPorDni(String dni) {
        for (Trabajador t : trabajadores) {
            if (t.getDni().equalsIgnoreCase(dni)) {
                return t;
            }
        }
        return null;
    }

    private static void mostrarBateria() {
        for (Vehiculo v : vehiculos) {
            v.consultarBatería();
        }
    }

    private static void mostrarProblemas() {
        int numErrores = 0;
        for (Vehiculo v : vehiculos) {
            if (v.getProblema() != "") {
                numErrores++;
                System.out.println("Vehiculo Nº" + v.getId() + " Problemas:" + v.getProblema());
            }
        }
        if (numErrores == 0) {
            System.out.println("No hay errores en vehículos");
        }
    }

    private static void mostrarBases() {
        for (Base base : bases) {
            base.mostrarEstado();
        }
    }

    private static void asignar() {
        while (true) {
            System.out.println("\n=== Asignación ===");
            System.out.println("1. Asignar a Mecánico");
            System.out.println("2. Asignar a Mantenimiento");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1 -> {
                    mostrarMecanicos();
                    asignarMecanico();
                }
                case 2 -> {
                    mostrarMantenimiento();
                    asignarMantenimiento();
                }
                case 3 -> {
                    return; // Salir del método asignar
                }
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private static void mostrarMecanicos() {
        int i = 0;
        System.out.println("Lista Mecánicos");
        for (Trabajador trabajador : trabajadores) {
            if (trabajador.getClass().getSimpleName() == "Mecanico") {
                i++;
                trabajador.mostrarInfo();
            }
        }
        if (i == 0) {
            System.out.println("No hay Mecanicos");
        }
    }

    private static void mostrarMantenimiento() {
        int i = 0;
        System.out.println("Lista Mantenimiento");
        for (Trabajador trabajador : trabajadores) {
            if (trabajador.getClass().getSimpleName() == "Mantenimiento") {
                trabajador.mostrarInfo();
                i++;
            }
        }
        if (i == 0) {
            System.out.println("No hay trabajdores de Mantenimiento");
        }
    }

    private static void asignarMecanico() {
        if (trabajadores.isEmpty())
            return;

        System.out.print("Seleccione el ID del mecánico: ");
        int idMecanico = scanner.nextInt();
        scanner.nextLine();

        Mecanico mecanicoSeleccionado = (Mecanico) trabajadores.stream()
                .filter(m -> m instanceof Mecanico && m.getId() == idMecanico)
                .findFirst()
                .orElse(null);

        if (mecanicoSeleccionado == null) {
            System.out.println("Mecánico no encontrado.");
            return;
        }

        System.out.println("Seleccione la asignación:");
        System.out.println("1. Asignar Vehículo");
        System.out.println("2. Asignar Base");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1 -> asignarVehiculo(mecanicoSeleccionado);
            case 2 -> asignarBase(mecanicoSeleccionado);
            default -> System.out.println("Opción inválida.");
        }
    }

    private static void asignarMantenimiento() {
        if (trabajadores.isEmpty())
            return;

        System.out.print("Seleccione el ID del mecánico: ");
        int idMecanico = scanner.nextInt();
        scanner.nextLine();

        Mecanico mecanicoSeleccionado = (Mecanico) trabajadores.stream()
                .filter(m -> m instanceof Mecanico && m.getId() == idMecanico)
                .findFirst()
                .orElse(null);

        if (mecanicoSeleccionado == null) {
            System.out.println("Mecánico no encontrado.");
            return;
        }

        System.out.println("Seleccione la asignación:");
        System.out.println("1. Asignar Vehículo");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1 -> asignarVehiculo(mecanicoSeleccionado);
            default -> System.out.println("Opción inválida.");
        }
    }

    private static void asignarVehiculo(Trabajador trabajador) {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos disponibles.");
            return;
        }

        System.out.println("Lista de Vehículos:");
        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo v = vehiculos.get(i);
            System.out.println((i + 1) + ". " + v.getClass().getSimpleName() + " - ID: " + v.getId() +
                    ", Estado: " + v.getEstado() + ", Batería: " + v.getBateria() + "%");
        }

        System.out.print("Seleccione un vehículo: ");
        int opcionVehiculo = scanner.nextInt();
        scanner.nextLine();

        if (opcionVehiculo < 1 || opcionVehiculo > vehiculos.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        Vehiculo vehiculoSeleccionado = vehiculos.get(opcionVehiculo - 1);
        trabajador.asignarVehiculo(vehiculoSeleccionado);

        System.out.println(vehiculoSeleccionado.getClass().getSimpleName() + " ID: " + vehiculoSeleccionado.getId() +
                " asignado a " + trabajador.getNombre());
    }

    private static void asignarBase(Trabajador trabajador) {
        if (!(trabajador instanceof Mecanico)) {
            System.out.println("Solo los mecánicos pueden ser asignados a una base.");
            return;
        }

        if (bases.isEmpty()) {
            System.out.println("No hay bases disponibles.");
            return;
        }

        System.out.println("Lista de Bases:");
        for (int i = 0; i < bases.size(); i++) {
            System.out.println((i + 1) + ". " + bases.get(i).getNombre());
        }

        System.out.print("Seleccione una base: ");
        int opcionBase = scanner.nextInt();
        scanner.nextLine();

        if (opcionBase < 1 || opcionBase > bases.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        Base baseSeleccionada = bases.get(opcionBase - 1);
        ((Mecanico) trabajador).asignarBase(baseSeleccionada);

        System.out.println("Base " + baseSeleccionada.getNombre() + " asignada a " + trabajador.getNombre());
    }

    private static void mostrarDatosUsuarios() {
        for (Usuario u : usuarios) {
            u.mostrarInfo();
        }
    }

    private static void mostrarDatosUsoVehiculos() {
        for (Usuario u : usuarios) {
            // Verificar si el historial de viajes está vacío
            if (u.getHistorialViajes() == null || u.getHistorialViajes().isEmpty()) {
                System.out.println(u.getNombre() + " no ha realizado ningún viaje.");
                continue; // Continuar con el siguiente usuario
            }
    
            System.out.println("Historial de viajes de " + u.getNombre() + ":");
            double totalGastado = 0;
    
            // Recorrer los viajes del usuario
            for (Viaje viaje : u.getHistorialViajes()) {
                System.out.println(" - Vehículo ID: " + viaje.getVehiculo().getId() +
                        " (" + viaje.getVehiculo().getClass().getSimpleName() + ")" +
                        " | Costo: " + viaje.getCoste() + " euros");
    
                totalGastado += viaje.getCoste();
            }
    
            System.out.println("Total gastado por " + u.getNombre() + ": " + totalGastado + " euros");
        }
    }
    

}