package Ejercicio1;

public class Estudiante {
    private String nombre;
    private int edad;
    private String carrera;
    private String materia;

    public Estudiante(String nombre, int edad, String carrera, String materia) {
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
        this.materia = materia;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public String getMateria() { return materia; }
    public void setMateria(String materia) { this.materia = materia; }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nEdad: " + edad +
                "\nCarrera: " + carrera +
                "\nMateria: " + materia;
    }
}
