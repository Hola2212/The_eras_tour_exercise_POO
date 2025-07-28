public class Usuario {
    private String nombre;
    private String correo;
    private int presupuesto;
    private int cantidad;
    public Usuario(String nombre, String correo, int cantidad, int presupuesto){
        this.nombre = nombre;
        this.correo = correo;
        this.cantidad = cantidad;
        this.presupuesto = presupuesto;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    public void setPresupuesto(int presupuesto){
        this.presupuesto = presupuesto;
    }
    public String getCorreo(){
        return correo;
    }
    public String getNombre(){
        return nombre;
    }
    public int getCantidad(){
        return cantidad;
    }
    public int getPresupuesto(){
        return presupuesto;
    }
}
