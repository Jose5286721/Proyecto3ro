package py.com.tropical.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import py.com.tropical.services.IMenuConcretoPlatosService;
import py.com.tropical.services.IMenuService;
import py.com.tropical.services.IPlatoService;

@Controller
public class HomeController {
	
	@Autowired
	IMenuService iMenuService;
	
	@Autowired
	IPlatoService iPlatoService;

	@Autowired
	IMenuConcretoPlatosService iMenuConcretoPlatosService;
	
	@GetMapping({"/home","/"})
	public String dashboard(Model model) {
		model.addAttribute("count_platos", iPlatoService.getCount());
		model.addAttribute("count_menus", iMenuService.getCount());
		model.addAttribute("count_menu_concretos_platos", iMenuConcretoPlatosService.getCount());
		return "index";
	}
}
