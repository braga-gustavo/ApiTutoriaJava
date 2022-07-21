package leoguedex.com.github.ProjetoVendasAPIEstudos.service;

import leoguedex.com.github.ProjetoVendasAPIEstudos.domain.entity.Produto;
import leoguedex.com.github.ProjetoVendasAPIEstudos.exception.ObjectNotFoundException;
import leoguedex.com.github.ProjetoVendasAPIEstudos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public void inserirProduto(Produto produto) {
        produto.setId(null);
        produtoRepository.save(produto);
    }

    public void updateProduto(Produto produto) {
        produtoRepository.findById(produto.getId())
                .map(produtoFound -> {
                    produto.setId(produtoFound.getId());
                    produtoRepository.save(produto);
                    return Void.TYPE;
                })
                .orElseThrow(() -> {
                    new ResponseStatusException(HttpStatus.NOT_FOUND, "Produce não Encontrado");
                    return null;
                });
    }

    public Produto find(Integer id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElseThrow(() -> new ObjectNotFoundException("Produto não Encontrado " + id + ", tipo: "
                + Produto.class.getName()));
    }

    public void deleteProduto(Integer id) {
        find(id);

        try{
            produtoRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não é possível excluir um Produto com dados vinculados");
        }
    }

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

}
