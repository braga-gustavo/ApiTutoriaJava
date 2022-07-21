package leoguedex.com.github.ProjetoVendasApiEstudos.repository;

import leoguedex.com.github.ProjetoVendasApiEstudos.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
