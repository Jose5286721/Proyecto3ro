package py.com.tropical.services;

import java.util.Date;
import java.util.List;

import py.com.tropical.entity.Fecha;

public interface IFechaService {
	public void save(Fecha fecha);
	public List<Fecha> findAllByFechaFilter(Date desde,Date hasta);
}
