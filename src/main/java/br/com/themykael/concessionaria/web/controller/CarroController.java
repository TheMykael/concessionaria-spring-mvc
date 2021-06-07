package br.com.themykael.concessionaria.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.themykael.concessionaria.dao.CarroDao;
import br.com.themykael.concessionaria.domain.Carro;
import br.com.themykael.concessionaria.domain.TipoCambio;

@Controller
@RequestMapping("carro")
public class CarroController {
	
	@Autowired
	private CarroDao dao;
	
	@GetMapping("/todos")
	public ModelAndView listaTodos(ModelMap model) {
		model.addAttribute("carros", dao.getTodos());
		return new ModelAndView("/cars/list", model);
	}
	
	@GetMapping("/cadastro")
	public String cadastro(@ModelAttribute("carro") Carro carro, ModelMap model) {
		model.addAttribute("cambios", TipoCambio.values());
		return "/cars/add";
	}
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("carro") Carro carro, BindingResult result,
			RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "/cars/add";
		}
		dao.salvar(carro);
		attr.addFlashAttribute("message", "Carro salvo com sucesso.");
		return "redirect:/carro/todos";
	}
	
	@GetMapping("/update/{id}")
	public ModelAndView preUpdate(@PathVariable("id") Long id, ModelMap model) {
		Carro carro = dao.getId(id);
		model.addAttribute("carro", carro);
		return new ModelAndView("/cars/add", model);
	}
	
	@PostMapping("/update")
	public ModelAndView update(@Valid @ModelAttribute("carro") Carro carro,  BindingResult result,
			RedirectAttributes attr) {
		if (result.hasErrors()) {
			return new ModelAndView("/cars/add");
		}
		dao.editar(carro);
		attr.addFlashAttribute("message", "Carro alterado com sucesso.");
		return new ModelAndView("redirect:/carro/todos");
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes attr) {
		dao.excluir(id);
		attr.addFlashAttribute("message", "Carro removido com sucesso.");
		return "redirect:/carro/todos";
	}
	
}
