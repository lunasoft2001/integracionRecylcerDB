package at.ums.integracionrecylcerdb.modelos;

/**
 * Created by luna-aleixos on 21.04.2016.
 */
public class Clientes {

    private int idCliente;
    private String nombre;
    private String direccion;
    private String telefono;

    public Clientes(int idCliente, String nombre, String direccion, String telefono){
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Clientes(){

    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
