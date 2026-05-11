import java.util.*;
public class GestionVehiculo {
    private Map<String, Vehiculo> vehiculos = new HashMap<>();

    public void crearVehiculo(Vehiculo v){
        vehiculos.put(v.getId(), v);
        System.out.println(" Vehículo " + v.getId() + " registrado correctamente.");
    }

    public List<Vehiculo> listarVehiuculos(){
        return new ArrayList<>(vehiculos.values());
    }

    public Vehiculo buscarVehiculo(String id){
        Vehiculo v = vehiculos.get(id);
        if (v != null) {
            System.out.println("Vehículo encontrado: " + v.getId());
        } else {
            System.out.println("No se encontró ningún vehículo con ID: " + id);
        }
        return v;
    }

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

    public void eliminarVehiculo(String id){
        if (vehiculos.containsKey(id)) {
            vehiculos.remove(id);
            System.out.println("Vehículo " + id + " eliminado del sistema.");
        } else {
            System.out.println("No se encontró el vehículo con ID: " + id + " para eliminar.");
        }
    }

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
