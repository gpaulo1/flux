package org.dev_module.service.impl;

import java.util.List;

import org.dev_module.dto.AccountReceivableDTO;
import org.dev_module.model.AccountReceivable;
import org.dev_module.query.AccountReceivableQuery;
import org.dev_module.repository.AccountReceivableRepository;
import org.dev_module.service.AccountReceivableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysema.query.types.Predicate;

@Service
public class AccountReceivableServiceImpl implements AccountReceivableService {

	@Autowired
	private AccountReceivableRepository repository;

	@Autowired
	private AccountReceivableQuery accountQuery;

	public List<AccountReceivable> buscarTodos() throws Exception {

		List<AccountReceivable> retornos = repository.findAll();

		if (retornos.size() < 1) {
			throw new Exception(
					"AccountReceivable não escontrou nenhum registro!");
		}

		return retornos;

	}

	public List<AccountReceivableDTO> buscarTodosOrderById() throws Exception {

		List<AccountReceivableDTO> returns = accountQuery
				.findAllAccountsOrdeByIdDesc();

		if (returns.size() == 0) {
			throw new Exception(
					"AccountReceivable não escontrou nenhum registro!");
		}

		return returns;

	}

	public List<AccountReceivable> buscarTodos(Predicate condicao)
			throws Exception {

		List<AccountReceivable> retornos = (List<AccountReceivable>) repository
				.findAll(condicao);

		if (retornos.size() < 1) {
			throw new Exception(
					"AccountReceivable não escontrou nenhum registro!");
		}

		return retornos;

	}

	public AccountReceivable salvar(AccountReceivable account) throws Exception {

		if (account == null) {
			throw new Exception("Não é possível salvar um objeto nullo!");
		}

		return repository.save(account);

	}

	public void remover(Long id) throws Exception {

		if (id == null) {
			throw new Exception("Identificador do objeto está nullo!");
		}

		repository.delete(id);

	}

	public AccountReceivable buscarRegistro(Long account) throws Exception {

		if (account == null) {
			throw new Exception("Objeto de pesquisa está nulo!");
		}

		return repository.findOne(account);

	}

	public AccountReceivable buscarRegistro(Predicate condicao)
			throws Exception {

		if (condicao == null) {
			throw new Exception("Objeto de pesquisa está nulo!");
		}

		return repository.findOne(condicao);
	}

}
