package py.com.tropical.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import py.com.tropical.entity.Menu;
import py.com.tropical.entity.MenuConcretoPlatos;
import py.com.tropical.entity.Plato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import py.com.tropical.entity.Fecha;
import py.com.tropical.services.IFechaService;
@Controller
public class FechasController {

	@Autowired
	IFechaService iFechaService;
	
	
	@GetMapping("/fechas")
	public String index() {
		return "fechas/index";
	}
	
	@GetMapping("/fechas/filter")
	public String getFechasByFilters(@RequestParam String desde,@RequestParam String hasta,Model model) throws ParseException{
		model.addAttribute("fechas", iFechaService.findAllByFechaFilter(new SimpleDateFormat("yyyy-MM-dd").parse(desde), new SimpleDateFormat("yyyy-MM-dd").parse(hasta)));
		return "fechas/show";
	}
	
	@PostMapping("/api/fechas")
	public ResponseEntity<?> getAllFechasByFilters(@RequestParam String desde,@RequestParam String hasta) throws ParseException{
		List<Fecha> fechas = iFechaService.findAllByFechaFilter(new SimpleDateFormat("yyyy-MM-dd").parse(desde), new SimpleDateFormat("yyyy-MM-dd").parse(hasta));
		return ResponseEntity.ok(fechas);
	}
	
	
	@GetMapping("/fechas/create")
	public String create() {
		return "fechas/create";
	}
	
	
	@PostMapping("/fechas")
	public String store(@RequestParam String fecha,@RequestParam String menu,@RequestParam String temperatura,@RequestParam String personas,@RequestParam String plato) throws JsonMappingException, JsonProcessingException, ParseException {
		ObjectMapper objectMapper = new ObjectMapper();
		Menu menuObj = objectMapper.readValue(menu,Menu.class);
		Plato platoObj = objectMapper.readValue(plato, Plato.class);
		Date fechaSeleccionada = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
		Fecha fechaAux = new Fecha();
		fechaAux.setFecha(fechaSeleccionada);
		fechaAux.setMenu(menuObj);
		fechaAux.setTemperatura(temperatura);
		MenuConcretoPlatos menuConcretoPlatos = new MenuConcretoPlatos();
		menuConcretoPlatos.setFecha(fechaAux);
		menuConcretoPlatos.setNumPersonas(Integer.parseInt(personas));
		menuConcretoPlatos.setPlato(platoObj);
		fechaAux.addMenuConcretoPlatos(menuConcretoPlatos);
		iFechaService.save(fechaAux);
		return "redirect:/fechas";
	}
}
