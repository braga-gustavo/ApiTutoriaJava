package leoguedex.com.github.ProjetoVendasAPIEstudos.repository;


import leoguedex.com.github.ProjetoVendasAPIEstudos.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
