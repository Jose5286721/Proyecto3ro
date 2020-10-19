package py.com.tropical.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import py.com.tropical.entity.Menu;
import py.com.tropical.entity.MenuPlatos;
import py.com.tropical.services.IMenuPlatoService;
import py.com.tropical.services.IMenuService;
import py.com.tropical.services.IPlatoService;

@Controller
public class MenuController {

	@Autowired
	IMenuService iMenuService;
	
	@Autowired
	IPlatoService iPlatoService;
	
	@Autowired
	IMenuPlatoService iMenuPlatoService;
	
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
	
	@GetMapping("/menu/{idmenu}")
	public String getAllPlatosMenu(@PathVariable Long idmenu,Model model) {
		model.addAttribute("menu", iMenuService.findById(idmenu));
		return "menus/show";
	}
	
	@GetMapping("/menu/{idmenu}/add")
	public String agregarPlatos(@PathVariable("idmenu") Long idmenu,Model model) {
		model.addAttribute("platos", iPlatoService.getPlatos());
		model.addAttribute("menu_id", idmenu);
		return "menus/addplatos";
	}
	
	@PostMapping("/menu/{idmenu}")
	public String storeAgregadoPlatoMenu(@PathVariable Long idmenu,@RequestParam Long plato) {
		MenuPlatos menuPlato = new MenuPlatos();
		menuPlato.setMenu(iMenuService.findById(idmenu));
		menuPlato.setPlato(iPlatoService.buscarPlatoPorId(plato));
		iMenuPlatoService.save(menuPlato);
		return "redirect:/menu";
	}
}
