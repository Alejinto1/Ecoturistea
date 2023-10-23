package unidad1;

public class Usuario {
    private String nombre;
    private String email;
    private Integer edad;
    private String pais;

    public Usuario() {
    }

    public Usuario(String nombre, String email, Integer edad, String pais) {
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String Email) {
        this.email = Email
        ;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
