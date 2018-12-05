package ar.edu.unlu.cursos.spring.m05.web;

import ar.edu.unlu.cursos.spring.m05.entity.Libro;
import ar.edu.unlu.cursos.spring.m05.service.AutoresService;
import ar.edu.unlu.cursos.spring.m05.service.LibrosService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/libros")
public class LibrosController {

    private final LibrosService librosService;
    private final AutoresService autoresService;

    @Inject
    public LibrosController(LibrosService librosService, AutoresService autoresService) {
        this.librosService = librosService;
        this.autoresService = autoresService;
    }

    @RequestMapping("")
    public String libros(Model model) {
        List<Libro> libros = librosService.traerTodosOrdenadosPorMasReciente();
        model.addAttribute("librosMasRecientes", libros);
        return "libros";
    }

    @RequestMapping("/{libroId}")
    public String verLibro(Model model, @PathVariable("libroId") long libroId) {
        Optional<Libro> libro = librosService.buscarId(libroId);
        model.addAttribute("libro", libro.orElse(null));
        return "libro-vista";
    }

    @RequestMapping("/nuevo")
    public String nuevoLibro(Model model) {
        model.addAttribute("libroForm", new Libro());
        model.addAttribute("autores", autoresService.traerTodosOrdenadosPorMasReciente());
        return "libro-edicion";
    }

    @RequestMapping(value = "/nuevo", method = RequestMethod.POST)
    public String nuevoLibro(Model model, @ModelAttribute("libroForm") @Valid Libro libroForm, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("autores", autoresService.traerTodosOrdenadosPorMasReciente());
            return "libro-edicion";
        }
        librosService.insertar(libroForm);

        return "redirect:/libros/" + libroForm.getId();
    }

    @RequestMapping("/{libroId}/editar")
    public String editarLibro(Model model, @PathVariable("libroId") long libroId) {
        Libro libro = librosService.buscarId(libroId)
                .orElseThrow(RuntimeException::new);
        model.addAttribute("libroForm", libro);
        model.addAttribute("autores", autoresService.traerTodosOrdenadosPorMasReciente());
        return "libro-edicion";
    }

    @RequestMapping(value = "/{libroId}/editar", method = RequestMethod.POST)
    public String editarLibro(
            Model model,
            @PathVariable("libroId") long libroId,
            @ModelAttribute("libroForm") @Valid Libro libroForm,
            BindingResult result) {

        libroForm.setId(libroId);

        librosService.buscarId(libroId)
                .orElseThrow(RuntimeException::new);

        if (result.hasErrors()) {
            model.addAttribute("autores", autoresService.traerTodosOrdenadosPorMasReciente());
            return "libro-edicion";
        }

        librosService.actualizar(libroForm);

        return "redirect:/libros/" + libroForm.getId();
    }

    @RequestMapping("/{libroId}/borrar")
    public String borrar(Model model, @PathVariable("libroId") long libroId) {
        Libro libro = librosService.buscarId(libroId)
                .orElseThrow(RuntimeException::new);
        model.addAttribute("libro", libro);
        return "libro-borrar";
    }

    @RequestMapping(value = "/{libroId}/borrar", method = RequestMethod.POST)
    public String borrar(@PathVariable("libroId") long libroId) {
        librosService.buscarId(libroId).orElseThrow(RuntimeException::new);
        librosService.eliminar(libroId);
        return "redirect:/libros/";
    }

}
