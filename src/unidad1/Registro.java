package unidad1;

public class Registro {
    public String Usuario;
    public String Email;
    public String Contrasena;
    public String Edad;

    public Registro(String usuario, String email, String contrasena, String edad) {
        Usuario = usuario;
        Email = email;
        Contrasena = contrasena;
        Edad = edad;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }
}
