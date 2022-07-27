package leoguedex.com.github.ProjetoVendasAPIEstudos.controller;

import java.net.URI;
import javax.validation.Valid;
import leoguedex.com.github.ProjetoVendasAPIEstudos.domain.entity.Pedido;
import leoguedex.com.github.ProjetoVendasAPIEstudos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserirPedido(@Valid @RequestBody Pedido pedido) {
        pedido = pedidoService.inserirPedido(pedido);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }



}