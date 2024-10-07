package dio.spring_web_api.repository;

import org.springframework.data.repository.CrudRepository;

import dio.spring_web_api.model.Usuario;
import java.util.List;


public interface UsuarioCrudRepositorioInterface extends CrudRepository<Usuario, Integer> {
    List<Usuario> findByNome(String nome);
}
