package bryan.pruebaspring.servicio;

import bryan.pruebaspring.modelo.Tarea;

import java.util.List;

public interface ITareaServicio {
    public List<Tarea> listarTareas();
    public void agregarTarea(String nombre , String descripcion);
    public Tarea buscarTareaPorId(Integer idTarea);
    public void eliminarTarea(Tarea tarea);
    public void actualizarTarea(Integer id , String nombre , String descripcion);
}
