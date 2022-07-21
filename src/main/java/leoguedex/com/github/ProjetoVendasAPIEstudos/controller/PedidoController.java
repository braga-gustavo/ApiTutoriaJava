package leoguedex.com.github.ProjetoVendasAPIEstudos.controller;

import leoguedex.com.github.ProjetoVendasAPIEstudos.service.PedidoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private PedidoService pedidoService;

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Integer incluirPedido(@RequestBody @Valid PedidoDto pedidoDto){
//        Pedido pedido = pedidoService.incluirPedido(pedidoDto);
//        return pedido.getId();
//    }

}
