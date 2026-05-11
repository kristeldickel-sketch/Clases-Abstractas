import java.util.*;
public class GestionVehiculo {
    private Map<String, Vehiculo> vehiculos = new HashMap<>();

    /**
     * Crea un nuevo vehículo y lo agrega al sistema.
      * @param v El vehículo a registrar.
     */
    public void crearVehiculo(Vehiculo v){
        vehiculos.put(v.getId(), v);
        System.out.println(" Vehículo " + v.getId() + " registrado correctamente.");
    }

    /**
     * Retorna una lista de todos los vehículos registrados en el sistema.
     * @return
     */
    public List<Vehiculo> listarVehiculos(){
        return new ArrayList<>(vehiculos.values());
    }

    /**
     * Busca un vehículo por su ID y lo retorna. Si no se encuentra, retorna null.
     * @param id
     * @return
     */
    public Vehiculo buscarVehiculo(String id){
        Vehiculo v = vehiculos.get(id);
        if (v != null) {
            System.out.println("Vehículo encontrado: " + v.getId());
        } else {
            System.out.println("No se encontró ningún vehículo con ID: " + id);
        }
        return v;
    }

    /**
     * Modifica el tipo y autonomía de un vehículo existente.
     * @param id
     * @param nuevoTipo
     * @param nuevaAutonomia
     */
    public void modificarVehiculo(String id, String nuevoTipo, String nuevaAutonomia){
        Vehiculo v = vehiculos.get(id);
        if (v != null) {
            v.setTipo(nuevoTipo);
            v.setAutonomia(nuevaAutonomia);
            System.out.println("Vehículo " + id + " actualizado: tipo=" + nuevoTipo + ", autonomía=" + nuevaAutonomia);
        } else {
            System.out.println("No se encontró el vehículo con ID: " + id + " para modificar.");
        }
    }

    /**
     * Elimina un vehículo del sistema por su ID.
     * @param id
     */
    public void eliminarVehiculo(String id){
        if (vehiculos.containsKey(id)) {
            vehiculos.remove(id);
            System.out.println("Vehículo " + id + " eliminado del sistema.");
        } else {
            System.out.println("No se encontró el vehículo con ID: " + id + " para eliminar.");
        }
    }

    /**
     * Imprime la lista de todos los vehículos registrados en el sistema.
     */
    public void imprimir() {
        System.out.println("\n=== Listado de vehículos ===");
        vehiculos.values().forEach(v ->
            System.out.println("ID: " + v.getId()
                + " | Tipo: " + v.getTipo()
                + " | Autonomía: " + v.getAutonomia())
        );
        System.out.println("=============================================\n");
    }
}
