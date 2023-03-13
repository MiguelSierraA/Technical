package com.company.service.service;

import com.company.entity.Client;

import java.util.List;

public interface ClientService {

    public Client saveClient (Client client);

    public List<Client> fetchClientList();

    Client fetchClientById(Integer id_client) throws ClientNotFoundException;

    public void deleteClientById(Integer id_client);

    public Client updateClient(Integer id_client, Client client);

}
