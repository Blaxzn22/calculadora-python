package edu.upch.academico;

/** Representa a un estudiante de la universidad. */
public class Alumno {
    private final String codigo;
    private final String nombre;

    public Alumno(String codigo, String nombre) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código del alumno es obligatorio.");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del alumno es obligatorio.");
        }
        this.codigo = codigo.trim().toUpperCase();
        this.nombre = nombre.trim();
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }

    @Override
    public String toString() { return codigo + " - " + nombre; }
}
