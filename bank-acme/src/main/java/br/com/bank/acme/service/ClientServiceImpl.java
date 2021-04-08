package br.com.bank.acme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.bank.acme.domain.Client;
import br.com.bank.acme.repository.ClientRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
	
	
	private final ClientRepository repository;


	@Override
	public List<Client> getAll() {
		return this.repository.findAll();
	}

	@Override
	public Optional<Client> getById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public Optional<Client> getByEmail(String email) {
		return this.repository.findByEmail(email);
	}

	@Override
	public void removeById(Long id) throws Exception {
		if(this.repository.findById(id).get() != null) {
			this.repository.deleteById(id);
		}else {
			throw new Exception("Client not found");
		}
	}

	@Override
	public Client removeByEmail(String email) throws Exception {
		Client client = this.repository.findByEmail(email).get();
		if(client != null) {
			this.repository.deleteById(client.getId());
			return client;
		}
		
		throw new Exception("Client not found");
	}

	@Override
	public Client create(Client client) {
		//BeanUtils.copyProperties(O que esta vindo da request, O que tem no banco de dados );
		return this.repository.save(client);
	}

}
