package core.io.padroesdeprojeto.patterns.repository;

import core.io.padroesdeprojeto.patterns.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
