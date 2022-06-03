package repaso;

/* Diseñar el TDA considerando campo clave legajo y como información asociada los datos nombre,
apellido, tipo y número de DNI, domicilio (calle, número y ciudad), teléfono, usuario y clave en el
sistema SIU. Especifique las operaciones primitivas de acuerdo a las recomendaciones anteriores.*/


import java.util.Objects;

public class Alumno {
    private String legajo;
    private String nombre = "";
    private String domicilio = "";
    private String usuario = ""; //Siu
    private String clave = ""; //Siu
    private String dni = "";
    private String telefono = "";

    //Se declara el constructor con la clave del TDA
    public Alumno(String legajo) {
        this.legajo = legajo;
    }


    //Se declara un constructor con todos los atributos
    public Alumno(String legajo, String nombre, String domicilio, String usuario, String clave, String dni, String telefono) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.usuario = usuario;
        this.clave = clave;
        this.dni = dni;
        this.telefono = telefono;
    }


    //METODOS DE MODIFICACION

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    private void setClave(String clave) {
        this.clave = clave;
    }

    //METODOS DE RECUPERACION


    public String getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    //METODOS PROPIOS


    public boolean equals(Alumno unAlumno) {
        return (this.legajo.equals(unAlumno.legajo));
    }


}
