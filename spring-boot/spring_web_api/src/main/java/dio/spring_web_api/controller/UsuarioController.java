package dio.spring_web_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dio.spring_web_api.model.Usuario;
import dio.spring_web_api.repository.UsuarioRepositorioInterface;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepositorioInterface repositorio;

    @GetMapping()
    public String getUsuariosTxt() {
        return repositorio.findAll().toString();
    }
    
    @GetMapping("/listar")
    public List<Usuario> getUsuariosJson() {
        return repositorio.findAll();
    }
    
    @GetMapping("/pornome/{username}")
    public List<Usuario> getUsuarioPorNome(@PathVariable String username) {
        return repositorio.findByNome(username);
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteUsuario(@PathVariable("id") Integer idUsuario){
        repositorio.deleteById(idUsuario);
    }

    @PostMapping("/add")
    public void postUsuariosAdd(@RequestBody Usuario user) {
        repositorio.updateOrInsert(user);
    }
    
    @PutMapping("/update")
    public void putUsuariosUpdate(@RequestBody Usuario user) {
        repositorio.updateOrInsert(user);
    }
    
}
