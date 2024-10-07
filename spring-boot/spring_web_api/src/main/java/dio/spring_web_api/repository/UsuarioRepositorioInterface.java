package dio.spring_web_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dio.spring_web_api.model.Usuario;
import jakarta.transaction.Transactional;

public interface UsuarioRepositorioInterface extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByNome(String nome);

    void deleteByIdUsuario(Integer idUsuario);

    @Transactional
    default Usuario updateOrInsert(Usuario user){return save(user);}
}
