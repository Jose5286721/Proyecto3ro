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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;

import py.com.tropical.entity.Menu;
import py.com.tropical.entity.MenuPlatos;
import py.com.tropical.entity.Plato;
import py.com.tropical.services.IMenuPlatoService;
import py.com.tropical.services.IMenuService;
import py.com.tropical.services.IPlatoService;
import java.util.ArrayList;

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
	public String store(Menu menu,@RequestParam String platos) {
		JsonParser jsonParser = JsonParserFactory.getJsonParser();
		List<Plato> platosLista = new ArrayList<>();
		List<Object> objectosPlatos = jsonParser.parseList(platos);
		ObjectMapper objectMapper = new ObjectMapper();
		platosLista = objectMapper.convertValue(objectosPlatos, new TypeReference<List<Plato>>() {});
		List<MenuPlatos> menuPlatosLista = new ArrayList<>();
		MenuPlatos menuPlatoaux;
		for(Plato plato : platosLista) {
			menuPlatoaux = new MenuPlatos();
			menuPlatoaux.setPlato(plato);
			menuPlatosLista.add(menuPlatoaux);
			menu.addMenuPlato(menuPlatoaux);
		}
		iMenuService.insertar(menu);
		return "redirect:/menu";
	}
	
	@GetMapping("/api/menu")
	public ResponseEntity<?> getAllMenus(){
		return ResponseEntity.ok(iMenuService.getAllMenus());
	}
	
	@GetMapping("/api/menu/{idmenu}")
	public ResponseEntity<?> getMenu(@PathVariable Long idmenu){
		return ResponseEntity.ok(iMenuService.findById(idmenu));
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
	
	@GetMapping("/menu/{idmenu}/edit")
	public String edit(@PathVariable Long idmenu,Model model) {
		model.addAttribute("menu",iMenuService.findById(idmenu));
		return "menus/edit";
	}
	
	@PostMapping("/menu/{idmenu}/edit")
	public String edit(@PathVariable Long idmenu,Menu menu) {
		Menu menuAux = iMenuService.findById(idmenu);
		menuAux.setNombre(menu.getNombre());
		iMenuService.insertar(menuAux);
		return "redirect:/menu";
	}
	
	@PostMapping("/menu/{idmenu}")
	public String storeAgregadoPlatoMenu(@PathVariable Long idmenu,@RequestParam Long plato) {
		Menu menu = iMenuService.findById(idmenu);
		MenuPlatos menuPlato = new MenuPlatos();
		menuPlato.setPlato(iPlatoService.buscarPlatoPorId(plato));
		menu.addMenuPlato(menuPlato);
		iMenuPlatoService.save(menuPlato);
		iMenuService.insertar(menu);
		return "redirect:/menu";
	}
}
