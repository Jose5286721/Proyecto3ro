package py.com.tropical.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.tropical.entity.Menu;
import py.com.tropical.repository.IMenuRepository;
import java.util.ArrayList;

@Service
public class IMenuServiceImpl implements IMenuService{

	@Autowired
	IMenuRepository iMenuRepository;
	
	@Override
	public List<Menu> getAllMenus() {
		List<Menu> menus = new ArrayList<>();
		iMenuRepository.findAll().forEach(menu -> {menus.add(menu);});
		return menus;
	}

	@Override
	public void insertar(Menu menu) {
		iMenuRepository.save(menu);
		
	}

}
