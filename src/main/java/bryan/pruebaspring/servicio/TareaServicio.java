package bryan.pruebaspring.servicio;

import bryan.pruebaspring.modelo.Tarea;
import bryan.pruebaspring.repositorio.TareaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServicio implements ITareaServicio{

    @Autowired
    private TareaRepositorio tareaRepositorio;

    @Override
    public List<Tarea> listarTareas() {
        return tareaRepositorio.findAll();
    }

    @Override
    public void agregarTarea(String nombre , String descripcion) {
        var tarea= new Tarea(nombre,descripcion);
        tareaRepositorio.save(tarea);
    }

    @Override
    public Tarea buscarTareaPorId(Integer idTarea) {
        return tareaRepositorio.findById(idTarea).orElse(null);
    }

    @Override
    public void eliminarTarea(Tarea tarea) {
        tareaRepositorio.delete(tarea);
    }

    @Override
    public void actualizarTarea(Integer id, String nombre, String descripcion) {
        var tarea = new Tarea(id,nombre,descripcion);
        tareaRepositorio.save(tarea);
    }
}
