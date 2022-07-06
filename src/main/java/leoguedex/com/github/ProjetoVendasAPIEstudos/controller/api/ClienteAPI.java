package leoguedex.com.github.ProjetoVendasAPIEstudos.controller.api;

import leoguedex.com.github.ProjetoVendasAPIEstudos.domain.entity.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface ClienteAPI {

    ResponseEntity<Void> inserirCliente(@RequestBody @Valid Cliente cliente);
  //  ResponseEntity<Void> atualizaCliente();
  //  ResponseEntity<Void> buscaCliente();
  //  ResponseEntity<Void> deletaCliente();

}
