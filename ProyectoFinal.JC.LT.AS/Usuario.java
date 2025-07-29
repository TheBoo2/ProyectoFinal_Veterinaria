package ProyectoVet;

public class Usuario {
    public String nombre;
    public boolean registrado;

    public Usuario() {
        this.nombre = "";
        this.registrado = false;
    }

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.registrado = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        this.registrado = true;
    }

    public boolean isRegistrado() {
        return registrado;
    }
}
