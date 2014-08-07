package net.com.dev_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlanejamentoFinanceiroController {

	private static final String RETURN_PLANEJAMENTO = "planejamento";
	
	@RequestMapping(value = "/planejamento")
	public ModelAndView planejamentoFinanceiro(){
		ModelAndView view = new ModelAndView(RETURN_PLANEJAMENTO);
		return view;
	}
	
}
