package bryan.pruebaspring.repositorio;

import bryan.pruebaspring.modelo.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepositorio extends JpaRepository<Tarea,Integer> {
}
