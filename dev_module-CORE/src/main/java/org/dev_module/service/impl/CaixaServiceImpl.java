package org.dev_module.service.impl;

import java.util.List;

import javassist.NotFoundException;

import javax.annotation.Resource;

import org.dev_module.enumerator.MensagensEnum;
import org.dev_module.model.Caixa;
import org.dev_module.repository.CaixaRepository;
import org.dev_module.service.CaixaService;
import org.springframework.stereotype.Service;

import com.mysema.query.types.Predicate;

@Service
public class CaixaServiceImpl implements CaixaService {

	@Resource
	private CaixaRepository repository;

	public List<Caixa> buscarTodos() throws NotFoundException {
		List<Caixa> retorno = repository.findAll();

		if (retorno.size() == 0) {
			throw new NotFoundException(
					MensagensEnum.NOT_FOUND_DATA.getMessage());
		}

		return retorno;
	}

	public List<Caixa> buscarTodos(Predicate condicao) throws NotFoundException {
		List<Caixa> retorno = (List<Caixa>) repository.findAll(condicao);

		if (retorno.size() == 0) {
			throw new NotFoundException(
					MensagensEnum.NOT_FOUND_DATA.getMessage());
		}

		return retorno;
	}

	public Caixa salvar(Caixa caixa) {
		
		if(caixa.getNome().equals("BANCO_DO_BRASIL")){
			caixa.setUrlIcone("images/bancos/brasil.jpg");
		}else if(caixa.getNome().equals("BRADESCO")){
			caixa.setUrlIcone("images/bancos/bradesco.jpg");
		}else if(caixa.getNome().equals("BANCO_RURAL")){
			caixa.setUrlIcone("images/bancos/rural.png");
		}else if(caixa.getNome().equals("ITAU")){
			caixa.setUrlIcone("images/bancos/itau.jpg");
		}else if(caixa.getNome().equals("CAIXA")){
			caixa.setUrlIcone("images/bancos/caixa.png");
		}
		
		if(caixa.getSaldo().getSaldoDisponivel() < 0){
			caixa.getSaldo().setSaldoDebito(caixa.getSaldoInicial() * -1);
		}else if(caixa.getSaldo().getSaldoDisponivel() > 0){
			caixa.getSaldo().setSaldoCredito(caixa.getSaldoInicial());
		}
		
		return repository.save(caixa);
	}

	public void remover(Long id) throws NotFoundException {
		// TODO Auto-generated method stub

	}

	public Caixa buscarRegistro(Caixa caixa) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public Caixa buscarRegistro(Predicate condicao) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
