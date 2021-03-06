package br.com.bank.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bank.acme.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
