package leoguedex.com.github.ProjetoVendasAPIEstudos.repository;

import leoguedex.com.github.ProjetoVendasAPIEstudos.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
