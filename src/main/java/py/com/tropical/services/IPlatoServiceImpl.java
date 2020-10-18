package py.com.tropical.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import py.com.tropical.entity.Plato;
import py.com.tropical.repository.IPlatoRepository;

@Service
public class IPlatoServiceImpl implements IPlatoService{

	@Autowired
	IPlatoRepository iPlatoRepository;
	
	@Override
	public List<Plato> getPlatos() {
		List platos = new ArrayList<>();
		iPlatoRepository.findAll().forEach(plato->{platos.add(plato);});
		return platos;
	}

	@Override
	public Page<Plato> getPlatosByPage(Pageable pageable) {
		return iPlatoRepository.findAll(pageable);
	}

	@Override
	public void insertPlato(Plato plato) {
		iPlatoRepository.save(plato);
		
	}

	@Override
	public void eliminarPlato(Long id) {
		iPlatoRepository.deleteById(id);
	}

	@Override
	public Plato buscarPlatoPorId(Long id) {
		return iPlatoRepository.findById(id).orElse(new Plato());
	}

}
