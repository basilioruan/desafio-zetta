package br.com.projetozetta.resources;

import br.com.projetozetta.models.Cargo;
import br.com.projetozetta.models.Perfil;
import br.com.projetozetta.models.Usuario;
import br.com.projetozetta.reposity.UsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Usuario")
@CrossOrigin(origins = "*")
public class UsuarioResource {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    @ApiOperation(value="Retorna uma lista de usuários")
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll(Sort.by("nome"));
    }

    @GetMapping("/usuario/{id}")
    @ApiOperation(value="Retorna um único usuário")
    public Usuario listarUsuariolUnico(@PathVariable(value="id") int id){
        return usuarioRepository.findById(id);
    }

    @PostMapping("/usuario")
    @ApiOperation(value="Salva um usuário no BD")
    public Usuario salvarUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping("/usuario/{id}")
    @ApiOperation(value="Exclui um usuário do BD")
    public void deletarUsuario(@PathVariable(value="id") int id){
        usuarioRepository.deleteById(id);
    }

    @PutMapping("/usuario/{id}")
    @ApiOperation(value="Edita um usuario existente")
    public void atualizarUsuario(@RequestBody Usuario usuario, @PathVariable(value="id") int id){
        usuarioRepository.deleteById(id);
        usuarioRepository.save(usuario);
    }

}
