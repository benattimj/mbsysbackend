package com.mbsystems.mysts.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbsystems.mysts.domain.Categoria;
import com.mbsystems.mysts.repositories.CategoriaRepository;
import com.mbsystems.mysts.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Optional<Categoria> find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return Optional
				.ofNullable(obj.orElseThrow(() -> 
			new ObjectNotFoundException("Objeto não encontrado! ID:" + id)));
	}

	
	public Categoria insert (Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
		
			
	}
	
}