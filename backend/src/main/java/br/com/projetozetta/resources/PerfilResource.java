package br.com.projetozetta.resources;

import br.com.projetozetta.models.Cargo;
import br.com.projetozetta.models.Perfil;
import br.com.projetozetta.reposity.PerfilRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.persistence.OrderBy;
import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Perfil")
@CrossOrigin(origins = "*")
public class PerfilResource {

    @Autowired
    PerfilRepository perfilRepository;

    @GetMapping("/perfis")
    @ApiOperation(value="Retorna uma lista de perfis")
    public List<Perfil> listarPerfis(){
        return perfilRepository.findAll(Sort.by("nome"));
    }

    @GetMapping("/perfil/{id}")
    @ApiOperation(value="Retorna um único perfil")
    public Perfil listarPerfilUnico(@PathVariable(value="id") int id){ return perfilRepository.findById(id); }

    @PostMapping("/perfil")
    @ApiOperation(value="Salva um perfil no BD")
    public Perfil salvarPerfil(@RequestBody Perfil perfil){
        return perfilRepository.save(perfil);
    }

    @DeleteMapping("/perfil/{id}")
    @ApiOperation(value="Exclui um perfil do BD")
    public void deletarPerfil(@PathVariable(value="id") int id){
        perfilRepository.deleteById(id);
    }

    @PutMapping("/perfil/{id}")
    @ApiOperation(value="Edita um perfil existente")
    public void atualizarPerfil(@RequestBody Perfil perfil, @PathVariable(value="id") int id){
        perfilRepository.deleteById(id);
        perfilRepository.save(perfil);
    }

}
