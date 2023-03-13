package com.company.service.seviceImpl;

import com.company.entity.ClientContact;
import com.company.repository.ClientContactRepository;
import com.company.service.service.ClientContactService;
import com.company.service.service.ClientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientContactServiceImpl implements ClientContactService {

    @Autowired
    public ClientContactRepository clientContactRepository;

    @Override
    public ClientContact saveClientCContact(ClientContact clientContact) {
        return clientContactRepository.save(clientContact);
    }

    @Override
    public List<ClientContact> fetchClientContactList() {
        return clientContactRepository.findAll();
    }

    @Override
    public ClientContact fetchClientContactById(Integer id_clientContact) throws ClientNotFoundException {

        Optional<ClientContact> clientContact =
                clientContactRepository.findById(id_clientContact);

        if(!clientContact.isPresent()) {
            throw new ClientNotFoundException("Client Not Available");
        }

        return  clientContact.get();
    }

    @Override
    public void deleteClientContactById(Integer id_clientContact) {
        clientContactRepository.deleteById(id_clientContact);
    }

    @Override
    public ClientContact updateClientContact(Integer id_clientContact, ClientContact clientContact) {
        ClientContact cliContactDB = clientContactRepository.findById(id_clientContact).get();

        if(Objects.nonNull(clientContact.getName()) &&
                !"".equalsIgnoreCase(clientContact.getName())) {
            cliContactDB.setName(clientContact.getName());
        }

        if(Objects.nonNull(clientContact.getEmail()) &&
                !"".equalsIgnoreCase(clientContact.getEmail())) {
            cliContactDB.setEmail(clientContact.getEmail());
        }

        return clientContactRepository.save(cliContactDB);
    }
}
