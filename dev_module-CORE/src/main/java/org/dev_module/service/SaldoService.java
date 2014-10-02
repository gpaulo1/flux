package org.dev_module.service;

import java.util.List;

import org.dev_module.dto.SaldoFluxoDTO;
import org.dev_module.model.Saldo;

import com.mysema.query.types.Predicate;

public interface SaldoService {

	List<Saldo> buscarTodos();

	List<Saldo> buscarTodos(Predicate condicao);
	
	List<SaldoFluxoDTO> buscarPorIdCaixa(Long id);

	Saldo salvar(Saldo saldo);

	void remover(Long id);

	Saldo buscarRegistro(Long id);

	Saldo buscarRegistro(Predicate condicao);
	
}
