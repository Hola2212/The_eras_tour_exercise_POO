import java.io.PrintStream;
import java.util.Scanner;

public class Ventas {
    private Scanner teclado = new Scanner(System.in);
    private PrintStream Consola = System.out;
    private int opcion = 0;
    private int comprobacion = 0;
    private Usuario usuario;
    private Localidad localidad1 = new Localidad(20, 100);
    private Localidad localidad2 = new Localidad(20, 500);
    private Localidad localidad3 = new Localidad(20, 1000);

    public Ventas(){
        while (opcion != 4){
            if (comprobacion == 0){
                Consola.println("Se ha iniciado el programa de comprar de boletos aleatoria. Proseguir con registro de primer usuario.");
                usuario = nuevoUsuario();
                comprobacion = 1;
            }
            Consola.println("Escoja lo que desee hacer (escriba el entero que corresponda su eleccion):\n 1) Nuevo usuario\n 2) Editar datos del usuario (Presupuesto y cantidad de boletos)\n 3) Proceder con la compra\n 4) Salir");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    usuario = nuevoUsuario();
                    Consola.println("\n\nNuevo Usuario creado con éxito. \n");
                    break;
                case 2:
                    Consola.println("Ingrese la nueva cantidad de boletos a comprar.");
                    int nueva_cantidad = teclado.nextInt();
                    Consola.println("Ingrese su nuevo presupuesto maximo.");
                    int nuevo_presupuesto = teclado.nextInt();
                    usuario.setCantidad(nueva_cantidad);
                    usuario.setPresupuesto(nuevo_presupuesto);
                    Consola.println("\n\nDatos modificados con éxito. \n");
                    break;
                case 3:
                    String resultado = comprarBoletos();
                    Consola.println(resultado);
                    break;
                case 4:
                    Consola.println("Saliendo del programa");
                    break;
                default:
                    break;
            }
        }
    }

    public Usuario nuevoUsuario(){
        Consola.println("Ingrese el nombre del usuario");
            String nombre = "";
            do { 
                nombre = teclado.nextLine();
            } while (nombre != "");
            Consola.println("Ingrese el correo del usuario");
            String correo = "";
            do { 
                correo = teclado.nextLine();
            } while (correo != "");
            Consola.println("Ingrese la cantidad de boletos a comprar.");
            int cantidad = teclado.nextInt();
            Consola.println("Ingrese su presupuesto maximo.");
            int presupuesto = teclado.nextInt();
            return new Usuario(nombre,correo,cantidad,presupuesto);
    }

    public String comprarBoletos(){
        int boleto_generado = (int)((Math.random() * 60)+1);
        int rango_inferior = (int)((Math.random() * 60)+1);
        int rango_superior = (int)((Math.random() * 60)+1);
        if (boleto_generado >= rango_inferior && boleto_generado <= rango_superior){
            int localidad = (int)((Math.random() * 3)+1);
            Localidad localidad_actual;
            switch (localidad) {
                case 1:
                    localidad_actual = localidad1;
                    break;
                case 2:
                    localidad_actual = localidad2;
                    break;
                case 3:
                    localidad_actual = localidad3;
                    break;
                default:
                    localidad_actual = localidad1;
                    break;
            }
            int disponibilidad_localidad = localidad_actual.getDisponibles();
            if (disponibilidad_localidad == 0){
                return "La localidad asignada no tiene espacios disponibles, por lo que no se procede con la compra.";
            }
            else{
                int cantidad_boletos = usuario.getCantidad();
                int aComprar = 0;
                if (cantidad_boletos < disponibilidad_localidad){
                    aComprar = disponibilidad_localidad - cantidad_boletos;
                }
                else if(cantidad_boletos == disponibilidad_localidad){
                    aComprar = cantidad_boletos;
                }
                else{
                    aComprar = disponibilidad_localidad;
                }
                int precioLocalidad = localidad_actual.getPrecio();
                int total_compra = aComprar * precioLocalidad;
                int presupuestoUsuario = usuario.getPresupuesto();
                if (presupuestoUsuario < total_compra){
                    return "El total de la compra es mayor al del presupuesto especificado, por lo que no se puede proceder con la compra.";
                }
                else{
                    return ("Se ha logrado la compra de " + (aComprar) + " boletos, por un precio de $" + (total_compra));
                }
            }
        }
        else{
            return "El boleto generado no se encuentra en el rango, por lo que no se pueden comprar los boletos.";
        }
    }
}
