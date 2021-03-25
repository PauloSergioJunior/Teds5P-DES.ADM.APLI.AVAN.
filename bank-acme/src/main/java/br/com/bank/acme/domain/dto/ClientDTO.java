package br.com.bank.acme.domain.dto;

import br.com.bank.acme.domain.Client;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDTO {

	private String name;
	
	private String email;
	
	private String phone;
	
	
	public static Client convertDtoToClient(ClientDTO dto) {
		
		return Client
					.builder().name(dto.name)
					.email(dto.email)
					.phone(dto.phone).build();
	}
	
	public static ClientDTO convertClientToClientDto(Client client) {
		
		return ClientDTO
				.builder().name(client.getName())
				.email(client.getEmail())
				.phone(client.getPhone()).build();
	}
}
