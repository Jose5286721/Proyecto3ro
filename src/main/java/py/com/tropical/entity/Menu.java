package py.com.tropical.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="menus")
public class Menu {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	Long id;
	
	String nombre;
	
	@Column(name="created_at")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	Date createdAt;
	
	@OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinColumn(name="menu_id")
	List<MenuPlatos> menuPlatos;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="menu")
	@JsonIgnore
	List<Fecha> fechas;
	

	public List<Fecha> getFechas() {
		return fechas;
	}

	public void setFechas(List<Fecha> fechas) {
		this.fechas = fechas;
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
		this.menuPlatos = new ArrayList<>();
	}
	
	public void addMenuPlato(MenuPlatos menuPlatos) {
		this.menuPlatos.add(menuPlatos);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	

}
