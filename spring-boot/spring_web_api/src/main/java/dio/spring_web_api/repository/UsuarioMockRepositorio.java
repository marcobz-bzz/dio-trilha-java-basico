package dio.spring_web_api.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import dio.spring_web_api.model.Usuario;

@Repository
public class UsuarioMockRepositorio {
    public void save(Usuario usuario) {
        if (usuario.getIdUsuario() == null) {
            System.out.println(">>> salvando usuario: " + usuario);
        } else {
            System.out.println(">>> atualizando usuario: " + usuario);
        }
    }

    public void deleteById(Integer idUsuario) {
        System.out.println(">>> deletando usuario com id = " + idUsuario);
    }

    public List<Usuario> findAll() {
        Usuario u1 = new Usuario("bzz", "123");
        u1.setIdUsuario(1);
        Usuario u2 = new Usuario("fbz", "456");
        u2.setIdUsuario(2);
        Usuario u3 = new Usuario("mcbz", "789");
        u3.setIdUsuario(3);
        return List.of(u1, u2, u3);
    }

    public Usuario findById(Integer idUsuario) {
        Usuario uu = new Usuario("bzz", "123");
        uu.setIdUsuario(idUsuario);
        return uu;
    }

    public Usuario findByUserName(String userName) {
        Usuario uu = new Usuario(userName, "123");
        uu.setIdUsuario(99);
        return uu;
    }
}
