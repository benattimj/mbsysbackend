package com.mbsystems.mysts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mbsystems.mysts.domain.Categoria;
import com.mbsystems.mysts.domain.Produto;
import com.mbsystems.mysts.repositories.CategoriaRepository;
import com.mbsystems.mysts.repositories.ProdutoRepository;
import com.mbsystems.mysts.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Optional<Produto> find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return Optional
				.ofNullable(obj.orElseThrow(() -> 
			new ObjectNotFoundException("Objeto não encontrado! ID:" + id)));
	}

	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);	
	}
	
	
	
	
	
	
	
}