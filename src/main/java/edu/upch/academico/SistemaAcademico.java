package edu.upch.academico;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/** Administra alumnos, cursos y matrículas usando colecciones. */
public class SistemaAcademico {
    private final Map<String, Alumno> alumnos = new LinkedHashMap<>();
    private final Map<String, Curso> cursos = new LinkedHashMap<>();

    // Sobrecarga: registrar a partir de un objeto Alumno.
    public void registrarAlumno(Alumno alumno) throws SistemaAcademicoException {
        if (alumno == null) throw new SistemaAcademicoException("El alumno no puede ser nulo.");
        if (alumnos.containsKey(alumno.getCodigo())) {
            throw new SistemaAcademicoException("Ya existe el alumno " + alumno.getCodigo() + ".");
        }
        alumnos.put(alumno.getCodigo(), alumno);
    }

    // Sobrecarga: registrar a partir de los campos del alumno.
    public void registrarAlumno(String codigo, String nombre) throws SistemaAcademicoException {
        try { registrarAlumno(new Alumno(codigo, nombre)); }
        catch (IllegalArgumentException e) { throw new SistemaAcademicoException(e.getMessage()); }
    }

    public void registrarCurso(Curso curso) throws SistemaAcademicoException {
        if (curso == null) throw new SistemaAcademicoException("El curso no puede ser nulo.");
        if (cursos.containsKey(curso.getCodigo())) {
            throw new SistemaAcademicoException("Ya existe el curso " + curso.getCodigo() + ".");
        }
        cursos.put(curso.getCodigo(), curso);
    }

    // Sobrecarga: matricular usando códigos.
    public void matricular(String codigoAlumno, String codigoCurso) throws SistemaAcademicoException {
        Alumno alumno = alumnos.get(normalizar(codigoAlumno));
        Curso curso = cursos.get(normalizar(codigoCurso));
        if (alumno == null) throw new SistemaAcademicoException("No existe el alumno indicado.");
        if (curso == null) throw new SistemaAcademicoException("No existe el curso indicado.");
        curso.agregarAlumno(alumno.getCodigo());
    }

    // Sobrecarga: matricular usando los objetos ya registrados.
    public void matricular(Alumno alumno, Curso curso) throws SistemaAcademicoException {
        if (alumno == null || curso == null) throw new SistemaAcademicoException("Alumno y curso son obligatorios.");
        matricular(alumno.getCodigo(), curso.getCodigo());
    }

    public Collection<Alumno> listarAlumnos() { return alumnos.values(); }
    public Collection<Curso> listarCursos() { return cursos.values(); }

    private String normalizar(String codigo) {
        return codigo == null ? "" : codigo.trim().toUpperCase();
    }
}
