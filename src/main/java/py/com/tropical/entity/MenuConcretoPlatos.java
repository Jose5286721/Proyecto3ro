package py.com.tropical.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="menu_concreto_platos")
public class MenuConcretoPlatos {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	Fecha fecha;
	
	@ManyToOne(fetch=FetchType.LAZY)
	Plato plato;
	
	@Column(name="num_personas")
	Integer numPersonas;

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

	public Integer getNumPersonas() {
		return numPersonas;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	public void setNumPersonas(Integer numPersonas) {
		this.numPersonas = numPersonas;
	}

	public MenuConcretoPlatos(Long id,Fecha fecha,Plato plato, Integer numPersonas) {
		super();
		this.id = id;
		this.plato = plato;
		this.fecha = fecha;
		this.numPersonas = numPersonas;
	}
	
	public MenuConcretoPlatos() {
		
	}
	
}
