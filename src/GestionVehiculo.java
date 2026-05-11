import java.util.*;
public class GestionVehiculo {
    private Map<String, Vehiculo> vehiculos = new HashMap<>();

    public void crearVehiculo(Vehiculo v){
        vehiculos.put(v.getId(), v);
    }

    public List<Vehiculo> listarVehiuculos(){
        return new ArrayList<>(vehiculos.values());
    }

}
