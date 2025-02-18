package bryan.pruebaspring.repositorio;

import bryan.pruebaspring.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Integer>{
    Optional<Usuario> findByNombre(String nombre);
}
