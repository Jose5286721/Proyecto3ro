package py.com.tropical.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.tropical.entity.MenuConcretoPlatos;
import py.com.tropical.repository.IMenuConcretoPlatosRepository;

@Service
public class IMenuConcretoPlatosServiceImpl implements IMenuConcretoPlatosService{

	@Autowired
	IMenuConcretoPlatosRepository iMenuConcretoPlatosRepository;
	
	@Override
	public void save(MenuConcretoPlatos menuConcretoPlatos) {
		iMenuConcretoPlatosRepository.save(menuConcretoPlatos);
	}

	@Override
	public Long getCount() {
		return iMenuConcretoPlatosRepository.count();
	}

}
