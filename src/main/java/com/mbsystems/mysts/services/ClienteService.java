package com.mbsystems.mysts.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbsystems.mysts.domain.Cliente;
import com.mbsystems.mysts.repositories.ClienteRepository;
import com.mbsystems.mysts.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Optional<Cliente> find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return Optional
				.ofNullable(obj.orElseThrow(() -> 
			new ObjectNotFoundException("Objeto não encontrado! ID:" + id)));
	}

}