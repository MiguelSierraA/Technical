package com.company.controller;

import java.util.List;

import com.company.service.service.ClientNotFoundException;
import com.company.service.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.company.entity.Client;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ClientController {

	@Autowired
	private ClientService clientService;

	private final Logger LOGGER =
			LoggerFactory.getLogger(ClientController.class);

	@PostMapping("/clients")
	public Client saveClient(@RequestBody Client client) {
		LOGGER.info("Inside saveClient of ClientController");
		return clientService.saveClient(client);
	}

	@GetMapping("/clients")
	public List<Client> fetchClientList() {
		LOGGER.info("Inside fetchClientList of ClientController");
		return clientService.fetchClientList();
	}

	@GetMapping("/clients/{id}")
	public Client fetchClientById(@PathVariable("id") Integer id_client)
			throws ClientNotFoundException {
		return clientService.fetchClientById(id_client);
	}

	@DeleteMapping("/clients/{id}")
	public String deleteClientById(@PathVariable("id") Integer id_client) {
		clientService.deleteClientById(id_client);
		return "Client deleted Successfully!!";
	}

	@PutMapping("/clients/{id}")
	public Client updateClient(@PathVariable("id") Integer id_client,
									   @RequestBody Client client) {
		return clientService.updateClient(id_client,client);
	}

}