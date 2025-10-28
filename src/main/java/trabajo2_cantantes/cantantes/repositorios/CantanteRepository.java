package trabajo2_cantantes.cantantes.repositorios;

import org.springframework.stereotype.Repository;
import trabajo2_cantantes.cantantes.modelos.Genero;
import trabajo2_cantantes.cantantes.modelos.Cantante;
import trabajo2_cantantes.cantantes.modelos.Productor;
import trabajo2_cantantes.cantantes.modelos.Proyeccion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

@Repository
public class CantanteRepository {

    private final Stack<Cantante> cantantesStack = new Stack<>();
    private Productor productor; // QUITAR "final" de aquí
    private final List<Cantante> cantantesExtra = new ArrayList<>();
    private final Map<Integer, String> nombresAlbumes = new HashMap<>();

    public CantanteRepository() {
        inicializarNombresAlbumes();
        inicializarCantantes();
    }

    private void inicializarNombresAlbumes() {
        // CONAN GRAY
        nombresAlbumes.put(1, "Sunset Season");
        nombresAlbumes.put(2, "Kid Krow");
        nombresAlbumes.put(3, "Superache");
        nombresAlbumes.put(4, "Found Heaven");
        nombresAlbumes.put(5, "Ultimate Edition");

        // LAUFEY
        nombresAlbumes.put(6, "Everything I Know About Love");
        nombresAlbumes.put(7, "Typical of Me");
        nombresAlbumes.put(8, "Bewitched");
        nombresAlbumes.put(9, "A Night At The Symphony");
        nombresAlbumes.put(10, "New Album 2024");

        // RICKY MONTGOMERY
        nombresAlbumes.put(11, "Montgomery Ricky");
        nombresAlbumes.put(12, "It's 2016 Somewhere");
        nombresAlbumes.put(13, "Edits");
        nombresAlbumes.put(14, "Rick");
        nombresAlbumes.put(15, "It's 2023 Somewhere");

        // BILLIE EILISH
        nombresAlbumes.put(16, "Don't Smile at Me");
        nombresAlbumes.put(17, "When We All Fall Asleep");
        nombresAlbumes.put(18, "Happier Than Ever");
        nombresAlbumes.put(19, "Hit Me Hard and Soft");
        nombresAlbumes.put(20, "Live at Third Man Records");

        // OLIVIA RODRIGO
        nombresAlbumes.put(21, "SOUR");
        nombresAlbumes.put(22, "GUTS");
        nombresAlbumes.put(23, "SOUR Prom");
        nombresAlbumes.put(24, "GUTS World Tour");
        nombresAlbumes.put(25, "The GUTS Deluxe");

        // CANTANTES EXTRA
        nombresAlbumes.put(26, "The Rise and Fall of Ziggy Stardust");
        nombresAlbumes.put(27, "Aladdin Sane");
        nombresAlbumes.put(28, "Station to Station");
        nombresAlbumes.put(29, "Low");
        nombresAlbumes.put(30, "Let's Dance");
        nombresAlbumes.put(31, "Little Girl Blue");
        nombresAlbumes.put(32, "Wild Is the Wind");
        nombresAlbumes.put(33, "To Love Somebody");
        nombresAlbumes.put(34, "Angels Fall First");
        nombresAlbumes.put(35, "Oceanborn");
        nombresAlbumes.put(36, "Once");
        nombresAlbumes.put(37, "System of a Down");
        nombresAlbumes.put(38, "Toxicity");
        nombresAlbumes.put(39, "Mezmerize");
    }

