package com.company.controller;

import com.company.entity.ClientContact;
import com.company.service.service.ClientContactService;
import com.company.service.service.ClientNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ClientContactController {

    @Autowired
    private ClientContactService clientContactService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(ClientController.class);

    @PostMapping("/clientsContact")
    public ClientContact saveClientContact(@RequestBody ClientContact clientContact) {
        LOGGER.info("Inside saveClient of ClientContactController");
        return clientContactService.saveClientCContact(clientContact);
    }

    @GetMapping("/clientsContact")
    public List<ClientContact> fetchClientContactList() {
        LOGGER.info("Inside fetchClientList of ClientContactController");
        return clientContactService.fetchClientContactList();
    }

    @GetMapping("/clientsContact/{id}")
    public ClientContact fetchDepartmentById(@PathVariable("id") Integer id_clientContact)
            throws ClientNotFoundException {
        return clientContactService.fetchClientContactById(id_clientContact);
    }

    @DeleteMapping("/clientsContact/{id}")
    public String deleteClientContactById(@PathVariable("id") Integer id_clientContact) {
        clientContactService.deleteClientContactById(id_clientContact);
        return "Client deleted Successfully!!";
    }

    @PutMapping("/clientsContact/{id}")
    public ClientContact updateClientContact(@PathVariable("id") Integer id_clientContact,
                               @RequestBody ClientContact clientContact) {
        return clientContactService.updateClientContact(id_clientContact,clientContact);
    }
}
