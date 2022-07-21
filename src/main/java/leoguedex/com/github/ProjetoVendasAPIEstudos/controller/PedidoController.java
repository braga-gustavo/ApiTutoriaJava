package leoguedex.com.github.ProjetoVendasAPIEstudos.controller;

import leoguedex.com.github.ProjetoVendasAPIEstudos.domain.dto.PedidoDto;
import leoguedex.com.github.ProjetoVendasAPIEstudos.domain.entity.Pedido;
import leoguedex.com.github.ProjetoVendasAPIEstudos.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private PedidoService pedidoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer incluirPedido(@RequestBody @Valid PedidoDto pedidoDto){
        Pedido pedido = pedidoService.incluirPedido(pedidoDto);
        return pedido.getId();
    }

}
