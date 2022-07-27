package leoguedex.com.github.ProjetoVendasAPIEstudos.service;

import java.util.Date;
import leoguedex.com.github.ProjetoVendasAPIEstudos.domain.entity.ItemPedido;
import leoguedex.com.github.ProjetoVendasAPIEstudos.domain.entity.Pedido;
import leoguedex.com.github.ProjetoVendasAPIEstudos.repository.ItemPedidoRepository;
import leoguedex.com.github.ProjetoVendasAPIEstudos.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ProdutoService produtoService;

  public Pedido inserirPedido(Pedido pedido) {
    pedido.setId(null);
    pedido.setInstante(new Date());
    pedido.setCliente(clienteService.find(pedido.getCliente().getId()));
    pedido = pedidoRepository.save(pedido);

    for (ItemPedido ip : pedido.getItens()) {
      ip.setProduto(produtoService.find(ip.getProduto().getId()));
      ip.setPreco(ip.getProduto().getPreco());
      ip.geraSubTotal();
      ip.setPedido(pedido);
    }
    itemPedidoRepository.saveAll(pedido.getItens());
    return pedido;
  }

}
