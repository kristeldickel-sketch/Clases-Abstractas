public abstract class Vehiculo {
    private String id;
   
    public Vehiculo(String id){
        this.id=id;
    }


    public String getId(){
        return id;
    }


    public abstract void patronMovimiento();
}
