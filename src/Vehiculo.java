/**
 * Clase abstracta que representa un vehículo genérico.
 * Define la estructura básica que deben tener todos los vehículos.
 */
public abstract class Vehiculo {

    /**
     * Identificador único del vehículo.
     */
    private String id;


    private String tipo;
    private String autonomia;


    /**
     * Constructor de la clase Vehiculo.
     *
     * @param id Identificador único del vehículo
     */
    public Vehiculo(String id){
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setAutonomia(String autonomia) {
        this.autonomia = autonomia;
    }

    /**
     * Obtiene el identificador del vehículo.
     *
     * @return el id del vehículo
     */
    public String getId(){
        return id;
    }
    
    public String getAutonomia() {
        return autonomia;
    }


    public String getTipo() {
        return tipo;
    }

    /**
     * Define el patrón de movimiento del vehículo.
     * Este método debe ser implementado por las clases hijas
     * según el tipo de vehículo.
     */
    public abstract void patronMovimiento();
}
