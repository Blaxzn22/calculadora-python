# Sistema de Gestión Académica (Java)

Proyecto universitario para la práctica de Técnicas de Programación Orientada a Objetos. Permite registrar estudiantes, cursos y matrículas mediante una aplicación de consola.

## Requisitos

- JDK 17 o superior.
- Git para consultar el historial del repositorio.

## Ejecución

Desde la raíz del repositorio:

```bash
mkdir -p out
javac -d out src/main/java/edu/upch/academico/*.java
java -cp out edu.upch.academico.Main
```

En PowerShell, si `mkdir -p` no está disponible, use `New-Item -ItemType Directory out -Force` y luego ejecute los comandos `javac` y `java`.

## Conceptos demostrados

1. **Sobrecarga:** `registrarAlumno` acepta un objeto `Alumno` o los datos de un alumno; `matricular` acepta códigos o instancias.
2. **Manejo de errores:** `SistemaAcademicoException` representa errores de negocio y `Main` presenta un mensaje legible.
3. **Colecciones:** `Map` organiza alumnos y cursos por código; `List` guarda las matrículas de cada curso.
4. **Git:** esta práctica está publicada en el repositorio compartido y su historial es visible en la rama `main`.

## Código fuente

`src/main/java/edu/upch/academico/`

## Autoría

Rolando Adriano Blas Teran — 100% de participación.
