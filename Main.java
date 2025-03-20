import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Trabajador> trabajadores = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int contadorId = 1;
    private static int contadorIdViaje = 1;
    private static String tipoUsuario; // Variable para almacenar el tipo de usuario
    private static List<Vehiculo> vehiculos = new ArrayList<>();
    private static List<Base> bases = new ArrayList<>();
    private static List<Viaje> viajes = new ArrayList<>();

    public static void main(String[] args) {
        inicializarVariables();
        identificarTipoUsuario(); // Identifica si es Admin, Usuario, Mecánico o Mantenimiento

        while (!tipoUsuario.equalsIgnoreCase("salir")) {
            switch (tipoUsuario.toLowerCase()) {
                case "administrador" -> menuAdministrador();
                case "usuario" -> menuUsuario();
                case "mecanico" -> menuMecanico();
                case "mantenimiento" -> menuMantenimiento();
                case "salir" -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Tipo de usuario desconocido.");
            }
        }

        System.out.println("Programa finalizado.");
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
                case 13 -> {
                    System.out.println("Volviendo a la selección de tipo de usuario...");
                    identificarTipoUsuario(); // Volver a la selección de usuario
                    return;
                }
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 13);
    }

    private static void menuUsuario() {
        int opcionAlumno;
        // Mostrar alumnos y opción de salir
        do {
            System.out.println("\n=== LISTA DE USUARIOS ===");
            for (int i = 0; i < usuarios.size(); i++) {
                System.out.println((i + 1) + ". " + usuarios.get(i).getNombre() + " " + usuarios.get(i).getApellidos());
            }
            System.out.println("0. Salir"); // Opción para salir

            System.out.print("Seleccione un usuario: ");
            opcionAlumno = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            if (opcionAlumno == 0) {
                System.out.println("Volviendo a la selección de tipo de usuario... \n");
                identificarTipoUsuario(); // Volver a la selección de usuario
                return;
            }

            if (opcionAlumno < 1 || opcionAlumno > usuarios.size()) {
                System.out.println("Selección inválida. Intente de nuevo.");
                continue; // Volver a mostrar la lista de usuarios si la opción es inválida
            }

            String usuarioSeleccionado = usuarios.get(opcionAlumno - 1).getNombre();
            System.out.println("\nUsuario seleccionado: " + usuarioSeleccionado);
            Usuario usuario = getUsuarioByName(usuarioSeleccionado);

            int opcion;
            do {
                System.out.println("\n=== MENÚ USUARIO ===");
                System.out.println("1. Consultar vehículos disponibles (bases y coordenadas)");
                System.out.println("2. Alquilar un vehículo");
                System.out.println("3. Informar problema con un vehículo o base");
                System.out.println("4. Ver historial de viajes e importes");
                System.out.println("5. Consultar saldo y recargar");
                System.out.println("6. Generar aviso de problemas mecánicos");
                System.out.println("7. Consultar ubicación de la moto más cercana");
                System.out.println("8. Reservar viaje (solo premium)");
                System.out.println("9. Volver al menú principal");
                System.out.print("Seleccione una opción: ");

                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1 -> consultarVehiculosDisponibles();
                    case 2 -> alquilarVehiculo(usuario);
                    case 3 -> informarProblema(usuario);
                    case 4 -> verHistorialViajes(usuario);
                    case 5 -> consultarSaldo(usuario);
                    case 6 -> generarAvisoProblema(usuario);
                    case 7 -> consultarMotoCercana();
                    case 8 -> reservarViaje(usuario);
                    case 9 -> {
                        System.out.println("Saliendo al menú principal...");
                        return; // Regresar al menú principal
                    }
                    default -> System.out.println("Opción inválida. Intente de nuevo.");
                }
            } while (true); // Mantener el ciclo del menú usuario hasta que elija la opción 9
        } while (true); // El ciclo de mostrar usuarios se repetirá hasta que se elija 0
    }

    private static void menuMecanico() {
    List<Mecanico> mecanicos = trabajadores.stream()
        .filter(t -> t.getClass().getSimpleName().equals("Mecanico"))
        .map(t -> (Mecanico) t)
        .collect(Collectors.toList());

    int opcionMecanico;
    do {
        System.out.println("\n=== LISTA DE MECÁNICOS ===");
        for (int i = 0; i < mecanicos.size(); i++) {
            System.out.println((i + 1) + ". " + mecanicos.get(i).getNombre() + " " + mecanicos.get(i).getApellidos());
        }
        System.out.println("0. Salir");

        System.out.print("Seleccione un mecánico: ");
        opcionMecanico = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        if (opcionMecanico == 0) {
            System.out.println("Volviendo a la selección de tipo de usuario...\n");
            identificarTipoUsuario();
            return;
        }

        if (opcionMecanico < 1 || opcionMecanico > mecanicos.size()) {
            System.out.println("Selección inválida. Intente de nuevo.");
            continue;
        }

        Mecanico mecanico = mecanicos.get(opcionMecanico - 1);
        System.out.println("\nMecánico seleccionado: " + mecanico.getNombre());

        int opcion;
        do {
            System.out.println("\n=== MENÚ MECÁNICO ===");
            System.out.println("1. Consultar vehículos asignados");
            System.out.println("2. Reportar reparación completada");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> mostrarVehiculosAsignados(mecanico);
                case 2 -> reportarReparacion(mecanico);
                case 3 -> {
                    System.out.println("Volviendo al menú principal...");
                    return;
                }
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (true);
    } while (true);
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
        vehiculos.add(new Moto(1, "Moto", "Disponible", coord1, 85.0f, 125, "125cc", true));
        Moto moto = new Moto(2, "Moto", "En mantenimiento", coord2, 40.0f, 250, "250cc", false);
        moto.setProblema("Fallo en el motor");
        vehiculos.add(moto);

        Base base1 = new Base(1, "Base Este", coord3, 25);
        Base base2 = new Base(2, "Base Oeste", coord4, 40);

        // Añadir dos patinetes
        vehiculos.add(new Patinete(3, "Patinete", "Disponible", coord1, 90.0f, 0, base1, true));
        vehiculos.add(new Patinete(4, "Patinete", "En uso", coord2, 30.0f, 0, base2, false));
        base1.addVehiculo(vehiculos.get(2));
        base2.addVehiculo(vehiculos.get(3));

        // Añadir dos bicicletas
        vehiculos.add(new Bicicleta(5, "Bicicleta", "Disponible", coord1, 100.0f, base1, true));
        vehiculos.add(new Bicicleta(6, "Bicicleta", "Averiada", coord2, 50.0f, base2, true));

        base1.addVehiculo(vehiculos.get(4));
        base2.addVehiculo(vehiculos.get(5));

        bases.add(base1);
        bases.add(base2);

        Usuario usuario1 = new Usuario(1, "Juan", "Pérez", "12345678L", "Estándar");
        Usuario usuario2 = new Usuario(2, "María", "López", "87654321M", "Premium");

        Viaje viaje = new Viaje(1, usuario1, vehiculos.get(0), coord1, coord2, 250);
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
        System.out.println("5. Salir");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        tipoUsuario = switch (opcion) {
            case 1 -> "Usuario";
            case 2 -> "Administrador";
            case 3 -> "Mecanico";
            case 4 -> "Mantenimiento";
            case 5 -> "Salir";
            default -> {
                System.out.println("Tipo de usuario inválido. Se establecerá como Usuario por defecto.");
                yield "Usuario";
            }
        };
        if (opcion != 5) {
            System.out.println("Tipo de usuario seleccionado: " + tipoUsuario);
        }

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

    private static void consultarVehiculosDisponibles() {
        for (Vehiculo v : vehiculos) {
            if (v.isDisponible() == true) {
                System.out.println("ID: " + v.getId() + " " + v.getClass().getSimpleName());
            }
        }
    }

    private static void alquilarVehiculo(Usuario usuario) {
        System.out.println("\n=== ALQUILER DE VEHÍCULO ===");

        try {
            // Mostrar lista de vehículos disponibles
            System.out.println("Vehículos disponibles:");
            for (int i = 0; i < vehiculos.size(); i++) {
                if (vehiculos.get(i).isDisponible()) {
                    System.out.println((i + 1) + ". " + vehiculos.get(i).getId() + " "
                            + vehiculos.get(i).getClass().getSimpleName());
                }
            }

            // Seleccionar vehículo
            System.out.print("Seleccione el número del vehículo que desea alquilar: ");
            int opcionVehiculo = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            if (opcionVehiculo < 1 || opcionVehiculo > vehiculos.size()) {
                System.out.println("Selección inválida. Intente de nuevo.");
                return;
            }

            Vehiculo vehiculoSeleccionado = vehiculos.get(opcionVehiculo - 1);
            System.out.println("Has seleccionado: " + vehiculoSeleccionado.getClass().getSimpleName());

            if (vehiculoSeleccionado.getClass().getSimpleName().equals("Moto")) {
                try {
                    System.out.print("Ingrese las coordenadas de inicio (ejemplo: 40.4168,-3.7038): ");
                    String[] inicioInput = scanner.nextLine().split(",");
                    Coordenada inicio = new Coordenada(Double.parseDouble(inicioInput[0]),
                            Double.parseDouble(inicioInput[1]));

                    System.out.print("Ingrese las coordenadas de destino (ejemplo: 40.4170,-3.7045): ");
                    String[] finInput = scanner.nextLine().split(",");
                    Coordenada fin = new Coordenada(Double.parseDouble(finInput[0]), Double.parseDouble(finInput[1]));

                    double distancia = calcularDistancia(inicio, fin);
                    double tarifaBase = 1.5;
                    double costePorKm = 0.5;
                    double coste = Math.round((tarifaBase + (distancia * costePorKm)) * 100.0) / 100.0;

                    System.out.println("Moto reservada desde " + inicio + " hasta " + fin);
                    System.out.println("Costo estimado del viaje: " + coste + "€");

                    Viaje viaje = new Viaje(opcionVehiculo, usuario, vehiculoSeleccionado, inicio, fin, coste);
                    contadorIdViaje++;
                    System.out.println(viaje);
                    vehiculoSeleccionado.setDisponible(false);
                    usuario.realizarViaje(viaje);
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error en el formato de coordenadas. Inténtelo de nuevo.");
                    return;
                }
            } else {
                System.out.println("\nBases disponibles:");
                for (int i = 0; i < bases.size(); i++) {
                    System.out.println((i + 1) + ". " + bases.get(i));
                }

                try {
                    System.out.print("Seleccione la base de inicio: ");
                    int baseInicio = scanner.nextInt();
                    scanner.nextLine();
                    if (baseInicio < 1 || baseInicio > bases.size()) {
                        System.out.println("Selección inválida. Intente de nuevo.");
                        return;
                    }

                    System.out.print("Seleccione la base de destino: ");
                    int baseDestino = scanner.nextInt();
                    scanner.nextLine();
                    if (baseDestino < 1 || baseDestino > bases.size()) {
                        System.out.println("Selección inválida. Intente de nuevo.");
                        return;
                    }
                    double distancia = calcularDistancia(bases.get(baseInicio - 1).getCoordenadas(),
                            bases.get(baseDestino - 1).getCoordenadas());
                    double tarifaBase = 1.5;
                    double costePorKm = 0.5;
                    double coste = Math.round((tarifaBase + (distancia * costePorKm)) * 100.0) / 100.0;
                    System.out.println(vehiculoSeleccionado + " reservado desde " + bases.get(baseInicio - 1)
                            + " hasta " + bases.get(baseDestino - 1));

                    Viaje viaje = new Viaje(opcionVehiculo, usuario, vehiculoSeleccionado,
                            bases.get(baseInicio - 1).getCoordenadas(), bases.get(baseDestino - 1).getCoordenadas(),
                            coste);
                    contadorIdViaje++;
                    vehiculoSeleccionado.setDisponible(false);
                    System.out.println(viaje);
                    usuario.realizarViaje(viaje);
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Asegúrese de ingresar un número.");
                    scanner.nextLine(); // Limpiar buffer
                }
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }

    private static Usuario getUsuarioByName(String nombreUsuario) {
        for (Usuario u : usuarios) {
            if (u.getNombre().equals(nombreUsuario)) {
                return u;
            }
        }
        return null;
    }

    public static double calcularDistancia(Coordenada inicio, Coordenada fin) {
        final int RADIO_TIERRA = 6371; // Radio de la Tierra en km

        double lat1 = Math.toRadians(inicio.getY());
        double lon1 = Math.toRadians(inicio.getX());
        double lat2 = Math.toRadians(fin.getY());
        double lon2 = Math.toRadians(fin.getX());

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return RADIO_TIERRA * c; // Distancia en kilómetros
    }

    public static void informarProblema(Usuario usuario) {
        System.out.println("\n=== INFORMAR PROBLEMA EN VEHÍCULO ===");

        // Verificar si el usuario tiene historial de viajes
        if (usuario.getHistorialViajes().isEmpty()) {
            System.out.println("No tienes viajes en tu historial para reportar problemas.");
            return;
        }

        // Mostrar historial de viajes
        System.out.println("Selecciona un viaje para reportar un problema:");
        List<Viaje> historial = usuario.getHistorialViajes();
        for (int i = 0; i < historial.size(); i++) {
            System.out.println((i + 1) + ". " + historial.get(i).getVehiculo().getId() + " - " +
                    historial.get(i).getVehiculo().getClass().getSimpleName());
        }

        // Seleccionar un viaje
        System.out.print("Ingrese el número del viaje: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        if (opcion < 1 || opcion > historial.size()) {
            System.out.println("Selección inválida. Intente de nuevo.");
            return;
        }

        // Obtener el vehículo asociado al viaje seleccionado
        Viaje viajeSeleccionado = historial.get(opcion - 1);
        Vehiculo vehiculo = viajeSeleccionado.getVehiculo();

        // Ingresar problema
        System.out.print("Describa el problema con el vehículo: ");
        String descripcionProblema = scanner.nextLine();

        // Establecer problema en el vehículo
        vehiculo.setProblema(descripcionProblema);
        System.out.println("Problema reportado exitosamente para el vehículo " + vehiculo.getId());
    }

    public static void verHistorialViajes(Usuario usuario) {
        List<Viaje> viajes = usuario.getHistorialViajes();
        System.out.println("Viajes de " + usuario.getNombre() + " " + usuario.getApellidos());
        int contadorViajes = 1;
        for (Viaje v : viajes) {
            System.out.println("Viaje " + contadorViajes + " vehiculo: " + v.getVehiculo().getClass().getSimpleName()
                    + " " + v.getId());
            contadorViajes++;
        }
    }

    public static void consultarSaldo(Usuario usuario) {
        System.out.println("\n=== CONSULTAR SALDO ===");
        System.out.println("Saldo actual: " + usuario.getSaldo() + "€");

        System.out.print("¿Desea aumentar su saldo? (Sí/No): ");
        String respuesta = scanner.nextLine().trim().toLowerCase();

        if (respuesta.equals("sí") || respuesta.equals("si")) {
            System.out.print("Ingrese la cantidad a recargar: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            if (cantidad > 0) {
                usuario.aumentarSaldo(cantidad);
                System.out.println("Saldo actualizado: " + usuario.getSaldo() + "€");
            } else {
                System.out.println("Cantidad no válida. La recarga debe ser mayor a 0.");
            }
        } else {
            System.out.println("No se ha realizado ninguna recarga.");
        }
    }

    public static void generarAvisoProblema(Usuario usuario) {
        System.out.println("\n=== GENERAR AVISO DE PROBLEMA ===");

        // Obtener historial de viajes
        List<Viaje> historial = usuario.getHistorialViajes();

        // Verificar si el usuario tiene viajes
        if (historial.isEmpty()) {
            System.out.println("No tiene viajes registrados.");
            return;
        }

        // Mostrar historial de viajes numerado
        System.out.println("Seleccione un vehículo de su historial de viajes:");
        for (int i = 0; i < historial.size(); i++) {
            System.out.println((i + 1) + ". " + historial.get(i).getVehiculo().toString());
        }

        System.out.print("Ingrese el número del vehículo: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        // Validar opción
        if (opcion < 1 || opcion > historial.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        // Obtener vehículo seleccionado
        Vehiculo vehiculoSeleccionado = historial.get(opcion - 1).getVehiculo();

        // Solicitar descripción del problema
        System.out.print("Describa el problema del vehículo: ");
        String problema = scanner.nextLine();

        // Registrar problema en el vehículo
        vehiculoSeleccionado.setProblema(problema);
        vehiculoSeleccionado.setDisponible(false);
        System.out.println("Problema registrado correctamente para el vehículo: " + vehiculoSeleccionado);
    }

    public static void consultarMotoCercana() {
        // Pedir ubicación del usuario
        System.out.println("Ingrese su ubicación (x): ");
        System.out.println("Usa el separador decimal de ,");
        double xUsuario = scanner.nextDouble();
        System.out.println("Ingrese su ubicación (y): ");
        double yUsuario = scanner.nextDouble();
        Coordenada ubicacionUsuario = new Coordenada(xUsuario, yUsuario);

        Vehiculo motoCercana = null;
        double distanciaMinima = Double.MAX_VALUE;

        // Buscar la moto más cercana
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getClass().getSimpleName().equalsIgnoreCase("moto") && vehiculo.isDisponible()) {
                double distancia = calcularDistancia(ubicacionUsuario, vehiculo.getUbicacion());

                if (distancia < distanciaMinima) {
                    distanciaMinima = distancia;
                    motoCercana = vehiculo;
                }
            }
        }

        // Mostrar resultado
        if (motoCercana != null) {
            System.out.println("\nLa moto más cercana es:");
            System.out.println(motoCercana);
            System.out.printf("Distancia aproximada: %.2f KM\n", distanciaMinima);
        } else {
            System.out.println("No hay motos disponibles en este momento.");
        }
    }

    public static void reservarViaje(Usuario usuario) {
        if (usuario.getTipoUsuario().equalsIgnoreCase("premium")) {
            alquilarVehiculo(usuario);
        }else{
            System.out.println("Tienes que ser premium para esta función");
        }
    }

    public static void mostrarVehiculosAsignados(Mecanico mecanico){
        
    }

    public static void reportarReparacion(Mecanico mecanico){
//TODO: Hacer
    }
}
