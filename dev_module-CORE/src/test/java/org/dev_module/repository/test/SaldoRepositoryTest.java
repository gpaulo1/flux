package org.dev_module.repository.test;

import java.util.List;

import org.dev_module.configuration.AplicationContextTeste;
import org.dev_module.dto.SaldoFluxoDTO;
import org.dev_module.model.Caixa;
import org.dev_module.model.Fluxo;
import org.dev_module.model.Saldo;
import org.dev_module.query.SaldoQuery;
import org.dev_module.service.CaixaService;
import org.dev_module.service.FluxoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.Tuple;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AplicationContextTeste.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class SaldoRepositoryTest {
	
	@Autowired
	private CaixaService caixaService;
	
	@Autowired
	private SaldoQuery saldoQuery;
	
	@Autowired
	private FluxoService fluxoService;
	
	private Fluxo fluxo;

	private Caixa caixa;
	private Saldo saldo;
	private Caixa caixa2;
	private Saldo saldo2;
	
	public SaldoRepositoryTest(){
		caixa = new Caixa();
		saldo = new Saldo();
		fluxo = new Fluxo();
		
		caixa.setEnabled(true);
		caixa.setNome("Nome teste");
		caixa.setNomeAgencia("Nome agencia teste");
		caixa.setNumAgencia("111");
		caixa.setNumConta("122100");
		caixa.setNumDigito("1");
		
		saldo.setSaldoCredito(0.0);
		saldo.setSaldoDebito(0.0);
		saldo.setSaldoDisponivel(100.00);
		
		caixa.setSaldo(saldo);
		
		//Caixa 2
		caixa2 = new Caixa();
		saldo2 = new Saldo();
		
		caixa2.setEnabled(true);
		caixa2.setNome("Nome teste 2");
		caixa2.setNomeAgencia("Nome agencia teste 2");
		caixa2.setNumAgencia("111 2");
		caixa2.setNumConta("122100 2");
		caixa2.setNumDigito("1 2");
		
		saldo2.setSaldoCredito(0.0);
		saldo2.setSaldoDebito(0.0);
		saldo2.setSaldoDisponivel(200.00);
		
		caixa2.setSaldo(saldo2);
		
		fluxo.setDescricao("teste fluxo");
		fluxo.setValor(1.0);
	}
	
	@Test
	public void deveTestarCadastrarCaixaComSaldo() throws Exception{
		Caixa retorno1 = caixaService.salvar(caixa);
		Caixa retorno2 = caixaService.salvar(caixa2);
		
		Assert.assertNotNull(retorno1);
		Assert.assertNotNull(retorno2);
		
		
		
		Assert.assertEquals(caixa.getSaldo().getSaldoCredito(), retorno1.getSaldo().getSaldoCredito());
		
		List<SaldoFluxoDTO>saldos = saldoQuery.buscarSaldoPeloIdCaixa(retorno1.getId());
		
		System.out.println("");
		
		
	}
	
	public void deveTestarCadastrarFluxo(){
		
	}
	
}
