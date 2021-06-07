package br.com.themykael.concessionaria.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	@GetMapping("/")
	public String welcome() {
		return "redirect:/carro/todos";
	}
	
	@GetMapping("/teste")
	public ModelAndView teste() {
		ModelAndView view = new ModelAndView("welcome");
		view.addObject("teste", "Olá, Spring MVC");
		return view;
	}

}
