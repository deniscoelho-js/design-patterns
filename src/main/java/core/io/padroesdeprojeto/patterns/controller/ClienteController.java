package core.io.padroesdeprojeto.patterns.controller;

import core.io.padroesdeprojeto.patterns.model.Cliente;
import core.io.padroesdeprojeto.patterns.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos(){
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente){
        clienteService.salvar(cliente);
        return ResponseEntity.ok(cliente);
    }
}
