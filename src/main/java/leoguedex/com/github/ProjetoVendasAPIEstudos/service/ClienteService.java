package leoguedex.com.github.ProjetoVendasAPIEstudos.service;

import leoguedex.com.github.ProjetoVendasAPIEstudos.domain.dto.ClienteDto;
import leoguedex.com.github.ProjetoVendasAPIEstudos.domain.entity.Cliente;
import leoguedex.com.github.ProjetoVendasAPIEstudos.exception.ObjectNotFoundException;
import leoguedex.com.github.ProjetoVendasAPIEstudos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente inserirCliente(Cliente cliente) {
        cliente.setId(null);
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Cliente cliente) {
        Cliente clienteToUpdate = find(cliente.getId());
        updateData(clienteToUpdate, cliente);
        return clienteRepository.save(clienteToUpdate);
    }

    public void updateData(Cliente clienteToUpdate, Cliente cliente) {
        clienteToUpdate.setNome(cliente.getNome());
        clienteToUpdate.setEmail(cliente.getEmail());
        clienteToUpdate.setTelefone(cliente.getTelefone());
    }

    public Cliente find(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundException("Cliente não Encontrado " + id + ", tipo: "
                + Cliente.class.getName()));
    }

    public Cliente fromDto(ClienteDto clienteDto) {
        return new Cliente(clienteDto.getId(), clienteDto.getNome(), clienteDto.getEmail(), clienteDto.getTelefone(),
        null, null);
    }

    public void deleteCliente(Integer id) {
        find(id);

        try{
            clienteRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não é possível excluir um cliente com dados vinculados");
        }
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

}