    private void inicializarCantantes() {
        // ==================== PUNTO 1 ====================
        Cantante cantante1 = new Cantante("CONAN_GRAY", Genero.POP, Proyeccion.EMERGENTE);
        Cantante cantante2 = new Cantante("LAUFEY", Genero.POP, Proyeccion.EMERGENTE);
        Cantante cantante3 = new Cantante("RICKY_MONTGOMERY", Genero.POP, Proyeccion.EMERGENTE);
        Cantante cantante4 = new Cantante("BILLIE_EILISH", Genero.POP, Proyeccion.EMERGENTE);
        Cantante cantante5 = new Cantante("OLIVIA_RODRIGO", Genero.POP, Proyeccion.EMERGENTE);

        // CONAN GRAY - IDs 1-5
        cantante1.agregarAlbum(1); cantante1.agregarAlbum(2);
        cantante1.agregarAlbum(3); cantante1.agregarAlbum(4); cantante1.agregarAlbum(5);

        // LAUFEY - IDs 6-10
        cantante2.agregarAlbum(6); cantante2.agregarAlbum(7);
        cantante2.agregarAlbum(8); cantante2.agregarAlbum(9); cantante2.agregarAlbum(10);

        // RICKY MONTGOMERY - IDs 11-15
        cantante3.agregarAlbum(11); cantante3.agregarAlbum(12);
        cantante3.agregarAlbum(13); cantante3.agregarAlbum(14); cantante3.agregarAlbum(15);

        // BILLIE EILISH - IDs 16-20
        cantante4.agregarAlbum(16); cantante4.agregarAlbum(17);
        cantante4.agregarAlbum(18); cantante4.agregarAlbum(19); cantante4.agregarAlbum(20);

        // OLIVIA RODRIGO - IDs 21-25
        cantante5.agregarAlbum(21); cantante5.agregarAlbum(22);
        cantante5.agregarAlbum(23); cantante5.agregarAlbum(24); cantante5.agregarAlbum(25);

        cantantesStack.push(cantante1);
        cantantesStack.push(cantante2);
        cantantesStack.push(cantante3);
        cantantesStack.push(cantante4);
        cantantesStack.push(cantante5);

        // CREAR PRODUCTOR - ahora funciona porque productor no es final
        productor = new Productor("MARK_RONSON", "Sony Music", 15);
        productor.setCantantes(new ArrayDeque<>(cantantesStack));

        // ==================== CANTANTES EXTRA ====================
        Cantante extra1 = new Cantante("DAVID_BOWIE", Genero.ROCK, Proyeccion.CLASICO);
        Cantante extra2 = new Cantante("NINA_SIMONE", Genero.JAZZ, Proyeccion.CLASICO);
        Cantante extra3 = new Cantante("NIGHTWISH", Genero.METAL, Proyeccion.INTERNACIONAL);
        Cantante extra4 = new Cantante("SYSTEM_OF_A_DOWN", Genero.METAL, Proyeccion.INTERNACIONAL);

        // DAVID BOWIE - IDs 26-30
        extra1.agregarAlbum(26); extra1.agregarAlbum(27); extra1.agregarAlbum(28);
        extra1.agregarAlbum(29); extra1.agregarAlbum(30);

        // NINA SIMONE - IDs 31-33
        extra2.agregarAlbum(31); extra2.agregarAlbum(32); extra2.agregarAlbum(33);

        // NIGHTWISH - IDs 34-36
        extra3.agregarAlbum(34); extra3.agregarAlbum(35); extra3.agregarAlbum(36);

        // SYSTEM OF A DOWN - IDs 37-39
        extra4.agregarAlbum(37); extra4.agregarAlbum(38); extra4.agregarAlbum(39);

        cantantesExtra.add(extra1);
        cantantesExtra.add(extra2);
        cantantesExtra.add(extra3);
        cantantesExtra.add(extra4);

        System.out.println("=== REPOSITORIO INICIALIZADO ===");
        System.out.println("Cantantes principales: " + cantantesStack.size());
        System.out.println("Cantantes extra: " + cantantesExtra.size());
        System.out.println("Productor: " + productor.getNombre());
    }

    // Método para obtener el nombre real del álbum
    public String getNombreAlbum(int idAlbum) {
        return nombresAlbumes.getOrDefault(idAlbum, "Álbum desconocido");
    }

    // ==================== MÉTODOS PRINCIPALES ====================
    public Stack<Cantante> getCantantesStack() {
        return cantantesStack;
    }

    public Productor getProductor() {
        return productor;
    }

    public List<Cantante> getCantantesExtra() {
        return cantantesExtra;
    }

    public List<Cantante> getAllCantantesForFilters() {
        List<Cantante> todos = new ArrayList<>(cantantesStack);
        todos.addAll(cantantesExtra);
        return todos;
    }

    public Deque<Cantante> getDequeFromStack() {
        return new ArrayDeque<>(cantantesStack);
    }

    public List<Cantante> findByProyeccion(Proyeccion proyeccion) {
        return getAllCantantesForFilters().stream()
                .filter(c -> c.getProyeccion() == proyeccion)
                .collect(Collectors.toList());
    }

    public List<Cantante> findByGenero(Genero genero) {
        return getAllCantantesForFilters().stream()
                .filter(c -> c.getGenero() == genero)
                .collect(Collectors.toList());
    }
}