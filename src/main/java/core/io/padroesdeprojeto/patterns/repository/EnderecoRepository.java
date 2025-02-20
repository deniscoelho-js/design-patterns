package core.io.padroesdeprojeto.patterns.repository;

import core.io.padroesdeprojeto.patterns.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String> {
}
