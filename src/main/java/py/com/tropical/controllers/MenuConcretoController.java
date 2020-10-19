package py.com.tropical.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import py.com.tropical.entity.MenuConcreto;
import py.com.tropical.services.IMenuConcretoService;
import py.com.tropical.services.IMenuService;
import py.com.tropical.services.IPlatoService;

@Controller
public class MenuConcretoController {
	@Autowired 
	IMenuConcretoService iMenuConcretoService;
	
	@Autowired
	IMenuService iMenuService;
	
	@Autowired 
	IPlatoService iPlatoService;
	
	@GetMapping("/menuconcretos")
	public String index() {
		return "menusConcretos/index";
	}
	
	@GetMapping("/menuconcretos/create")
	public String create(Model model) {
		model.addAttribute("menus", iMenuService.getAllMenus());
		model.addAttribute("platos", iPlatoService.getPlatos());
		return "menusConcretos/create";
	}
	
	@PostMapping("/menuconcretos")
	public String store(@RequestBody HttpServletRequest request) {
		MenuConcreto menuConcreto = new MenuConcreto();
		menuConcreto.setMenu(iMenuService.findById(Long.parseLong(request.getParameter("menu"))));
		return "redirect:/menuconcretos";
	}
}
