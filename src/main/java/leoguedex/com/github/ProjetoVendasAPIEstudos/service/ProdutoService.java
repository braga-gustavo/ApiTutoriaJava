package leoguedex.com.github.ProjetoVendasAPIEstudos.service;

import leoguedex.com.github.ProjetoVendasAPIEstudos.domain.entity.Produto;
import leoguedex.com.github.ProjetoVendasAPIEstudos.exception.ObjectNotFoundException;
import leoguedex.com.github.ProjetoVendasAPIEstudos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public Produto inserirProduto(Produto produto) {
        produto.setId(null);
        return produtoRepository.save(produto);
    }

    public Produto updateProduto(Produto produto) {
        Produto prodToUpdate = new Produto();
        prodToUpdate.setId(produto.getId());
        prodToUpdate.setPreco(produto.getPreco());
        prodToUpdate.setTitulo(prodToUpdate.getTitulo());
        return produtoRepository.save(prodToUpdate);
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
