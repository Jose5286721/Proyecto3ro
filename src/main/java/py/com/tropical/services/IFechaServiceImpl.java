package py.com.tropical.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.tropical.entity.Fecha;
import py.com.tropical.repository.IFechaRepository;

@Service
public class IFechaServiceImpl implements IFechaService{

	@Autowired 
	IFechaRepository iFechaRepository;
	
	@Override
	public void save(Fecha fecha) {
		iFechaRepository.save(fecha);
	}

	@Override
	public List<Fecha> findAllByFechaFilter(Date desde, Date hasta) {
		List<Fecha> fechas = new ArrayList<>();
		iFechaRepository.findAllByFechaBetween(desde, hasta).forEach(fecha -> fechas.add(fecha));
		return fechas;
	}

}
