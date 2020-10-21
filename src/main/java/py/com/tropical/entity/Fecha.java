package py.com.tropical.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="fechas")
public class Fecha {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	Menu menu;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date fecha;
	
	@Column(length=10)
	String temperatura;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "fecha",cascade = CascadeType.PERSIST)
	@JsonManagedReference
	List<MenuConcretoPlatos> menuConcretoPlatos;

	public Long getId() {
		return id;
	}

	public List<MenuConcretoPlatos> getMenuConcretoPlatos() {
		return menuConcretoPlatos;
	}

	public void setMenuConcretoPlatos(List<MenuConcretoPlatos> menuConcretoPlatos) {
		this.menuConcretoPlatos = menuConcretoPlatos;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void addMenuConcretoPlatos(MenuConcretoPlatos menuConcretoPlatos) {
		this.menuConcretoPlatos.add(menuConcretoPlatos);
	}
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTemperatura() {
		return temperatura;
	}

	public Fecha(Long id, Menu menu, Date fecha, String temperatura, List<MenuConcretoPlatos> menuConcretoPlatos) {
		super();
		this.id = id;
		this.menu = menu;
		this.fecha = fecha;
		this.temperatura = temperatura;
		this.menuConcretoPlatos = menuConcretoPlatos;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public Fecha(Long id, Date fecha, String temperatura) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.temperatura = temperatura;
	}
	
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Fecha() {
		this.menuConcretoPlatos = new ArrayList<>();
	}
}
