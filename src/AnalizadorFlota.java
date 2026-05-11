import java.util.*;
import java.util.stream.*;

/**
 * Clase encargada del procesamiento avanzado de la flota logistica
 * mediante Streams, ordenamiento, integracion y generacion de reportes.
 * Ejercicio 3: Procesamiento con Streams
 * Ejercicio 4: Ordenamiento
 * Ejercicio 5: Integración
 * Ejercicio 6: Mejora Propuesta
 *
 * @author Mia Tanikawa
 * */
public class AnalizadorFlota {

    //Lista que recibe los vehiculos desde GestionVehiculo
    private List<Vehiculo> flota;

    /**
     * Constructor que recibe la lista de vehículos gestionados.
     * @param flota Lista proveniente de GestionVehiculo.listarVehiculos()
     */
    public AnalizadorFlota(List<Vehiculo> flota) {
        this.flota = flota;
    }

    //EJERCICIO 3 Procesamiento con Streams
    /**
     * Filtra y devuelve únicamente los vehículos que implementan IConectable.
     */
    public List<Vehiculo> filtrarConectados() {
        return flota.stream()
                .filter(v -> v instanceof IConectable)
                .collect(Collectors.toList());
    }

    /**
     * Devuelve una lista con los IDs de todos los vehículos.
     */
    public List<String> obtenerIDs() {
        return flota.stream()
                .map(Vehiculo::getId)
                .collect(Collectors.toList());
    }

    /**
     * Cuenta la cantidad total de vehículos en la flota.
     * Decidi convertir a int, porque no se usaran tantos autos
     */
    public int contarVehiculos() {
        return (int)flota.stream().count();
    }
    /**
     * Busca y devuelve todos los vehículos que coincidan con el tipo dado.
     * @param tipo Tipo de vehículo a buscar (camion o dron)
     */
    public List<Vehiculo> buscarPorTipo(String tipo) {
        return flota.stream()
                .filter(v -> tipo.equalsIgnoreCase(v.getTipo()))
                .collect(Collectors.toList());
    }

    //EJERCICIO 4 Ordenamiento
    /**
     * Devuelve la flota ordenada alfabéticamente por ID.
     */
    public List<Vehiculo> ordenarPorID() {
        return flota.stream()
                .sorted(Comparator.comparing(Vehiculo::getId))
                .collect(Collectors.toList());
    }


    /**
     * Devuelve la flota ordenada alfabéticamente por tipo de vehículo.
     */
    public List<Vehiculo> ordenarPorTipo() {
        return flota.stream()
                .sorted(Comparator.comparing(v -> (v.getTipo() == null ? "" : v.getTipo())))

    }

    //Ejercicio 6 Mejora Propuesta
    /**
     * Genera un reporte detallado de todos los vehículos de la flota,
     * clasificándolos por tipo.
     */
    public void generarReporte() {
        System.out.println("REPORTE DE FLOTA LOGÍSTICA");

        Map<String, List<Vehiculo>> porTipo = flota.stream()
                .collect(Collectors.groupingBy(v -> (v.getTipo() == null ? "Sin tipo" : v.getTipo())));

        porTipo.forEach((tipo, lista) -> {
            System.out.println("\n▸ Tipo: " + tipo + " (" + lista.size() + " unidades)");
            lista.forEach(v ->
                    System.out.println("   - ID: " + v.getId() + " | Autonomía: " + v.getAutonomia())
            );
        });
        System.out.println();
    }
    /**
     * Muestra estadísticas generales de la flota: total, conectables
     * y cantidad por tipo.
     */
    public void mostrarEstadisticas() {
        System.out.println("ESTADÍSTICAS DE FLOTA");

        long total = contarVehiculos();
        long conectables = filtrarConectados().size();

        System.out.println("Total de vehículos   : " + total);
        System.out.println("Vehículos conectables: " + conectables);
        System.out.println("No conectables       : " + (total - conectables));

        System.out.println("\nDistribución por tipo:");
        flota.stream()
                .collect(Collectors.groupingBy(v -> (v.getTipo() == null ? "Sin tipo" : v.getTipo()), Collectors.counting()))
                .forEach((tipo, cantidad) ->
                        System.out.println("   " + tipo + ": " + cantidad + " unidad(es)")
                );
        System.out.println();
    }
    /**
     * Búsqueda avanzada: filtra vehículos conectables cuyo ID contenga
     * el prefijo indicado, y los devuelve ordenados por ID.
     * @param prefijo Prefijo a buscar en el ID (ej: "D" para drones).
     */
    public List<Vehiculo> busquedaAvanzada(String prefijo) {
        return flota.stream()
                .filter(v -> v instanceof IConectable)
                .filter(v -> v.getId().startsWith(prefijo))
                .sorted(Comparator.comparing(Vehiculo::getId))
                .collect(Collectors.toList());
    }
}
