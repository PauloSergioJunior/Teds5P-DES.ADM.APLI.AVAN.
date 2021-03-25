package br.com.bank.acme.domain.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bank.acme.domain.Client;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ClientConverterDTO {

	@Autowired
	private ModelMapper modelMapper;
	
	
	public Client convertToClient(ClientDTO dto) {
		return modelMapper.map(dto, Client.class);
	}
	
}
