package leoguedex.com.github.ProjetoVendasAPIEstudos.service;

import leoguedex.com.github.ProjetoVendasAPIEstudos.domain.dto.PedidoDto;
import leoguedex.com.github.ProjetoVendasAPIEstudos.domain.entity.Cliente;
import leoguedex.com.github.ProjetoVendasAPIEstudos.domain.entity.ItemPedido;
import leoguedex.com.github.ProjetoVendasAPIEstudos.domain.entity.Pedido;
import leoguedex.com.github.ProjetoVendasAPIEstudos.domain.entity.Produto;
import leoguedex.com.github.ProjetoVendasAPIEstudos.domain.enums.StatusPedido;
import leoguedex.com.github.ProjetoVendasAPIEstudos.exception.RegraDeNegocioException;
import leoguedex.com.github.ProjetoVendasAPIEstudos.repository.ClienteRepository;
import leoguedex.com.github.ProjetoVendasAPIEstudos.repository.ItemPedidoRepository;
import leoguedex.com.github.ProjetoVendasAPIEstudos.repository.PedidoRepository;
import leoguedex.com.github.ProjetoVendasAPIEstudos.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;


    public Pedido incluirPedido(PedidoDto pedidoDto) {

        //Montar os itens do pedido
        validarItens(pedidoDto);
        //Encontrar o Cliente
        Cliente cliente = findCliente(pedidoDto);
        //Criar um novo Pedido
        Pedido pedido = builderPedido(pedidoDto, cliente);

        List<ItemPedido> itens = builderItemPedido(pedidoDto, pedido);
        pedidoRepository.save(pedido);
        itemPedidoRepository.saveAll(itens);

        return pedido;
    }

    private List<ItemPedido> builderItemPedido(PedidoDto pedidoDto, Pedido pedido) {
        return pedidoDto.getItens().stream()
                .map(itemPedidoDto -> {
                    Produto produto =  produtoRepository.findById(itemPedidoDto.getProduto())
                            .orElseThrow(() -> new RegraDeNegocioException("Código de Produto Invalido"));
                    return ItemPedido.builder()
                        .pedido(pedido)
                        .produto(produto)
                        .quatidade(itemPedidoDto.getQuantidade())
                        .build();
                })
                .collect(Collectors.toList());
    }

    private Pedido builderPedido(PedidoDto pedidoDto, Cliente cliente) {
        return Pedido.builder()
                .cliente(cliente)
                .dataPedido(LocalDate.now())
                .total(pedidoDto.getTotal())
                .statusPedido(StatusPedido.ABERTO)
                .build();
    }

    private Cliente findCliente(PedidoDto pedidoDto) {
        return clienteRepository.findById(pedidoDto.getCliente())
                .orElseThrow(()-> new RegraDeNegocioException("Codigo de cliente invalido"));
    }

    private void validarItens(PedidoDto pedidoDto) {
        if (pedidoDto.getItens().isEmpty()){
            throw new RegraDeNegocioException("Não é possivel realizar um pedido sem itens");
        }
    }



}
