package py.com.tropical.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.tropical.entity.MenuPlatos;
import py.com.tropical.repository.IMenuPlatosRepository;

@Service
public class IMenuPlatoServiceImpl implements IMenuPlatoService{

	@Autowired
	IMenuPlatosRepository iMenuPlatosRepository;
	
	@Override
	public void save(MenuPlatos menuPlato) {
		iMenuPlatosRepository.save(menuPlato);
	}

	@Override
	public void saveAll(List<MenuPlatos> menuPlatosList) {
		iMenuPlatosRepository.saveAll(menuPlatosList);
	}
	

}
