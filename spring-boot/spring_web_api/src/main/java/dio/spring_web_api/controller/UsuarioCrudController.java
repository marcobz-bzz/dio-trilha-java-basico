package dio.spring_web_api.controller;

import java.util.ArrayList;
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

import dio.spring_web_api.model.Usuario;
import dio.spring_web_api.repository.UsuarioCrudRepositorioInterface;

@RestController
@RequestMapping("/usucrud")
public class UsuarioCrudController {
    @Autowired
    private UsuarioCrudRepositorioInterface repositorio;

    @GetMapping()
    public String getUsuariosTxt() {
        return repositorio.findAll().toString();
    }

    @GetMapping("/listar")
    public List<Usuario> getUsuariosJson() {
        List<Usuario> lu = new ArrayList<>();
        repositorio.findAll().forEach(u -> lu.add(u));
        return lu;
    }

    @GetMapping("/pornome/{username}")
    public List<Usuario> getUsuarioPorNome(@PathVariable("username") String nome) {
        return repositorio.findByNome(nome);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUsuario(@PathVariable Integer id){
        repositorio.deleteById(id);
    }

    @PostMapping("/add")
    public void postUsuariosAdd(@RequestBody Usuario user) {
        repositorio.save(user);
    }

    @PutMapping("/update")
    public void putUsuariosUpdate(@RequestBody Usuario user) {
        repositorio.save(user);
    }
}
