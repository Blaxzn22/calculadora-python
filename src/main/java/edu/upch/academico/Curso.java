package edu.upch.academico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Curso con una lista de códigos de alumnos matriculados. */
public class Curso {
    private final String codigo;
    private final String nombre;
    private final List<String> codigosAlumnos = new ArrayList<>();

    public Curso(String codigo, String nombre) {
        if (codigo == null || codigo.isBlank() || nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El código y el nombre del curso son obligatorios.");
        }
        this.codigo = codigo.trim().toUpperCase();
        this.nombre = nombre.trim();
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public List<String> getCodigosAlumnos() { return Collections.unmodifiableList(codigosAlumnos); }

    void agregarAlumno(String codigoAlumno) {
        if (!codigosAlumnos.contains(codigoAlumno)) codigosAlumnos.add(codigoAlumno);
    }

    @Override
    public String toString() { return codigo + " - " + nombre; }
}
