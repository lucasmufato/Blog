package ar.com.mufato.blog.web;

import ar.com.mufato.blog.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Controller
public class LoginController {

    private final UsuarioService usuarioService;

    @Inject
    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }

//    https://memorynotfound.com/spring-boot-spring-security-thymeleaf-form-login-example/
}
