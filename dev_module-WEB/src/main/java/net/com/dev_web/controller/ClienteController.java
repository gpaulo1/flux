package net.com.dev_web.controller;

import javassist.NotFoundException;

import org.dev_module.enumerator.MensagensEnum;
import org.dev_module.model.Cliente;
import org.dev_module.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ClienteController {

	private static final String RETURN_NOVO_CLIENTE = "novo-cliente";
	private static final String RETURN_LISTAR_CLIENTE = "listar-cliente";
	private static final String REDIRECT_NOVO_CLIENTE = "redirect:/cliente/novo";
	private static final String REDIRECT_LISTAR_CLIENTE = "redirect:/cliente/listar";

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "cliente/novo")
	public ModelAndView novoCliente() {
		ModelAndView view = new ModelAndView(RETURN_NOVO_CLIENTE);
		view.addObject("cliente", new Cliente());
		return view;
	}

	@RequestMapping(value = "cliente/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(@ModelAttribute("cliente") Cliente cliente,
			RedirectAttributes redirect) {
		ModelAndView view = new ModelAndView(REDIRECT_NOVO_CLIENTE);

		System.out.println("nome: " + cliente.getNome());
		System.out.println("cpf: " + cliente.getCpf());
		System.out.println("email: " + cliente.getEmail());
		return view;
	}

	@RequestMapping(value = "cliente/listar")
	public ModelAndView listar() throws NotFoundException {
		ModelAndView view = new ModelAndView(RETURN_LISTAR_CLIENTE);

		view.addObject("clientes", clienteService.buscarTodos());

		return view;
	}

	@RequestMapping(value = "cliente/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id,
			RedirectAttributes redirect) {
		ModelAndView view = new ModelAndView(REDIRECT_LISTAR_CLIENTE);

		try {
			clienteService.excluir(id);
			redirect.addFlashAttribute("msg",
					MensagensEnum.MSG_REMOVE_SUCEES.getMessage());
		} catch (NotFoundException e) {
			redirect.addFlashAttribute("msg",
					MensagensEnum.MSG_ERROR.getMessage());
			e.printStackTrace();
		}

		return view;
	}

	
	@RequestMapping(value = "cliente/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id,
			RedirectAttributes redirect) throws NotFoundException {
		ModelAndView view = new ModelAndView(RETURN_NOVO_CLIENTE);
		view.addObject("cliente", clienteService.buscasRegistro(id));
		return view;
	}
	
}
