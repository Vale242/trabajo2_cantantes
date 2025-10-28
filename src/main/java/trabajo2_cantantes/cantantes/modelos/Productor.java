package trabajo2_cantantes.cantantes.modelos;

import java.util.ArrayDeque;
import java.util.Deque;

public class Productor {
    private String nombre;
    private String discografica;
    private int añosExperiencia;
    private Deque<Cantante> cantantes;

    public Productor(String nombre, String discografica, int añosExperiencia) {
        this.nombre = nombre;
        this.discografica = discografica;
        this.añosExperiencia = añosExperiencia;
        this.cantantes = new ArrayDeque<>();
    }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDiscografica(String discografica) { this.discografica = discografica; }
    public void setAñosExperiencia(int añosExperiencia) { this.añosExperiencia = añosExperiencia; }
    public void setCantantes(Deque<Cantante> cantantes) { this.cantantes = cantantes; }

    public void agregarCantante(Cantante cantante) {
        this.cantantes.add(cantante);
    }

    public String getNombre() { return nombre; }
    public String getDiscografica() { return discografica; }
    public int getAñosExperiencia() { return añosExperiencia; }
    public Deque<Cantante> getCantantes() { return cantantes; }
}