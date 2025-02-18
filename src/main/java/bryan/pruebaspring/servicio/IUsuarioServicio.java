package bryan.pruebaspring.servicio;

import bryan.pruebaspring.modelo.Usuario;

import java.util.Optional;

public interface IUsuarioServicio {
    public void agregarUsuario(Usuario usuario);
    public void eliminarUsuario(Usuario usuario);
    public void modificarUsuario(Usuario usuario);
    public void hashearPassword(Usuario usuario);
    public Optional<Usuario> encontrarUsuarioPorNombre(String nombre);

}
