package org.dev_module.service;

import java.util.List;

import org.dev_module.dto.AccountReceivableDTO;
import org.dev_module.model.AccountReceivable;

import com.mysema.query.types.Predicate;

public interface AccountReceivableService {

	List<AccountReceivable> buscarTodos() throws Exception;

	List<AccountReceivable> buscarTodos(Predicate condicao) throws Exception;
	
	List<AccountReceivableDTO> buscarTodosOrderById() throws Exception;

	AccountReceivable salvar(AccountReceivable account) throws Exception;

	void remover(Long id) throws Exception;

	AccountReceivable buscarRegistro(Long account) throws Exception;

	AccountReceivable buscarRegistro(Predicate condicao) throws Exception;

}
