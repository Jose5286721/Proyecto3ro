package py.com.tropical.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import py.com.tropical.entity.Menu;
import py.com.tropical.services.IMenuService;

@Controller
public class MenuController {

	@Autowired
	IMenuService iMenuService;
	
	@GetMapping("/menu")
	public String index(Model model){
		model.addAttribute("listadoMenus", iMenuService.getAllMenus());
		return "menus/index";
	}
	
	@GetMapping("/menu/create")
	public String create(Model model) {
		model.addAttribute("menu", new Menu());
		return "menus/create";
	}
	
	@PostMapping("/menu")
	public String store(Menu menu) {
		iMenuService.insertar(menu);
		return "redirect:/menu";
	}
}
