package py.com.tropical.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import java.util.Date;
import javax.persistence.TemporalType;

@Entity
@Table(name="fechas")
public class Fecha {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	MenuConcreto menuConcreto;
	
	@Temporal(TemporalType.DATE)
	Date fecha;
	
	@Column(length=10)
	String temperatura;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MenuConcreto getMenuConcreto() {
		return menuConcreto;
	}

	public void setMenuConcreto(MenuConcreto menuConcreto) {
		this.menuConcreto = menuConcreto;
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

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public Fecha(Long id, MenuConcreto menuConcreto, Date fecha, String temperatura) {
		super();
		this.id = id;
		this.menuConcreto = menuConcreto;
		this.fecha = fecha;
		this.temperatura = temperatura;
	}
	
	public Fecha() {
		
	}
}
