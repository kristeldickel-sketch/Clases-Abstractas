import java.util.*;
public class GestionVehiculo {
    private Map<String, Vehiculo> vehiculos = new HashMap<>();

    public void crearVehiculo(Vehiculo v){
        vehiculos.put(v.getId(), v);
    }

    public List<Vehiculo> listarVehiuculos(){
        return new ArrayList<>(vehiculos.values());
    }

    public Vehiculo buscarVehiculo(String id){
        return vehiculos.get(id);
    }

    public void modificarVehiculo(String id, String nuevoTipo, String nuevaAutonomia){
        Vehiculo v = vehiculos.get(id);
        if (v != null) {
            v.setTipo(nuevoTipo);
            v.setAutonomia(nuevaAutonomia);
        }
    }

    public void eliminarVehiculo(String id){
        vehiculos.remove(id);
    }
}
