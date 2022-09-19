package com.mbsystems.mysts.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbsystems.mysts.domain.Pedido;
import com.mbsystems.mysts.repositories.PedidoRepository;
import com.mbsystems.mysts.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Optional<Pedido> find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return Optional
				.ofNullable(obj.orElseThrow(() -> 
			new ObjectNotFoundException("Objeto não encontrado! ID:" + id)));
	}

}