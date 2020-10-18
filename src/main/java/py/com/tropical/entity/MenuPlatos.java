package py.com.tropical.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="menu_platos")
public class MenuPlatos {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	Plato plato;
	
	@ManyToOne
	Menu menu;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public MenuPlatos(Long id, Plato plato, Menu menu) {
		super();
		this.id = id;
		this.plato = plato;
		this.menu = menu;
	}

	public MenuPlatos() {
		super();
	}
	
	
}
