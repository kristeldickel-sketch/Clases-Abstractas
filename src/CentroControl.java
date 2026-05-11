import java.util.ArrayList;
/**
 * Gestiona una colección de vehículos (flota) utilizando polimorfismo.
 * Permite registrar unidades y monitorear sus estados independientemente del tipo de vehículo.
 */
public class CentroControl {
    // Lista polimórfica que puede almacenar cualquier objeto que sea un Vehiculo
    private ArrayList<Vehiculo> flota;

    public CentroControl(){
        this.flota = new ArrayList<>();
    }
    /**
     * Agrega un vehículo a la flota de control.
     * @param v Objeto de tipo Vehiculo (puede ser Dron o Camion).
     */
    public void registrarUnidad(Vehiculo v){
        flota.add(v);
        System.out.println("Unidad: " + v.getId() + "registrada exitosamente");
    }

    /**
     * Recorre la flota y ejecuta el patrón de movimiento de cada unidad.
     * Aquí se aplica el concepto de polimorfismo.
     */
    public void monitorearFlota(){
        System.out.println("Vehiculos en la flota: ");
        for(Vehiculo v : flota){
            v.patronMovimiento();
        }
    }
}
