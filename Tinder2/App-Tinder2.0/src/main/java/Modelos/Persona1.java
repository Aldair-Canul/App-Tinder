package Modelos;

import java.time.LocalDate;

public class Persona1 {
    private String nombre;
    private String apellidos;
    private String correo;
    private int edad;
    private String codigoPostal;
    private String genero;
    private LocalDate fechaNacimiento;
    private String contrasena;

    // Constructor
    public Persona1(String nombre, String apellidos, String correo,
                    int edad, String codigoPostal, String genero,
                    LocalDate fechaNacimiento, String contrasena) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.edad = edad;
        this.codigoPostal = codigoPostal;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasena = contrasena;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getApellidos() { return apellidos; }
    public String getCorreo() { return correo; }
    public int getEdad() { return edad; }
    public String getCodigoPostal() { return codigoPostal; }
    public String getGenero() { return genero; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public String getContrasena() { return contrasena; }
}