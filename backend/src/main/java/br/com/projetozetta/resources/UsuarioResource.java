package br.com.projetozetta.resources;

import br.com.projetozetta.models.Usuario;
import br.com.projetozetta.reposity.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")

public class UsuarioResource {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuario/{id}")
    public Usuario listarUsuariolUnico(@PathVariable(value="id") int id){
        return usuarioRepository.findById(id);
    }

    @PostMapping("/usuario")
    public Usuario salvarUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/usuario")
    public Usuario atualizarUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

}
