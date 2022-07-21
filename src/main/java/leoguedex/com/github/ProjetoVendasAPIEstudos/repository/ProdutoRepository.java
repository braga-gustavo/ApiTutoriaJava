package leoguedex.com.github.ProjetoVendasAPIEstudos.repository;

import leoguedex.com.github.ProjetoVendasAPIEstudos.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
