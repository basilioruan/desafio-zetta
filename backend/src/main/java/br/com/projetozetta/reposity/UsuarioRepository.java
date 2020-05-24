package br.com.projetozetta.reposity;

import br.com.projetozetta.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findById(int id);

}
