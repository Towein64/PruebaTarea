package bryan.pruebaspring.controlador;

import bryan.pruebaspring.modelo.Usuario;
import bryan.pruebaspring.servicio.UsuarioServicio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/login")
    public String loginUsuario(Model model){
    model.addAttribute("usuario",new Usuario());
    return "loginForm";
    }

    @PostMapping("/login")
    public String loginUsuario(@ModelAttribute Usuario usuario, Model model, HttpSession session){  // mediante HttpSession podemos guardar el estado de inicio de sesion de un usuario
        System.out.println(usuario);
        var nombreUsuario = usuario.getNombre();
        var pass = usuario.getPassword();
        Optional<Usuario> encontrarUsuario = usuarioServicio.encontrarUsuarioPorNombre(nombreUsuario);
        if(encontrarUsuario.isPresent())
            if(encontrarUsuario.get().getPassword().equals(pass)) {
                session.setAttribute("usuarioLogueado",encontrarUsuario.get());
                System.out.println("Inicisio de Sesion exitoso");
                return "redirect:/listaTareas";
            }
            else {
                System.out.println("Pass incorrecto");
                model.addAttribute("error","Pass incorrecto");
            }
        else {
            System.out.println("No se encontro usuario");
            model.addAttribute("error","Usuario no encontrado");
        }
    return "loginForm";
    }

    @GetMapping("/register")
    public String register(Model model){
    model.addAttribute("usuario",new Usuario());
    return "registerForm";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute Usuario usuario, RedirectAttributes redirectAttributes){
        usuarioServicio.agregarUsuario(usuario);
       redirectAttributes.addFlashAttribute("usuarioRegistrado","Nuevo Usuario Registrado");
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }
}
