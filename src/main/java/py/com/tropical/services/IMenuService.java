package py.com.tropical.services;

import py.com.tropical.entity.Menu;
import java.util.List;
public interface IMenuService {

	public List<Menu> getAllMenus();
	public void insertar(Menu menu);
}
