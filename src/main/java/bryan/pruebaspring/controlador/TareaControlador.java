package bryan.pruebaspring.controlador;

import bryan.pruebaspring.modelo.Tarea;
import bryan.pruebaspring.modelo.Usuario;
import bryan.pruebaspring.servicio.TareaServicio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TareaControlador {

    @Autowired
    private TareaServicio tareaServicio;

    @GetMapping("/listaTareas")
    public String mostrarListaTareas(ModelMap modelMap, HttpSession session){
        Usuario usuario = (Usuario)session.getAttribute("usuarioLogueado");
        if(usuario==null){
            return "redirect:/login";
        }
        List<Tarea> listasTareas = tareaServicio.listarTareas();
        modelMap.put("tareas",listasTareas);
        return "index";
    }

    @GetMapping("/agregar")
    public String mostrarAgregar(Model model,HttpSession session){
        Usuario usuario = (Usuario)session.getAttribute("usuarioLogueado");
        if(usuario==null){
            return "redirect:/login";
        }
        model.addAttribute("tarea",new Tarea()); // cargamos un objeto tarea vacio para poder usar en la vista con thymeleaf;
        return "formulario-agregar";
    }

    @PostMapping("/agregar")
    public String agregarNuevaTarea(@ModelAttribute("tarea") Tarea tarea){
        var nombre =tarea.getNombre();
        var descripcion = tarea.getDescripcion();
        tareaServicio.agregarTarea(nombre,descripcion);
        return "redirect:/listaTareas";
    }

    @GetMapping("/editar-formulario/{id}")
    public String mostrarEditar(@PathVariable(value = "id") Integer id,ModelMap modelMap){
        Tarea tarea = tareaServicio.buscarTareaPorId(id);
        modelMap.put("tarea",tarea);
        return "formulario-editar";
    }

    @PostMapping("/editar-formulario")
    public String editar(@ModelAttribute("tarea") Tarea tarea){
        tareaServicio.actualizarTarea(tarea.getId(),tarea.getNombre(),tarea.getDescripcion());
        return "redirect:/listaTareas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarTarea(@PathVariable(value = "id")Integer id){
        Tarea tarea = tareaServicio.buscarTareaPorId(id);
        tareaServicio.eliminarTarea(tarea);
        return "redirect:/listaTareas";
    }


}
