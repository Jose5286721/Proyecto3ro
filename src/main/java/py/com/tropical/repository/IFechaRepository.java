package py.com.tropical.repository;


import java.util.Date;

import org.springframework.data.repository.PagingAndSortingRepository;

import py.com.tropical.entity.Fecha;

public interface IFechaRepository extends PagingAndSortingRepository<Fecha, Long>{

	public Iterable<Fecha> findAllByFechaBetween(Date fechaDesde,Date fechaHasta);
}
