public class Main {
    public static void main(String[] args) {

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

        System.out.println("========== CRUD ==========");
        gestor.crearVehiculo(d1);
        gestor.crearVehiculo(d2);
        gestor.crearVehiculo(c1);
        gestor.crearVehiculo(c2);

        gestor.buscarVehiculo("D-001");
        gestor.modificarVehiculo("C-001", "Camion Pesado", "550 km");
        gestor.eliminarVehiculo("D-002");

        gestor.imprimir();

        AnalizadorFlota analizador = new AnalizadorFlota(gestor.listarVehiculos());

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
