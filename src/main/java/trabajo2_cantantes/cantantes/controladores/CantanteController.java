package trabajo2_cantantes.cantantes.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import trabajo2_cantantes.cantantes.repositorios.CantanteRepository;
import trabajo2_cantantes.cantantes.modelos.Cantante;
import trabajo2_cantantes.cantantes.modelos.Productor;
import trabajo2_cantantes.cantantes.modelos.Proyeccion;

import java.util.*;
import java.util.function.Function;

@Controller
public class CantanteController {

    private final CantanteRepository repo;

    public CantanteController(CantanteRepository repo) {
        this.repo = repo;
    }

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping({"/punto1"})
    public String punto1(Model model) {
        Stack<Cantante> cantantesStack = repo.getCantantesStack();
        Productor productor = repo.getProductor();

        model.addAttribute("cantantesStack", cantantesStack);
        model.addAttribute("productor", productor);

        return "punto1";
    }

    @GetMapping("/punto2")
    public String punto2(Model model) {
        Stack<Cantante> cantantesStack = repo.getCantantesStack();
        List<String> desdeStack = new ArrayList<>();

        ListIterator<Cantante> listIt = cantantesStack.listIterator();
        while (listIt.hasNext()) {
            Cantante c = listIt.next();
            desdeStack.add(c.getNombre() + " - " + c.getGenero() + " - " + c.getProyeccion());
        }

        Deque<Cantante> deque = repo.getProductor().getCantantes();
        List<String> desdeDeque = new ArrayList<>();

        Iterator<Cantante> it = deque.iterator();
        while (it.hasNext()) {
            Cantante c = it.next();
            desdeDeque.add(c.getNombre() + " - " + c.getGenero() + " - " + c.getProyeccion());
        }

        model.addAttribute("desdeStack", desdeStack);
        model.addAttribute("desdeDeque", desdeDeque);
        return "punto2";
    }

    @GetMapping("/punto3")
    public String punto3(Model model) {
        Stack<Cantante> cantantesStack = repo.getCantantesStack();
        Deque<Cantante> dequeCantantes = new ArrayDeque<>(cantantesStack);

        List<String> cantantesEmergentes = dequeCantantes.stream()
                .filter(c -> c.getProyeccion() == Proyeccion.EMERGENTE)
                .map(Cantante::getNombre)
                .toList();

        model.addAttribute("cantantesEmergentes", cantantesEmergentes);
        return "punto3";
    }

    @GetMapping("/punto4")
    public String punto4(Model model) {
        Function<Cantante, Integer> contarAlbumes = (Cantante c) ->
                c.getAlbumes().size();  // ← Solo contar, no sumar

        // Aplicar la función a todos los cantantes
        Stack<Cantante> cantantesStack = repo.getCantantesStack();
        Map<String, Integer> resultados = new LinkedHashMap<>();

        for (Cantante c : cantantesStack) {
            resultados.put(c.getNombre(), contarAlbumes.apply(c));
        }

        model.addAttribute("resultados", resultados);
        return "punto4";
    }

    @GetMapping("/punto5")
    public String punto5(Model model) {
        Cantante ejemplo = repo.getCantantesStack().peek();

        Function<Cantante, Integer> funcion = (Cantante c) ->
                c.getAlbumes().size();  // ← Solo contar, no sumar

        int total = ejemplo.verTotalAlbumes(funcion);

        model.addAttribute("ejemploNombre", ejemplo.getNombre());
        model.addAttribute("ejemploTotal", total);

        return "punto5";
    }
}