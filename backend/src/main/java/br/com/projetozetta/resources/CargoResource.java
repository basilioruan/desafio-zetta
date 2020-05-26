package br.com.projetozetta.resources;

import br.com.projetozetta.models.Cargo;
import br.com.projetozetta.reposity.CargoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Cargo")
@CrossOrigin(origins = "*")
public class CargoResource {

    @Autowired
    CargoRepository cargoRepository;

    @GetMapping("/cargos")
    @ApiOperation(value="Retorna uma lista de cargos")
    public List<Cargo> listarCargos(){
        return cargoRepository.findAll(Sort.by("nome"));
    }

    @GetMapping("/cargo/{id}")
    @ApiOperation(value="Retorna um único cargo")
    public Cargo listarCargoUnico(@PathVariable(value="id") int id){
        return cargoRepository.findById(id);
    }

    @PostMapping("/cargo")
    @ApiOperation(value="Salva um cargo no BD")
    public Cargo salvarCargo(@RequestBody Cargo cargo){
        return cargoRepository.save(cargo);
    }

    @DeleteMapping("/cargo/{id}")
    @ApiOperation(value="Exclui um cargo do BD")
    public void deletarCargo(@PathVariable(value="id") int id){
        cargoRepository.deleteById(id);
    }

    @PutMapping("/cargo/{id}")
    @ApiOperation(value="Edita um cargo existente")
    public void atualizarCargo(@RequestBody Cargo cargo, @PathVariable(value="id") int id){
        cargoRepository.deleteById(id);
        cargoRepository.save(cargo);
    }

    public Cargo encontrarCargo(int id) {
        return cargoRepository.findById(id);
    }
}
