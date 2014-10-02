package org.dev_module.service.impl;

import java.util.List;

import org.dev_module.dto.SaldoFluxoDTO;
import org.dev_module.model.Saldo;
import org.dev_module.query.SaldoQuery;
import org.dev_module.repository.SaldoRepository;
import org.dev_module.service.SaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysema.query.types.Predicate;

import javax.annotation.Resource;

@Service
public class SaldoServiceImpl implements SaldoService {

	@Resource
	private SaldoRepository repository;

	@Autowired
	private SaldoQuery saldoQuery;

	public List<Saldo> buscarTodos() {
		return repository.findAll();
	}

	public List<Saldo> buscarTodos(Predicate condicao) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SaldoFluxoDTO> buscarPorIdCaixa(Long id) {
		return saldoQuery.buscarSaldoPeloIdCaixa(id);
	}

	public Saldo salvar(Saldo saldo) {
		return repository.save(saldo);
	}

	public void remover(Long id) {
		// TODO Auto-generated method stub

	}

	public Saldo buscarRegistro(Long id) {
		return repository.findOne(id);
	}

	public Saldo buscarRegistro(Predicate condicao) {
		// TODO Auto-generated method stub
		return null;
	}

}
