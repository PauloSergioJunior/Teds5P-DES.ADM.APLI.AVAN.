package br.com.bank.acme.resouce;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.bank.acme.domain.Client;
import br.com.bank.acme.domain.dto.ClientConverterDTO;
import br.com.bank.acme.domain.dto.ClientDTO;
import br.com.bank.acme.service.ClientService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clients")
public class ClientResource {
	
	//FORM -> Para apresentar os dados da base de dados, ou seja, não apresentar o objeto real
	
	private final ClientService service;
	
	private final ClientConverterDTO clientConverterDTO;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Client> createClient(@RequestBody ClientDTO dto) {
		return ResponseEntity
				.ok(this.service.create(this.clientConverterDTO.convertToClient(dto)));
	}
	

	@PutMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Client> updateClient(@RequestBody Client client,@RequestParam("id") Long id) throws Exception {
		return ResponseEntity.ok(this.service.create(this.service.getById(id)
			.orElseThrow(() -> 
				new ResponseStatusException(HttpStatus.BAD_REQUEST,"client not found"))));	
	
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Client> getClientById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.service.getById(id).orElseThrow(() -> 
				new ResponseStatusException(HttpStatus.NO_CONTENT,"client not found")));

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Void> deleteClient(@PathVariable("id") Long id) {
		try {
			this.service.removeById(id);
			return ResponseEntity.ok().build();
			
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<Client>> getAllClients() {
		return ResponseEntity.ok(this.service.getAll());
	}

	
}
