package com.company.service.seviceImpl;

import com.company.entity.Client;
import com.company.repository.ClientRepository;
import com.company.service.service.ClientNotFoundException;
import com.company.service.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    public ClientRepository clientRepository;

    @Override
    public Client saveClient(Client client) {

        return clientRepository.save(client);
    }

    @Override
    public List<Client> fetchClientList() {

        return clientRepository.findAll();
    }

    @Override
    public Client fetchClientById(Integer id_client) throws ClientNotFoundException {
        Optional<Client> client =
                clientRepository.findById(id_client);

        if(!client.isPresent()) {
            throw new ClientNotFoundException("Client Not Available");
        }

        return  client.get();
    }

    @Override
    public void deleteClientById(Integer id_client) {
        clientRepository.deleteById(id_client);

    }

    @Override
    public Client updateClient(Integer id_client, Client client) {
        Client cliDB = clientRepository.findById(id_client).get();

        if(Objects.nonNull(client.getName()) &&
                !"".equalsIgnoreCase(client.getName())) {
            cliDB.setName(client.getName());
        }

        if(Objects.nonNull(client.getEmail()) &&
                !"".equalsIgnoreCase(client.getEmail())) {
            cliDB.setEmail(client.getEmail());
        }

        if(Objects.nonNull(client.getNit()) &&
                !"".equalsIgnoreCase(client.getNit())) {
            cliDB.setNit(client.getNit());
        }

        if(Objects.nonNull(client.getAddress()) &&
                !"".equalsIgnoreCase(client.getAddress())) {
            cliDB.setAddress(client.getAddress());
        }

        if(Objects.nonNull(client.getCity()) &&
                !"".equalsIgnoreCase(client.getCity())) {
            cliDB.setCity(client.getCity());
        }

        if(Objects.nonNull(client.getCity()) &&
                !"".equalsIgnoreCase(client.getCity())) {
            cliDB.setCity(client.getCity());
        }

        return clientRepository.save(cliDB);
    }
}
