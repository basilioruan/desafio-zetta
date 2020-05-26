package br.com.projetozetta.reposity;

import br.com.projetozetta.models.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Integer> {

    Perfil findById(int id);
    Perfil deleteById(int id);
}
