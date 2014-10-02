package org.dev_module.service.impl;

import java.util.Date;
import java.util.List;

import javassist.NotFoundException;

import javax.annotation.Resource;

import org.dev_module.enumerator.MensagensEnum;
import org.dev_module.model.Caixa;
import org.dev_module.model.Fluxo;
import org.dev_module.model.Saldo;
import org.dev_module.repository.FluxoRepository;
import org.dev_module.service.FluxoService;
import org.dev_module.service.SaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysema.query.types.Predicate;

@Service
public class FluxoServiceImpl implements FluxoService {

	@Resource
	private FluxoRepository repository;
	
	@Autowired
	private SaldoService saldoService;

	public List<Fluxo> buscarTodos() throws NotFoundException {

		List<Fluxo> retorno = repository.findAll();

		if (retorno.size() == 0) {
			throw new NotFoundException(
					MensagensEnum.NOT_FOUND_DATA.getMessage());
		}

		return retorno;

	}

	public List<Fluxo> buscarTodos(Predicate condicao) throws NotFoundException {
		List<Fluxo> retorno = repository.findAll();
		
		if (retorno.size() == 0) {
			throw new NotFoundException(
					MensagensEnum.NOT_FOUND_DATA.getMessage());
		}
		return retorno;
	}

	public Fluxo salvar(Fluxo fluxo)throws Exception {
		
		Saldo retornoSaldo = new Saldo();
		
		if(fluxo == null){
			throw new Exception("Valor do objeto está nulo");
		}
		
		if(fluxo.getTpEntrada() == true){
			
			retornoSaldo = saldoService.buscarRegistro(fluxo.getSaldo().getId());
			retornoSaldo.setSaldoCredito(fluxo.getValor() + retornoSaldo.getSaldoCredito());
			retornoSaldo.setSaldoDisponivel(fluxo.getValor() + retornoSaldo.getSaldoDisponivel());
			
			
		}else if(fluxo.getTpEntrada() == false){
			
			retornoSaldo = saldoService.buscarRegistro(fluxo.getSaldo().getId());
			retornoSaldo.setSaldoDebito(retornoSaldo.getSaldoDebito() + fluxo.getValor());
			
			if(retornoSaldo.getSaldoDisponivel() > fluxo.getValor()){
				retornoSaldo.setSaldoDisponivel(retornoSaldo.getSaldoDisponivel() - (fluxo.getValor()));
				
			}else if(retornoSaldo.getSaldoDisponivel() < fluxo.getValor()){
					retornoSaldo.setSaldoDisponivel((fluxo.getValor()* -1) + retornoSaldo.getSaldoDisponivel());
			}
		}
		
		Saldo saldoAtualizado = saldoService.salvar(retornoSaldo);
		
		fluxo.setData(new Date());
		
		Fluxo retornoFluxo = repository.save(fluxo);
		
		retornoFluxo.setSaldo(saldoAtualizado);
		
		return retornoFluxo;
	}

	public void remover(Long id) {
		// TODO Auto-generated method stub

	}

	public Fluxo buscarRegistro(Fluxo fluxo) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public Fluxo buscarRegistro(Predicate condicao) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
