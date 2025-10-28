package trabajo2_cantantes.cantantes.modelos;

import java.util.Stack;
import java.util.function.Function;

public class Cantante {
    private String nombre;
    private Genero genero;
    private Proyeccion proyeccion;
    private Stack<Integer> albumes;

    public Cantante() {
        this.albumes = new Stack<>();
    }

    public Cantante(String nombre, Genero genero, Proyeccion proyeccion) {
        this.nombre = nombre;
        this.genero = genero;
        this.proyeccion = proyeccion;
        this.albumes = new Stack<>();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setProyeccion(Proyeccion proyeccion) {
        this.proyeccion = proyeccion;
    }

    public void agregarAlbum(int año) {
        this.albumes.push(año);
    }

    public String getNombre() {
        return nombre;
    }

    public Genero getGenero() {
        return genero;
    }

    public Proyeccion getProyeccion() {
        return proyeccion;
    }

    public Stack<Integer> getAlbumes() {
        return albumes;
    }
    public int verTotalAlbumes(Function<Cantante, Integer> funcion) {
        Integer total = funcion.apply(this);
        System.out.println("Cantidad de álbumes del cantante " + nombre + " = " + total);
        return total != null ? total : 0;
    }
}