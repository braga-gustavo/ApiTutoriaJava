package leoguedex.com.github.ProjetoVendasAPIEstudos.service;

import leoguedex.com.github.ProjetoVendasAPIEstudos.domain.entity.Cliente;
import leoguedex.com.github.ProjetoVendasAPIEstudos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente inserirCliente(Cliente cliente){
        cliente.setId(null);
        return clienteRepository.save(cliente);
    }


}
