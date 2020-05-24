package br.com.projetozetta.reposity;

import br.com.projetozetta.models.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {

    Cargo findById(int id);

}
