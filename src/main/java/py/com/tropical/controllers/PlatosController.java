package py.com.tropical.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import py.com.tropical.entity.Plato;
import py.com.tropical.services.IPlatoService;
import java.util.HashMap;
import java.util.List;
@Controller
public class PlatosController {

	@Autowired
	IPlatoService iPlatoService;
	
	@GetMapping("/platos")
	public String index(Model model) {
		model.addAttribute("listadoPlatos",iPlatoService.getPlatos());
		return "platos/index";
	}
	
	@GetMapping("/platos/create")
	public String platosCreate(Model model) {
		model.addAttribute("plato", new Plato());
		return "platos/create";
	}
	
	@PostMapping("/platos")
	public String platosStore(Plato plato) {
		iPlatoService.insertPlato(plato);
		return "redirect:/platos";
	}
	
	@GetMapping("/platos/{id}/delete")
	public String delete(@PathVariable Long id) {
		iPlatoService.eliminarPlato(id);
		return "redirect:/platos";
	}
	
	@GetMapping("/platos/{id}/update")
	public String update(@PathVariable Long id,Model model) {
		model.addAttribute("plato", iPlatoService.buscarPlatoPorId(id));
		return "platos/create";
	}
}
