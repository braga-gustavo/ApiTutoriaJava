package leoguedex.com.github.ProjetoVendasAPIEstudos.controller;

import leoguedex.com.github.ProjetoVendasAPIEstudos.domain.entity.Cliente;
import leoguedex.com.github.ProjetoVendasAPIEstudos.repository.ClienteRepository;
import leoguedex.com.github.ProjetoVendasAPIEstudos.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/cliente")
public class ClientController {

    @Autowired
    private ClienteRepository clienteRepository;

    private ClienteService clienteService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserirCliente(@RequestBody @Valid Cliente cliente){
        clienteService.inserirCliente(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


}
