package org.dev_module.service.impl;

import java.util.List;

import javassist.NotFoundException;

import javax.annotation.Resource;

import org.dev_module.model.Cliente;
import org.dev_module.repository.ClienteRepository;
import org.dev_module.service.ClienteService;
import org.springframework.stereotype.Service;

import com.mysema.query.types.Predicate;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Resource
	private ClienteRepository repository;

	public List<Cliente> buscarTodos() throws NotFoundException {

		return repository.findAll();

	}

	public List<Cliente> buscarTodos(Predicate condicao)
			throws NotFoundException {

		if (condicao == null) {
			throw new NotFoundException(
					"Condição de busco do cliente está nullo!");
		}

		return repository.findAll();
	}

	public Cliente salvar(Cliente cliente) throws Exception {

		if (cliente == null) {
			throw new Exception("Objeto cliente está nullo!");
		}

		return repository.save(cliente);

	}

	public void excluir(Long id) throws NotFoundException {

		if (id == null) {
			throw new NotFoundException("Identificador do cliente está nullo!");
		}

		repository.delete(id);

	}

	public Cliente buscasRegistro(Long idCliente) throws NotFoundException {
		if (idCliente == null) {
			throw new NotFoundException(
					"O identificador do cliente está nullo!");
		}

		return repository.findOne(idCliente);

	}

	public Cliente buscasRegistro(Predicate condicao) throws NotFoundException {

		if (condicao == null) {
			throw new NotFoundException(
					"A condição de busca do cliente está nullo!");
		}

		return repository.findOne(condicao);
	}

}
