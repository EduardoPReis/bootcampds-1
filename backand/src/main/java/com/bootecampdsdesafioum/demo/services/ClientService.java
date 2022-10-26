package com.bootecampdsdesafioum.demo.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootecampdsdesafioum.demo.dto.ClientDTO;
import com.bootecampdsdesafioum.demo.entities.Client;
import com.bootecampdsdesafioum.demo.repositories.ClientRepository;
import com.bootecampdsdesafioum.demo.services.exceptions.ClientNotFoundException;
import com.bootecampdsdesafioum.demo.services.exceptions.DataBaseException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> list = repository.findAll(pageRequest);
		return list.map(x -> new ClientDTO(x));
	}// BUSCA PAGINADA

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new ClientNotFoundException("Entity not found" + id));
		return new ClientDTO(entity);

	}// BUSCA POR ID

	@Transactional
	public ClientDTO insert(ClientDTO dto) {

		Client entity = new Client();
		entity.setName(dto.getName());;
		entity.setCpf(dto.getCpf());
		entity.setBirthDate(dto.getBirthDate());
		entity.setIncome(dto.getIncome());
		entity.setChildren(dto.getChildren());

		entity = repository.save(entity);
		return new ClientDTO(entity);
	}// CRIANDO POST

	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			Client entity = repository.getOne(id);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new ClientDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ClientNotFoundException("id not found " + id);
		}
	}

	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ClientNotFoundException("id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity violation");
		}
	}

}
