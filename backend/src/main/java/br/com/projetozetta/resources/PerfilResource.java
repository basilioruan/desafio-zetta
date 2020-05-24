package br.com.projetozetta.resources;

import br.com.projetozetta.models.Perfil;
import br.com.projetozetta.reposity.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")

public class PerfilResource {

    @Autowired
    PerfilRepository perfilRepository;

    @GetMapping("/perfis")
    public List<Perfil> listarPerfis(){
        return perfilRepository.findAll();
    }

    @GetMapping("/perfil/{id}")
    public Perfil listarPerfilUnico(@PathVariable(value="id") int id){
        return perfilRepository.findById(id);
    }

    @PostMapping("/perfil")
    public Perfil salvarPerfil(@RequestBody Perfil perfil){
        return perfilRepository.save(perfil);
    }

    @PutMapping("/perfil")
    public Perfil atualizarPerfil(@RequestBody Perfil perfil){
        return perfilRepository.save(perfil);
    }

}
