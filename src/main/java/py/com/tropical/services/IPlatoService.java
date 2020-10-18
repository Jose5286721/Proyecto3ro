package py.com.tropical.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import py.com.tropical.entity.Plato;

public interface IPlatoService {
	public List<Plato> getPlatos();
	public Page<Plato> getPlatosByPage(Pageable pageable);
	public void insertPlato(Plato plato);
	public void eliminarPlato(Long id);
	public Plato buscarPlatoPorId(Long id);
}
