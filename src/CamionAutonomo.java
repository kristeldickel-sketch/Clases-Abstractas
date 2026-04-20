/**
 * Representa un camión que se desplaza de forma autónoma por rutas terrestres.
 * Implementa la interfaz IConectable para su gestión remota.
 */
public class CamionAutonomo extends Vehiculo implements IConectable{
    private int velocidad;
    private String ruta;
    private String destino;
    /**
     * Constructor para inicializar el camión con su identificación y ruta logística.
     */
    public CamionAutonomo(String id, int velocidad, String ruta, String destino) {
        super(id);
        this.velocidad = velocidad;
        this.ruta = ruta;
        this.destino = destino;
    }
    /**
     * Describe el desplazamiento terrestre del camión indicando ruta y destino.
     */
    @Override
    public void patronMovimiento(){
        System.out.println("El camion se encuentra en la ruta " + ruta + " va a " + velocidad + " km, dirigiendose a " + destino);
    }

    @Override
    public void conexionSatelital(){
        System.out.println("Camion N° " + getId() + " Conectado al satelite");
    }

    @Override
    public void sincronizarGPS(){
        System.out.println("Camion N° " + getId() + " sincronizado al gps");
    }

}