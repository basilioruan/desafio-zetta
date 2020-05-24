package br.com.projetozetta.resources;

import br.com.projetozetta.models.Cargo;
import br.com.projetozetta.reposity.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")

public class CargoResource {

    @Autowired
    CargoRepository cargoRepository;

    @GetMapping("/cargos")
    public List<Cargo> listarCargos(){
        return cargoRepository.findAll();
    }

    @GetMapping("/cargo/{id}")
    public Cargo listarCargoUnico(@PathVariable(value="id") int id){
        return cargoRepository.findById(id);
    }

    @PostMapping("/cargo")
    public Cargo salvarCargo(@RequestBody Cargo cargo){
        return cargoRepository.save(cargo);
    }

    @DeleteMapping("/cargo")
    public void deletarCargo(@RequestBody Cargo cargo){
        cargoRepository.delete(cargo);
    }

    @PutMapping("/cargo")
    public Cargo atualizarCargo(@RequestBody Cargo cargo){
        return cargoRepository.save(cargo);
    }

}
