package py.com.tropical.services;

import py.com.tropical.entity.MenuPlatos;
import java.util.List;

public interface IMenuPlatoService {

	public void save(MenuPlatos menuPlato);
	
	public void saveAll(List<MenuPlatos> menuPlatosList);
}
