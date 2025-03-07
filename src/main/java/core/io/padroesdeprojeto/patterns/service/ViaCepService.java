package core.io.padroesdeprojeto.patterns.service;

import core.io.padroesdeprojeto.patterns.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
    @GetMapping(value = "/{cep}/json")
    Endereco consultarCep(@PathVariable("cep") String cep);
}
