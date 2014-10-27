package net.com.dev_web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javassist.NotFoundException;

import org.dev_module.dto.ClienteFindMainDTO;
import org.dev_module.model.AccountReceivable;
import org.dev_module.query.AccountReceivableQuery;
import org.dev_module.service.AccountReceivableService;
import org.dev_module.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AccountReceivableController {

	private static final String RETURN_ACCOUNT_RECEIVABLE = "account-receivable";
	private static final String RETURN_NEW_ACCOUNT_RECEIVABLE = "new-account-receivable";
	private static final String REDIRECT_ACCOUNT_RECEIVABLE = "redirect:/account-receivable";
	
	@Autowired
	private AccountReceivableService accountService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private AccountReceivableQuery accountQuery;
	
	@RequestMapping(value = "/account-receivable", method = RequestMethod.GET)
	public ModelAndView summary() {
		
		ModelAndView view = new ModelAndView(RETURN_ACCOUNT_RECEIVABLE);
		
		try {
			view.addObject("accounts", accountService.buscarTodosOrderById());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return view;
	}

	@RequestMapping(value = "account-receivable/new")
	public ModelAndView newAccount(){
		ModelAndView view = new ModelAndView(RETURN_NEW_ACCOUNT_RECEIVABLE);
		view.addObject("account", new AccountReceivable());
		view.addObject("dataAtual", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(calendar.DAY_OF_MONTH, + 10);
		
		view.addObject("dataVencimento", new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));
		
		return view;
	}
	
	@RequestMapping(value = "account-receivable/save")
	public ModelAndView salvar(@ModelAttribute("account") AccountReceivable account, RedirectAttributes redirect){
		
		
		ModelAndView view = new ModelAndView("listar-cliente");
		
		System.out.println("Obs: " + account.getObservacao());
		
		try {
			accountService.salvar(account);
			
		} catch (Exception e) {
			
//			view.addObject(RETURN_NEW_ACCOUNT_RECEIVABLE);
//			view.addObject("msg", "Ocorreu um erro ao salvar registro de entrada!");
			e.printStackTrace();
			
		}
		
		return view;
		
	}
	
	@RequestMapping(value = "account-receivable/buscar-cliente/{nome}")
	public @ResponseBody List<ClienteFindMainDTO> buscarCliente(@RequestBody @PathVariable("nome") String nome){
		
		List<ClienteFindMainDTO> clientes = new ArrayList<ClienteFindMainDTO>();
		
		try {
			
			clientes =  clienteService.filterByName(nome);
			
		} catch (NotFoundException e) {
			
			e.printStackTrace();
			
		}
		return clientes;
	}
	
	@RequestMapping(value = "account-receivable/listar")
	public ModelAndView listar(){
		ModelAndView view = new ModelAndView();
		
		
		
		return view; 
	}
	
}
