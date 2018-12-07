package ar.com.mufato.blog.web;

import ar.com.mufato.blog.entity.Autor;
import ar.com.mufato.blog.service.AutoresService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/autores")
public class AutoresController {

    private final AutoresService autoresService;

    public AutoresController(AutoresService autoresService) {
        this.autoresService = autoresService;
    }

    @RequestMapping("")
    public String autores(Model model) {
        List<Autor> autores = autoresService.traerTodosOrdenadosPorMasReciente();
        model.addAttribute("autores", autores);
        return "autores";
    }

    @RequestMapping("/{autorId}")
    public ModelAndView verAutor(@PathVariable("autorId") long autorId) {
        Optional<Autor> autor = autoresService.buscarId(autorId);
        Map<String, Object> model = Collections.singletonMap("autor", autor.orElse(null));
        return new ModelAndView("autor-vista", model);
    }

    @RequestMapping("/nuevo")
    public String nuevoAutor(Model model) {
        model.addAttribute("autorForm", new Autor());
        return "autor-edicion";
    }

    @RequestMapping(value = "/nuevo", method = RequestMethod.POST)
    public String nuevoAutor(@ModelAttribute("autorForm") @Valid Autor autorForm, BindingResult result) {
        if (result.hasErrors()) {
            return "autor-edicion";
        }
        autoresService.insertar(autorForm);

        return "redirect:/autores/" + autorForm.getId();
    }

    @RequestMapping("/{autorId}/editar")
    public String editarAutor(Model model, @PathVariable("autorId") long autorId) {
        Autor autor = autoresService.buscarId(autorId)
                .orElseThrow(RuntimeException::new);
        model.addAttribute("autorForm", autor);
        return "autor-edicion";
    }

    @RequestMapping(value = "/{autorId}/editar", method = RequestMethod.POST)
    public String editarAutor(
            @PathVariable("autorId") long autorId,
            @ModelAttribute("autorForm") @Valid Autor autorForm,
            BindingResult result) {

        autorForm.setId(autorId);

        autoresService.buscarId(autorId)
                .orElseThrow(RuntimeException::new);

        if (result.hasErrors()) {
            return "autor-edicion";
        }

        autoresService.actualizar(autorForm);

        return "redirect:/autores/" + autorForm.getId();
    }

    @RequestMapping("/{autorId}/borrar")
    public String borrar(Model model, @PathVariable("autorId") long autorId) {
        Autor autor = autoresService.buscarId(autorId)
                .orElseThrow(RuntimeException::new);
        model.addAttribute("autor", autor);
        return "autor-borrar";
    }

    @RequestMapping(value = "/{autorId}/borrar", method = RequestMethod.POST)
    public String borrar(
            Model model,
            @PathVariable("autorId") long autorId,
            @ModelAttribute("autor") @Valid Autor autorForm,
            BindingResult result) {
        Autor autor = autoresService.buscarId(autorId).orElseThrow(RuntimeException::new);
        if (!autor.getLibros().isEmpty()) {
            result.reject("cxx", "No se pueden borrar un autor hasta no borrar primero todos sus libros");
            model.addAttribute("autor", autor);
            return "autor-borrar";
        }
        autoresService.eliminar(autorId);
        return "redirect:/autores/";
    }

}
