package br.com.bank.acme.service;

import java.util.List;
import java.util.Optional;

import br.com.bank.acme.domain.Client;

public interface ClientService {

	List<Client> getAll();

	Optional<Client> getById(Long id);

	Optional<Client> getByEmail(String email);

	void removeById(Long id) throws Exception;

	Client removeByEmail(String email) throws Exception;

	Client create(Client client);

}