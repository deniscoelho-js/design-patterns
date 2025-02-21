package core.io.padroesdeprojeto.patterns.service.impl;

import core.io.padroesdeprojeto.patterns.model.Cliente;
import core.io.padroesdeprojeto.patterns.model.Endereco;
import core.io.padroesdeprojeto.patterns.repository.ClienteRepository;
import core.io.padroesdeprojeto.patterns.repository.EnderecoRepository;
import core.io.padroesdeprojeto.patterns.service.ClienteService;
import core.io.padroesdeprojeto.patterns.service.ViaCepService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    private final EnderecoRepository enderecoRepository;

    private final ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void salvar(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {

    }

    @Override
    public void deletar(Long id) {
    }

    private void salvarClienteComCep(Cliente cliente){
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
