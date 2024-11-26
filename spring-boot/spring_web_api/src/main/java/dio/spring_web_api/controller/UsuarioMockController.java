package dio.spring_web_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.spring_web_api.handler.BusinessException;
import dio.spring_web_api.model.Usuario;
import dio.spring_web_api.repository.UsuarioMockRepositorio;

@RestController
@RequestMapping("/usumock")
public class UsuarioMockController {

    @Autowired
    private UsuarioMockRepositorio repositorio;

    @GetMapping("/usuarios")
    public List<Usuario> getUsers() {
        return repositorio.findAll();
    }

    @GetMapping("/usuarios/{username}")
    public Usuario getByUsername(@PathVariable String username) {
        return repositorio.findByUserName(username);
    }

    @DeleteMapping("/usuarios/{id}")
    public void deleteById(@PathVariable Integer id) {
        repositorio.deleteById(id);
    }

    @PostMapping("/usuarios")
    public void saveUsuario(@RequestBody Usuario usuario) {
        if (usuario.getNome() == null) {
            throw new BusinessException("O nome do usuário é obrigatório");
        }

        if(usuario.getPassword() == null){
            throw new RuntimeException("+++>>>> senha nula!!!!!!");
        }

        System.out.println("+++++ " + usuario);
        if (usuario.getIdUsuario() == null) {
            System.out.println(">>> salvar: " + usuario);
            repositorio.save(usuario);
        } else
            System.out.println(">>> usuário já cadastrado..." + usuario);
    }

    @PutMapping("/usuarios")
    public void updateUsuario(@RequestBody Usuario usuario) {
        if (usuario.getIdUsuario() == null)
            return;
        repositorio.save(usuario);
    }

}
