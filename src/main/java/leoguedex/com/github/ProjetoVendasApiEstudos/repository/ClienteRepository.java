package leoguedex.com.github.ProjetoVendasApiEstudos.repository;

import leoguedex.com.github.ProjetoVendasApiEstudos.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
