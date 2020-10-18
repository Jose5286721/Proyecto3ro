package py.com.tropical.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	Long id;
	
	String nombre;
	
	@Column(name="created_at")
	Date createdAt;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="menu")
	List<MenuPlatos> menuPlatos;
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy="menu")
	MenuConcreto menuConcreto;
	
	
	
	public MenuConcreto getMenuConcreto() {
		return menuConcreto;
	}

	public void setMenuConcreto(MenuConcreto menuConcreto) {
		this.menuConcreto = menuConcreto;
	}

	@PrePersist
	public void prePersist() {
		createdAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<MenuPlatos> getMenuPlatos() {
		return menuPlatos;
	}

	public void setMenuPlatos(List<MenuPlatos> menuPlatos) {
		this.menuPlatos = menuPlatos;
	}

	public Menu(Long id, Date createdAt, List<MenuPlatos> menuPlatos, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.createdAt = createdAt;
		this.menuPlatos = menuPlatos;
	}

	public Menu() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	

}
