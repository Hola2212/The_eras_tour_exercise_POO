public class Localidad {
    private int disponibles;
    private int precio;

    public Localidad(int disponibles, int precio){
        this.disponibles = disponibles;
        this.precio = precio;
    }
    public void setDisponibles(int disponibles){
        this.disponibles = disponibles;
    }
    public int getDisponibles(){
        return disponibles;
    }
    public int getPrecio(){
        return precio;
    }
}
