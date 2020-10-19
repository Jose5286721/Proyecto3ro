package py.com.tropical.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import py.com.tropical.entity.MenuConcreto;
import py.com.tropical.repository.IMenuConcretoRepository;

@Service
public class IMenuConcretoServiceImpl implements IMenuConcretoService{

	@Autowired
	IMenuConcretoRepository iMenuConcretoRepository;
	
	@Override
	public List<MenuConcreto> getAllMenuConcretos() {
		List<MenuConcreto> listaMenusConcretos = new ArrayList<>();
		iMenuConcretoRepository.findAll().forEach(menuConcreto -> listaMenusConcretos.add(menuConcreto));
		return listaMenusConcretos;
	}

}
