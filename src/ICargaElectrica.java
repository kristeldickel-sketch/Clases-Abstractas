/**
 * Interfaz que define las operaciones relacionadas
 * con la gestión de carga eléctrica de un dispositivo o vehículo.
 */
public interface ICargaElectrica {

    /**
     * Obtiene el nivel actual de la batería.
     */
    public int getNivelBateria();

    /**
     * Inicia el proceso de carga de la batería.
     */
    public void cargarBateria();
}