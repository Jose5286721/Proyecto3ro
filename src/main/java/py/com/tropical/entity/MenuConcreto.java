package py.com.tropical.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="menu_concreto")
public class MenuConcreto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@OneToOne(fetch=FetchType.LAZY)
	Menu menu;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="menuConcreto")
	List<MenuConcretoPlatos> menuConcretoPlatos;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="menuConcreto")
	List<Fecha> fecha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<MenuConcretoPlatos> getMenuConcretoPlatos() {
		return menuConcretoPlatos;
	}

	public void setMenuConcretoPlatos(List<MenuConcretoPlatos> menuConcretoPlatos) {
		this.menuConcretoPlatos = menuConcretoPlatos;
	}

	public List<Fecha> getFecha() {
		return fecha;
	}

	public void setFecha(List<Fecha> fecha) {
		this.fecha = fecha;
	}

	public MenuConcreto(Long id, Menu menu, List<MenuConcretoPlatos> menuConcretoPlatos, List<Fecha> fecha) {
		super();
		this.id = id;
		this.menu = menu;
		this.menuConcretoPlatos = menuConcretoPlatos;
		this.fecha = fecha;
	}
	
	public MenuConcreto() {
		
	}
}
