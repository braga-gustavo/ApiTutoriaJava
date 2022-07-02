package leoguedex.com.github.ProjetoVendasAPIEstudos.service;

import leoguedex.com.github.ProjetoVendasAPIEstudos.domain.entity.Client;
import leoguedex.com.github.ProjetoVendasAPIEstudos.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Client inserirCliente(Client cliente){
        cliente.setId(null);
        return clientRepository.save(cliente);
    }


}
