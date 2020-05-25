package br.com.projetozetta.resources;

import br.com.projetozetta.models.Usuario;
import br.com.projetozetta.reposity.UsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
        return usuarioRepository.findAll();
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

    @DeleteMapping("/usuario")
    @ApiOperation(value="Exclui um usuário do BD")
    public void deletarUsuario(@RequestBody Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    @PutMapping("/usuario")
    @ApiOperation(value="Atualiza um usuário no BD")
    public Usuario atualizarUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

}
