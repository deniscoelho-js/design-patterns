package core.io.padroesdeprojeto.patterns.service;

import core.io.padroesdeprojeto.patterns.model.Cliente;

public interface ClienteService {
    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void salvar(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);

}
