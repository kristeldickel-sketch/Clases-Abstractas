/**
 * Interfaz que define las capacidades de conectividad
 * de un dispositivo o vehículo.
 */
public interface IConectable {

    /**
     * Sincroniza el sistema con el GPS para obtener
     * la ubicación actual.
     */
    public void sincronizarGPS();

    /**
     * Establece una conexión satelital-
     */
    public void conexionSatelital();
}