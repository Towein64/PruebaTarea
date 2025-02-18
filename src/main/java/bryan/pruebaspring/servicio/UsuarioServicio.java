package bryan.pruebaspring.servicio;

import bryan.pruebaspring.modelo.Usuario;
import bryan.pruebaspring.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServicio implements IUsuarioServicio{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public void agregarUsuario(Usuario usuario) {
    usuarioRepositorio.save(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
    usuarioRepositorio.delete(usuario);
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
    usuarioRepositorio.save(usuario);
    }

    @Override
    public void hashearPassword(Usuario usuario) {

    }

    @Override
    public Optional<Usuario> encontrarUsuarioPorNombre(String nombre) {
         return usuarioRepositorio.findByNombre(nombre);
    }
}
