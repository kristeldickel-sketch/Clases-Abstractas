/**
 * Representa un dron de transporte especializado.
 * Hereda de Vehiculo y utiliza interfaces para conectividad y carga eléctrica.
 */
public class DronTransporte extends Vehiculo implements IConectable, ICargaElectrica{
    private int alturaVuelo;
    private int cargaKg;
    private int nivelBateria;
    /**
     * Constructor para inicializar el dron con sus atributos específicos.
     */
    public DronTransporte(String id, int alturaVuelo, int cargaKg, int nivelBateria){
        super(id); // Llama al constructor de la clase padre (Vehiculo)
        this.alturaVuelo = alturaVuelo;
        this.cargaKg = cargaKg;
        this.nivelBateria = nivelBateria;
    }
    public int getNivelBateria(){
        return nivelBateria;
    }

    /**
     * Define cómo se mueve el dron (volando) y muestra su estado actual.
     */
    @Override
    public void patronMovimiento(){
        System.out.println("Dron N° " + getId() + " volando a " + alturaVuelo + " m, con: " + cargaKg
        + "kg. Nivel de Bateria: " + nivelBateria);
    }

    @Override
    public void sincronizarGPS(){
        System.out.println("Dron N° " + getId() + "Sincronizado.");
    }

    @Override
    public void conexionSatelital() {
        System.out.println("Dron N° " + getId() + "conectado.");
    }

    /**
     * Implementación de la carga eléctrica que restablece la batería al máximo.
     */
    @Override
    public void cargarBateria(){
        nivelBateria = 100;
        System.out.println("Bateria cargada 100%");
    }
}
