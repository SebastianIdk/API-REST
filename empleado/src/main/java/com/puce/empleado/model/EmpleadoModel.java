package com.puce.empleado.model;

public class EmpleadoModel {
    // Atributos
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private double sueldo;
    private String email;
    private int aniosExperiencia;
    private String telefono;

    public EmpleadoModel() {}

    // Constructor con todos los campos
    public EmpleadoModel(int id, String nombre, String apellido, int edad,
                         double sueldo, String email, int aniosExperiencia,
                         String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sueldo = sueldo;
        this.email = email;
        this.aniosExperiencia = aniosExperiencia;
        this.telefono = telefono;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public double getSueldo() { return sueldo; }
    public void setSueldo(double sueldo) { this.sueldo = sueldo; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public int getAniosExperiencia() { return aniosExperiencia; }
    public void setAniosExperiencia(int aniosExperiencia) { this.aniosExperiencia = aniosExperiencia; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}