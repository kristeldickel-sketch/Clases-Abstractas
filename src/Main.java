
public class Main {
    public static void main(String[] args) {
        // Creamos las unidades
        DronTransporte dron1   = new DronTransporte("D-001", 120, 5, 80);
        DronTransporte dron2   = new DronTransporte("D-002", 80,  2, 45);
        CamionAutonomo camion1 = new CamionAutonomo("C-001", 90,  "Ruta 1 - Norte", "Asuncion");
        CamionAutonomo camion2 = new CamionAutonomo("C-002", 110, "Ruta 7 - Sur",   "CDE");

        System.out.println("=== Conexión satelital ===");
        dron1.conexionSatelital();
        dron1.sincronizarGPS();
        dron2.conexionSatelital();
        dron2.sincronizarGPS();
        camion1.conexionSatelital();
        camion1.sincronizarGPS();
        camion2.conexionSatelital();
        camion2.sincronizarGPS();

        System.out.println("\n=== Carga eléctrica (solo drones) ===");
        System.out.println("Dron D-001 batería antes: " + dron1.getNivelBateria() + "%");
        dron1.cargarBateria();
        System.out.println("Dron D-001 batería después: " + dron1.getNivelBateria() + "%");

        System.out.println("\n=== Registro de flota ===");
        CentroControl centro = new CentroControl();
        centro.registrarUnidad(dron1);
        centro.registrarUnidad(dron2);
        centro.registrarUnidad(camion1);
        centro.registrarUnidad(camion2);

        centro.monitorearFlota();

        //Proyecto Parte 2
        // --- Crear vehículos ---
        GestionVehiculo gestor = new GestionVehiculo();

        DronTransporte d1 = new DronTransporte("D-001", 150, 10, 80);
        d1.setTipo("Dron");
        d1.setAutonomia("40 km");

        DronTransporte d2 = new DronTransporte("D-002", 200, 15, 60);
        d2.setTipo("Dron");
        d2.setAutonomia("35 km");

        CamionAutonomo c1 = new CamionAutonomo("C-001", 90, "Ruta 1", "Encarnación");
        c1.setTipo("Camion");
        c1.setAutonomia("500 km");

        CamionAutonomo c2 = new CamionAutonomo("C-002", 110, "Ruta 6", "Asunción");
        c2.setTipo("Camion");
        c2.setAutonomia("600 km");

        // --- Ejecutar CRUD ---
        System.out.println("========== CRUD ==========");
        gestor.crearVehiculo(d1);
        gestor.crearVehiculo(d2);
        gestor.crearVehiculo(c1);
        gestor.crearVehiculo(c2);

        gestor.buscarVehiculo("D-001");
        gestor.modificarVehiculo("C-001", "Camion Pesado", "550 km");
        gestor.eliminarVehiculo("D-002");

        // --- Aplicar Lambda ---
        System.out.println("========== LAMBDA ==========");
        gestor.mostrarConLambda();

        // --- Aplicar Streams ---
        AnalizadorFlota analizador = new AnalizadorFlota(gestor.listarVehiculos());

        System.out.println("========== STREAMS ==========");
        System.out.println("Total vehículos: " + analizador.contarVehiculos());

        System.out.println("IDs registrados: " + analizador.obtenerIDs());

        System.out.println("Vehículos conectables:");
        analizador.filtrarConectables().forEach(v ->
                System.out.println("  → " + v.getId() + " (" + v.getTipo() + ")")
        );

        System.out.println("Búsqueda por tipo 'Camion Pesado':");
        analizador.buscarPorTipo("Camion Pesado").forEach(v ->
                System.out.println("  → " + v.getId())
        );

        // --- Ordenamiento ---
        System.out.println("========== ORDENAMIENTO ==========");
        System.out.println("Ordenado por ID:");
        analizador.ordenarPorID().forEach(v ->
                System.out.println("  " + v.getId())
        );

        System.out.println("Ordenado por tipo:");
        analizador.ordenarPorTipo().forEach(v ->
                System.out.println("  " + v.getTipo() + " – " + v.getId())
        );

        // --- Reportes y estadísticas ---
        System.out.println("========== REPORTE FINAL ==========");
        analizador.generarReporte();
        analizador.mostrarEstadisticas();
    }
}