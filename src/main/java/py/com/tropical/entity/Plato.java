package py.com.tropical.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="platos")
public class Plato {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@Column(length=45)
	String nombre;
	
	@Column(length=45)
	String descripcion;

	@Column(name="created_at")
	@Temporal(TemporalType.TIMESTAMP)
	Date createdAt;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="plato")
	List<MenuPlatos> menuPlatos;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="plato")
	List<MenuConcretoPlatos> menuConcretoPlatos;
	
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

	public List<MenuConcretoPlatos> getMenuConcretoPlatos() {
		return menuConcretoPlatos;
	}

	public void setMenuConcretoPlatos(List<MenuConcretoPlatos> menuConcretoPlatos) {
		this.menuConcretoPlatos = menuConcretoPlatos;
	}

	@PrePersist
	public void prePersist() {
		createdAt = new Date();
	}
	
	public Plato() {
		
	}
	public Plato(Long id, String nombre, String descripcion, Date createdAt) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.createdAt = createdAt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
