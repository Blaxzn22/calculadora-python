package edu.upch.academico;

/** Punto de entrada con un flujo de demostración. */
public class Main {
    public static void main(String[] args) {
        SistemaAcademico sistema = new SistemaAcademico();
        try {
            sistema.registrarAlumno("A001", "Lucía Ramos");
            sistema.registrarAlumno(new Alumno("A002", "Diego Salazar"));

            Curso poo = new Curso("SIS201", "Programación Orientada a Objetos");
            sistema.registrarCurso(poo);
            sistema.registrarCurso(new Curso("SIS202", "Estructuras de Datos"));

            sistema.matricular("A001", "SIS201");
            sistema.matricular(sistema.listarAlumnos().stream()
                    .filter(a -> a.getCodigo().equals("A002")).findFirst().orElseThrow(), poo);

            System.out.println("=== Alumnos registrados ===");
            sistema.listarAlumnos().forEach(System.out::println);
            System.out.println("\n=== Matrículas por curso ===");
            for (Curso curso : sistema.listarCursos()) {
                System.out.println(curso + " | alumnos: " + curso.getCodigosAlumnos());
            }

            // Ejemplo de error controlado: el alumno no existe.
            sistema.matricular("A999", "SIS201");
        } catch (SistemaAcademicoException | IllegalArgumentException e) {
            System.err.println("No se pudo completar la operación: " + e.getMessage());
        }
    }
}
