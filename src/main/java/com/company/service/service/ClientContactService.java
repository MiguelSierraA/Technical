package com.company.service.service;


import com.company.entity.ClientContact;

import java.util.List;

public interface ClientContactService {

    public ClientContact saveClientCContact (ClientContact clientContact);

    public List<ClientContact> fetchClientContactList();

    ClientContact fetchClientContactById(Integer id_clientContact) throws ClientNotFoundException;

    public void deleteClientContactById(Integer id_clientContact);

    public ClientContact updateClientContact(Integer id_clientContact, ClientContact clientContact);

}
